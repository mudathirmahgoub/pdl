package pdl.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class KripkeFrame extends PdlAst
{
    private final List<String> states;
    private final Map<String, List<String>> propositions;
    private final Map<String, List<Transition>> programs;

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
        if(states.size() == 0)
        {
            stringBuilder.append("K = {}");
        }
        else if(states.size() == 1)
        {
            stringBuilder.append(String.format("K = {%s}", states.get(0)));
        }
        else
        {
            stringBuilder.append("K = {");
            for (int i = 0; i < states.size() - 1; i++)
            {
                stringBuilder.append(String.format("%s, ", states.get(i)));
            }
            stringBuilder.append(String.format("%s}", states.get(states.size() - 1)));
        }

        stringBuilder.append("\n");

        for (String name: propositions.keySet())
        {
            stringBuilder.append(String.format("m(%s) = ", name));
            List<String> propositionStates = propositions.get(name);
            if(propositionStates.size() == 0)
            {
                stringBuilder.append("{}");
            }
            else if(propositionStates.size() == 1)
            {
                stringBuilder.append(String.format("{%s}", propositionStates.get(0)));
            }
            else
            {
                stringBuilder.append("{");
                for (int i = 0; i < propositionStates.size() - 1; i++)
                {
                    stringBuilder.append(String.format("%s, ", propositionStates.get(i)));
                }
                stringBuilder.append(String.format("%s}", propositionStates.get(propositionStates.size() - 1)));
            }
        }

        stringBuilder.append("\n");

        for (String name: programs.keySet())
        {
            stringBuilder.append(String.format("m(%s) = ", name));
            List<Transition> transitions = programs.get(name);
            if(transitions.size() == 0)
            {
                stringBuilder.append("{}");
            }
            else if(transitions.size() == 1)
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
}
