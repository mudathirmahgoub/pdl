package pdl.translator;

import edu.uiowa.smt.AbstractTranslator;
import edu.uiowa.smt.Result;
import edu.uiowa.smt.TranslatorUtils;
import edu.uiowa.smt.cvc4.Cvc4Process;
import edu.uiowa.smt.printers.SmtLibPrettyPrinter;
import edu.uiowa.smt.smtAst.SmtProgram;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import pdl.ast.PdlProgram;
import pdl.parser.PdlProgramVisitor;
import pdl.parser.antlr.PdlLexer;
import pdl.parser.antlr.PdlParser;

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

    public static Result runCVC4(String pdl) throws Exception
    {

        PdlProgram pdlProgram = parseProgram(pdl);
        PdlToSmtTranslator translator = new PdlToSmtTranslator(pdlProgram);
        SmtProgram smtProgram = translator.translate();
        SmtLibPrettyPrinter printer = new SmtLibPrettyPrinter();
        printer.visit(smtProgram);
        String smtScript = printer.getSmtLib();
        Cvc4Process process = Cvc4Process.start();
        TranslatorUtils.setSolverOptions(process);
        process.sendCommand(smtScript);
        String smt = smtScript + AbstractTranslator.CHECK_SAT;
        String satResult = process.sendCommand(AbstractTranslator.CHECK_SAT);
        Result result = new Result(smt, satResult);
        if(satResult.equals("sat"))
        {
            String model = process.sendCommand(AbstractTranslator.GET_MODEL);
            result.smtModel = TranslatorUtils.parseModel(model);
        }
        return result;
    }
}
