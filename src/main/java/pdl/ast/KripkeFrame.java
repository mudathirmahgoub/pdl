package pdl.ast;

import edu.uiowa.smt.TranslatorUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;


public class KripkeFrame extends PdlAst
{
    private final List<String> states;
    private final Map<String, List<String>> propositions;
    private final Map<String, List<Transition>> programs;

    // replace @uc_Atom_ with empty string
    public static final String atomReplacement = "";

    public KripkeFrame(List<String> states, Map<String, List<String>> propositions, Map<String, List<Transition>> programs)
    {
        this.states = states;
        this.propositions = propositions;
        this.programs = programs;
    }

    public List<String> getStates()
    {
        return states;
    }

    public Map<String, List<String>> getPropositions()
    {
        return propositions;
    }

    public Map<String, List<Transition>> getPrograms()
    {
        return programs;
    }

    public void addProposition(String proposition)
    {
        List<String> propositionStates = new ArrayList<>();
        this.propositions.put(proposition, propositionStates);
    }

    public void addProgram(String program)
    {
        List<Transition> transitions = new ArrayList<>();
        this.programs.put(program, transitions);
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof KripkeFrame))
        {
            return false;
        }
        KripkeFrame frame = (KripkeFrame) object;
        return this.states.equals(frame.states) &&
                this.propositions.equals(frame.propositions) &&
                this.programs.equals(frame.programs);
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        if (states.size() == 0)
        {
            stringBuilder.append("K = {}");
        }
        else if (states.size() == 1)
        {
            stringBuilder.append(String.format("K = {%s}",
                    TranslatorUtils.getFriendlyAtom(states.get(0), atomReplacement)));
        }
        else
        {
            stringBuilder.append("K = {");
            for (int i = 0; i < states.size() - 1; i++)
            {
                stringBuilder.append(String.format("%s, ",
                        TranslatorUtils.getFriendlyAtom(states.get(i), atomReplacement)));
            }
            stringBuilder.append(String.format("%s}",
                    TranslatorUtils.getFriendlyAtom(states.get(states.size() - 1), atomReplacement)));
        }

        stringBuilder.append("\n");

        for (String name : propositions.keySet())
        {
            stringBuilder.append(String.format("m(%s) = ", name));
            List<String> propositionStates = propositions.get(name);
            if (propositionStates.size() == 0)
            {
                stringBuilder.append("{}");
            }
            else if (propositionStates.size() == 1)
            {
                stringBuilder.append(String.format("{%s}",
                        TranslatorUtils.getFriendlyAtom(propositionStates.get(0), atomReplacement)));
            }
            else
            {
                stringBuilder.append("{");
                for (int i = 0; i < propositionStates.size() - 1; i++)
                {
                    stringBuilder.append(String.format("%s, ",
                            TranslatorUtils.getFriendlyAtom(propositionStates.get(i), atomReplacement)));
                }
                stringBuilder.append(String.format("%s}",
                        TranslatorUtils
                                .getFriendlyAtom(propositionStates.get(propositionStates.size() - 1),
                                        atomReplacement)));
            }
        }

        stringBuilder.append("\n");

        for (String name : programs.keySet())
        {
            stringBuilder.append(String.format("m(%s) = ", name));
            List<Transition> transitions = programs.get(name);
            if (transitions.size() == 0)
            {
                stringBuilder.append("{}");
            }
            else if (transitions.size() == 1)
            {
                stringBuilder.append(String.format("{%s}", transitions.get(0)));
            }
            else
            {
                stringBuilder.append("{");
                for (int i = 0; i < transitions.size() - 1; i++)
                {
                    stringBuilder.append(String.format("%s, ", transitions.get(i)));
                }
                stringBuilder.append(String.format("%s}", transitions.get(transitions.size() - 1)));
            }
        }

        stringBuilder.append("\n");

        return stringBuilder.toString();
    }

    public void writeToDotFile(String filePath, boolean platnuml)
    {
        String prefix = (platnuml? "@startuml\n" :"") +
                        "digraph foo {\n" +
                        "graph [fontname = \"Consolas\"]\n" +
                        "node [fontname = \"Consolas\"]\n" +
                        "edge [fontname = \"Consolas\"]\n";
        String suffix = "}\n" + (platnuml? "@enduml\n": "");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(prefix);

        for (String state:states)
        {
            // get state propositions
            List<String> statePropositions = new ArrayList<>();
            for (Map.Entry<String, List<String>> entry: propositions.entrySet())
            {
                if(entry.getValue().contains(state))
                {
                    statePropositions.add(entry.getKey());
                }
            }
            // construct the label for the state
            String name = TranslatorUtils.getFriendlyAtom(state, atomReplacement);
            stringBuilder.append(name);

            if(statePropositions.size() == 1)
            {
                stringBuilder.append(String.format("[label=\"%1$s\n%2$s\"]",
                        name, statePropositions.get(0)));
            }
            if(statePropositions.size() > 1)
            {
                stringBuilder.append(String.format("[label=\"%1$s\n", name));
                for (int i = 0; i < statePropositions.size() - 1; i++)
                {
                    stringBuilder.append(statePropositions.get(i) + ",");
                }
                stringBuilder.append(statePropositions.get(statePropositions.size() - 1));
            }
            stringBuilder.append("\n");
        }

        Map<String, Set<String>> edges = new HashMap<>();
        for (Map.Entry<String, List<Transition>> entry : programs.entrySet())
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

        try
        {
            FileUtils.writeStringToFile(new File(filePath), stringBuilder.toString(), StandardCharsets.UTF_8);
            Runtime.getRuntime().exec("java -jar plantuml.jar" + filePath).waitFor();
        }
        catch (Exception exception)
        {
            System.out.println(exception.toString());
            exception.printStackTrace();
        }
    }
}
