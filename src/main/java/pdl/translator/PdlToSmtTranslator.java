package pdl.translator;

import edu.uiowa.smt.AbstractTranslator;
import edu.uiowa.smt.smtAst.*;
import pdl.ast.KripkeFrame;
import pdl.ast.PdlProgram;
import pdl.ast.Transition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PdlToSmtTranslator extends AbstractTranslator
{
    private final PdlProgram pdlProgram;
    private final SmtProgram smtProgram;

    public Expression statesUniverse;
    public Expression statesIdentity;
    public Map<String, FunctionDeclaration> propositionMap;
    public Map<String, FunctionDeclaration> programsMap;
    public Map<String, FunctionDeclaration> statesMap;

    PdlToSmtTranslator(PdlProgram program)
    {
        this.pdlProgram = program;
        this.smtProgram = new SmtProgram();
        this.propositionMap = new HashMap<>();
        this.programsMap = new HashMap<>();
        statesMap = new HashMap<>();
        statesUniverse = atomUniverse.getVariable();
        statesIdentity = atomIdentity.getVariable();

        translateSpecialFunctions();
    }

    private void translateSpecialFunctions()
    {
        this.smtProgram.addSort(atomSort);
        this.smtProgram.addSort(uninterpretedInt);
        translateAtomUniverse();
        translateAtomIdentity();
    }

    private void translateAtomUniverse()
    {
        this.smtProgram.addFunction(atomUniverse);
        Expression universe = new UnaryExpression(UnaryExpression.Op.UNIVSET, setOfUnaryAtomSort);
        Expression equal = new BinaryExpression(statesUniverse, BinaryExpression.Op.EQ, universe);
        Assertion assertion = new Assertion("Universe definition for Atoms", equal);
        this.smtProgram.addAssertion(assertion);
    }

    private void translateAtomIdentity()
    {
        this.smtProgram.addFunction(atomIdentity);
        VariableDeclaration x = new VariableDeclaration("_x", AbstractTranslator.atomSort);
        Expression xPair = new MultiArityExpression(MultiArityExpression.Op.MKTUPLE, x.getVariable(), x.getVariable());
        Expression xPairMember = new BinaryExpression(xPair, BinaryExpression.Op.MEMBER, statesIdentity);
        Expression axiom1 = new QuantifiedExpression(QuantifiedExpression.Op.FORALL, xPairMember, x);

        VariableDeclaration y = new VariableDeclaration("_y", AbstractTranslator.atomSort);

        Expression xyPair = new MultiArityExpression(MultiArityExpression.Op.MKTUPLE, x.getVariable(), y.getVariable());

        Expression xyPairMember = new BinaryExpression(xyPair, BinaryExpression.Op.MEMBER, statesIdentity);

        Expression equal = new BinaryExpression(x.getVariable(), BinaryExpression.Op.EQ, y.getVariable());

        Expression implies = new BinaryExpression(xyPairMember, BinaryExpression.Op.IMPLIES, equal);

        Expression axiom2 = new QuantifiedExpression(QuantifiedExpression.Op.FORALL, implies, x, y);

        Assertion assertion1 = new Assertion("Identity axiom 1 for Atoms", axiom1);
        this.smtProgram.addAssertion(assertion1);
        Assertion assertion2 = new Assertion("Identity axiom 2 for Atoms", axiom2);
        this.smtProgram.addAssertion(assertion2);
    }

    @Override
    public SmtProgram translate()
    {
        translateFrame();
        translateFormula();
        return smtProgram;
    }

    private void translateFrame()
    {
        KripkeFrame frame = pdlProgram.getFrame();
        if (pdlProgram.isFrameProvided())
        {
            translateFrameStates(frame);
        }

        for (Map.Entry<String, List<String>> entry : frame.getPropositions().entrySet())
        {
            String name = entry.getKey();
            FunctionDeclaration declaration = new FunctionDeclaration(name, AbstractTranslator.setOfUnaryAtomSort);
            this.propositionMap.put(name, declaration);
            this.smtProgram.addFunction(declaration);
            if (pdlProgram.isFrameProvided())
            {
                translatePropositionStates(entry.getValue(), declaration);
            }
        }

        for (Map.Entry<String, List<Transition>> entry : frame.getPrograms().entrySet())
        {
            String name = entry.getKey();
            FunctionDeclaration declaration = new FunctionDeclaration(name, AbstractTranslator.setOfBinaryAtomSort);
            this.programsMap.put(name, declaration);
            this.smtProgram.addFunction(declaration);
            if (pdlProgram.isFrameProvided())
            {
                translateProgramTransitions(entry.getValue(), declaration);
            }
        }
    }

    private void translateProgramTransitions(List<Transition> transitions, FunctionDeclaration declaration)
    {
        if (transitions.size() == 0)
        {
            // program is empty
            Expression emptySet = new UnaryExpression(UnaryExpression.Op.EMPTYSET, AbstractTranslator.setOfBinaryAtomSort);
            Expression equality = new BinaryExpression(emptySet, BinaryExpression.Op.EQ,
                    declaration.getVariable());
            Assertion assertion = new Assertion(declaration.getName() + " is empty ", equality);
            smtProgram.addAssertion(assertion);
        }
        else
        {
            List<Expression> sets = transitions.stream()
                                          .map(t -> getSingletonTransition(t))
                                          .collect(Collectors.toList());
            Expression union = sets.get(0);
            if(sets.size() > 1)
            {
                for (int i = 1; i < sets.size(); i++)
                {
                    union = new BinaryExpression(union, BinaryExpression.Op.UNION, sets.get(i));
                }
            }
            Expression equality = new BinaryExpression(declaration.getVariable(), BinaryExpression.Op.EQ, union);
            Assertion assertion = new Assertion("Atomic program " + declaration.getName(), equality);
            smtProgram.addAssertion(assertion);
        }
    }

    private Expression getSingletonTransition(Transition transition)
    {
        if (!statesMap.containsKey(transition.inputState))
        {
            throw new RuntimeException(String.format("Input state '%s' is not defined in K", transition.inputState));
        }
        if (!statesMap.containsKey(transition.outputState))
        {
            throw new RuntimeException(String.format("Output state '%s' is not defined in K", transition.outputState));
        }

        Expression input = statesMap.get(transition.inputState).getVariable();
        Expression output = statesMap.get(transition.outputState).getVariable();
        Expression tuple = new MultiArityExpression(MultiArityExpression.Op.MKTUPLE, input, output);
        Expression singleton = new UnaryExpression(UnaryExpression.Op.SINGLETON, tuple);
        return singleton;
    }

    private void translatePropositionStates(List<String> states, FunctionDeclaration declaration)
    {
        if (states.size() == 0)
        {
            // proposition is empty
            Expression emptySet = new UnaryExpression(UnaryExpression.Op.EMPTYSET, AbstractTranslator.setOfUnaryAtomSort);
            Expression equality = new BinaryExpression(emptySet, BinaryExpression.Op.EQ,
                    declaration.getVariable());
            Assertion assertion = new Assertion(declaration.getName() + " is empty ", equality);
            smtProgram.addAssertion(assertion);
        }
        else
        {
            List<Expression> sets = states.stream()
                                          .map(s -> getSingletonState(s))
                                          .collect(Collectors.toList());
            Expression union = sets.get(0);
            if(sets.size() > 1)
            {
                for (int i = 1; i < sets.size(); i++)
                {
                    union = new BinaryExpression(union, BinaryExpression.Op.UNION, sets.get(i));
                }
            }
            Expression equality = new BinaryExpression(declaration.getVariable(), BinaryExpression.Op.EQ, union);
            Assertion assertion = new Assertion("Atomic proposition " + declaration.getName(), equality);
            smtProgram.addAssertion(assertion);
        }
    }

    private Expression getSingletonState(String state)
    {
        if (!statesMap.containsKey(state))
        {
            throw new RuntimeException(String.format("State '%s' is not defined in K", state));
        }
        Expression variable = statesMap.get(state).getVariable();
        Expression tuple = new MultiArityExpression(MultiArityExpression.Op.MKTUPLE, variable);
        Expression singleton = new UnaryExpression(UnaryExpression.Op.SINGLETON, tuple);
        return singleton;
    }

    private void translateFrameStates(KripkeFrame frame)
    {
        if (frame.getStates().size() > 0)
        {
            for (String state : frame.getStates())
            {
                FunctionDeclaration stateFunction = new FunctionDeclaration(state, AbstractTranslator.atomSort);
                statesMap.put(state, stateFunction);
                smtProgram.addFunction(stateFunction);
            }

            // states are distinct
            List<Expression> statesVariables = statesMap.values()
                                                        .stream().map(s -> s.getVariable())
                                                        .collect(Collectors.toList());
            Expression distinct = new MultiArityExpression(MultiArityExpression.Op.DISTINCT, statesVariables);
            Assertion assertion1 = new Assertion("Frame states are distinct", distinct);
            smtProgram.addAssertion(assertion1);

            // the universe set should be equal to the union of frame states
            List<Expression> statesTuples = statesVariables
                    .stream()
                    .map(s -> new MultiArityExpression(MultiArityExpression.Op.MKTUPLE, s))
                    .map(s -> new UnaryExpression(UnaryExpression.Op.SINGLETON, s))
                    .collect(Collectors.toList());
            Expression statesSet = statesTuples.get(0);
            if (statesTuples.size() > 1)
            {
                for (int i = 1; i < statesTuples.size(); i++)
                {
                    statesSet = new BinaryExpression(statesSet, BinaryExpression.Op.UNION, statesTuples.get(i));
                }

            }
            Expression equality = new BinaryExpression(statesUniverse, BinaryExpression.Op.EQ, statesSet);
            Assertion assertion2 = new Assertion(atomUniverse.getName() + " = frame states", equality);
            smtProgram.addAssertion(assertion2);
        }
    }

    private void translateFormula()
    {
        Expression expression = this.pdlProgram.getFormula().translate(this);
        Expression emptySet = new UnaryExpression(UnaryExpression.Op.EMPTYSET, AbstractTranslator.setOfUnaryAtomSort);
        Expression equal = new BinaryExpression(expression, BinaryExpression.Op.EQ, emptySet);
        Expression not = new UnaryExpression(UnaryExpression.Op.NOT, equal);
        Assertion assertion = new Assertion("Main formula", not);
        smtProgram.addAssertion(assertion);
    }
}
