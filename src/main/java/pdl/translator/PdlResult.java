package pdl.translator;

import edu.uiowa.smt.AbstractTranslator;
import edu.uiowa.smt.Result;
import edu.uiowa.smt.TranslatorUtils;
import edu.uiowa.smt.smtAst.FunctionDefinition;
import pdl.ast.KripkeFrame;
import pdl.ast.PdlProgram;
import pdl.ast.Transition;

import java.util.*;
import java.util.stream.Collectors;

public class PdlResult extends Result
{
    private final PdlProgram pdlProgram;

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
}
