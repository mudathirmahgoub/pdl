package pdl.translator;

import edu.uiowa.smt.TranslatorUtils;
import edu.uiowa.smt.cvc4.Cvc4Process;
import edu.uiowa.smt.printers.SmtLibPrettyPrinter;
import edu.uiowa.smt.smtAst.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import pdl.ast.PdlProgram;
import pdl.parser.PdlProgramVisitor;
import pdl.parser.antlr.PdlLexer;
import pdl.parser.antlr.PdlParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PdlUtils
{
    public static PdlProgram parseProgram(String model)
    {
        CharStream charStream = CharStreams.fromString(model);

        PdlLexer lexer = new PdlLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        PdlParser parser = new PdlParser(tokenStream);

        ParseTree tree = parser.pdl();
        PdlProgramVisitor visitor = new PdlProgramVisitor();
        PdlProgram program = (PdlProgram) visitor.visit(tree);
        return program;
    }

    public static PdlResult runCVC4(String pdl) throws Exception
    {
        PdlProgram pdlProgram = parseProgram(pdl);
        PdlResult result = new PdlResult(pdlProgram);
        PdlToSmtTranslator translator = new PdlToSmtTranslator(pdlProgram);
        SmtProgram smtProgram = translator.translate();
        SmtLibPrettyPrinter printer = new SmtLibPrettyPrinter();
        printer.visit(smtProgram);
        String smtScript = printer.getSmtLib();
        Cvc4Process process = Cvc4Process.start();
        TranslatorUtils.setSolverOptions(process);
        process.sendCommand(smtScript);
        result.smtProgram = smtScript + SmtLibPrettyPrinter.CHECK_SAT + "\n";
        result.satResult = process.sendCommand(SmtLibPrettyPrinter.CHECK_SAT);

        if (result.satResult.equals("sat"))
        {
            result.smtProgram = result.smtProgram + SmtLibPrettyPrinter.GET_MODEL + "\n";
            String model = process.sendCommand(SmtLibPrettyPrinter.GET_MODEL);
            result.smtModel = result.parseModel(model);

            if (pdlProgram.isFrameProvided())
            {
                // Since the current CVC4 diverges when closures are used,
                // the main formula is not asserted if the kripke frame is provided.
                // Instead the formula is evaluated in the given kripke frame
                SmtLibPrettyPrinter valuePrinter = new SmtLibPrettyPrinter();
                Expression mainFormula = translator.getBoolExpression();
                String getValue = valuePrinter.printGetValue(mainFormula);
                String getvalueResult = process.sendCommand(getValue);
                SmtValues smtValues = result.parseValues(getvalueResult);
                BoolConstant constant = (BoolConstant) smtValues.getValue(0);
                result.satResult = constant.getBooleanValue() ? "sat" : "unsat";
                result.smtProgram = result.smtProgram + getValue + "\n";
                if (result.satResult.equals("sat"))
                {
                    getSatisfyingStates(result, translator, process);
                }
            }
            else
            {
                getSatisfyingStates(result, translator, process);
            }
        }
        return result;
    }

    private static void getSatisfyingStates(PdlResult result, PdlToSmtTranslator translator, Cvc4Process process) throws IOException
    {
        // evaluate the expression in the main formula to
        // get the satisfying states
        Expression set = translator.getSetExpression();

        SmtLibPrettyPrinter valuePrinter = new SmtLibPrettyPrinter();
        String getValue = valuePrinter.printGetValue(set);
        String getvalueResult = process.sendCommand(getValue);
        SmtValues smtValues = result.parseValues(getvalueResult);
        Expression value = smtValues.getValue(0);
        result.satisfyingStates = TranslatorUtils.getAtomSet(value);
        if (result.pdlProgram.isFrameProvided())
        {
            // replace cvc4 uninterpreted constants with the corresponding states
            Map<String, String> atomsMap = new HashMap<>();
            for (String state : result.pdlProgram.getFrame().getStates())
            {
                FunctionDefinition definition = TranslatorUtils.getFunctionDefinition(result.smtModel, state);
                String cvc4State = TranslatorUtils.getAtomSet(definition)
                                                  .stream().collect(Collectors.toList()).get(0);
                atomsMap.put(cvc4State, state);
            }
            result.satisfyingStates = result.satisfyingStates
                    .stream().map(s -> atomsMap.get(s)).collect(Collectors.toSet());
        }
    }
}
