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
}
