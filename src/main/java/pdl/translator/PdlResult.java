package pdl.translator;

import edu.uiowa.smt.AbstractTranslator;
import edu.uiowa.smt.Result;
import edu.uiowa.smt.TranslatorUtils;
import edu.uiowa.smt.smtAst.FunctionDefinition;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import pdl.ast.KripkeFrame;
import pdl.ast.PdlProgram;
import pdl.ast.Transition;
import pdl.printers.PdlPrinter;

import java.awt.*;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class PdlResult extends Result
{
    public final PdlProgram pdlProgram;

    public PdlResult(PdlProgram pdlProgram, String smtProgram, String satResult)
    {
        super(smtProgram, satResult);
        this.pdlProgram = pdlProgram;
    }

    public KripkeFrame getResultFrame()
    {
        if (!satResult.equals("sat"))
        {
            throw new RuntimeException("The formula is unsat");
        }

        if (pdlProgram.isFrameProvided())
        {
            return pdlProgram.getFrame();
        }

        KripkeFrame frame = pdlProgram.getFrame();

        FunctionDefinition statesUniverse = TranslatorUtils.getFunctionDefinition(smtModel, AbstractTranslator.atomUniverse.getName());

        List<String> states = TranslatorUtils.getAtomSet(statesUniverse)
                                             .stream()
                                             .collect(Collectors.toList());

        Map<String, List<String>> propsotions = new HashMap<>();
        for (String proposition : frame.getPropositions().keySet())
        {
            FunctionDefinition propositionDefinition = TranslatorUtils.getFunctionDefinition(smtModel, proposition);
            List<String> propositionStates = TranslatorUtils
                    .getAtomSet(propositionDefinition)
                    .stream()
                    .collect(Collectors.toList());
            propsotions.put(proposition, propositionStates);
        }

        Map<String, List<Transition>> programs = new HashMap<>();

        for (String program : frame.getPrograms().keySet())
        {
            FunctionDefinition programDefinition = TranslatorUtils.getFunctionDefinition(smtModel, program);
            List<List<String>> relation = TranslatorUtils.getAtomRelation(programDefinition)
                                                         .stream().collect(Collectors.toList());
            List<Transition> transitions = relation.stream()
                                                   .map(t -> getTransition(t))
                                                   .collect(Collectors.toList());
            programs.put(program, transitions);
        }

        KripkeFrame resultFrame = new KripkeFrame(states, propsotions, programs);
        return resultFrame;
    }

    private Transition getTransition(List<String> tuple)
    {
        String input = tuple.get(0);
        String output = tuple.get(1);
        return new Transition(input, output);
    }

    public void writeToDotFile(String filePath, boolean platnuml)
    {
        StringBuilder stringBuilder = new StringBuilder();

        KripkeFrame frame = getResultFrame();

        String prefix = (platnuml? "@startuml\n" :"") +
                "digraph foo {\n" +
                "graph [fontname = \"Consolas\"]\n" +
                "node [fontname = \"Consolas\"]\n" +
                "edge [fontname = \"Consolas\"]\n";
        String suffix = "}\n" + (platnuml? "@enduml\n": "");

        stringBuilder.append(prefix);

        for (String state: frame.getStates())
        {
            // get state propositions
            List<String> statePropositions = new ArrayList<>();
            for (Map.Entry<String, List<String>> entry: frame.getPropositions().entrySet())
            {
                if(entry.getValue().contains(state))
                {
                    statePropositions.add(entry.getKey());
                }
            }
            // construct the label for the state
            String name = TranslatorUtils.getFriendlyAtom(state, KripkeFrame.atomReplacement);
            stringBuilder.append(name);

            if(statePropositions.size() == 1)
            {
                stringBuilder.append(String.format("[label=\"%1$s\n%2$s\"]",
                        name, statePropositions.get(0)));
            }
            if(statePropositions.size() > 1)
            {
                stringBuilder.append(String.format("[label=\"%1$s\\n", name));
                for (int i = 0; i < statePropositions.size() - 1; i++)
                {
                    stringBuilder.append(statePropositions.get(i) + ",");
                }
                stringBuilder.append(statePropositions.get(statePropositions.size() - 1) + "\"]");
            }
            stringBuilder.append("\n");
        }

        Map<String, Set<String>> edges = new HashMap<>();
        for (Map.Entry<String, List<Transition>> entry : frame.getPrograms().entrySet())
        {
            for (Transition transition: entry.getValue())
            {
                String edge = transition.toString()
                        .replaceAll("\\(", "")
                        .replaceAll("\\)", "")
                        .replaceAll(",", " -> ");
                if(edges.containsKey(edge))
                {
                    edges.get(edge).add(entry.getKey());
                }
                else
                {
                    edges.put(edge, Collections.singleton(entry.getKey()));
                }
            }
        }

        for (Map.Entry<String, Set<String>> edge: edges.entrySet())
        {
            stringBuilder.append(edge.getKey());
            List<String> edgeLabels = new ArrayList<>(edge.getValue());
            if(edgeLabels.size() == 1)
            {
                stringBuilder.append(String.format("[label=\"%s\"]",
                        edgeLabels.get(0)));
            }
            if(edgeLabels.size() > 1)
            {
                stringBuilder.append("[label=\"");
                for (int i = 0; i < edgeLabels.size() - 1; i++)
                {
                    stringBuilder.append(edgeLabels.get(i) + ",");
                }
                stringBuilder.append(edgeLabels.get(edgeLabels.size() - 1) + "\"]");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append(suffix);
        PdlPrinter printer = new PdlPrinter();
        printer.visit(pdlProgram.getFormula());
        stringBuilder.append("// " + printer.print() + "\n");

        try
        {
            FileUtils.writeStringToFile(new File(filePath), stringBuilder.toString(), StandardCharsets.UTF_8);
            Process process = Runtime.getRuntime().exec("java -jar plantuml.jar" + filePath);
            process.waitFor();
            String output = new String(IOUtils.toByteArray(process.getInputStream()), StandardCharsets.UTF_8);
            System.out.println(output);
        }
        catch (Exception exception)
        {
            System.out.println(exception.toString());
            exception.printStackTrace();
        }
    }
}
