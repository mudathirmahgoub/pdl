package pdl.translator;

import edu.uiowa.smt.AbstractTranslator;
import edu.uiowa.smt.smtAst.*;
import pdl.ast.KripkeFrame;
import pdl.ast.PdlProgram;
import pdl.ast.Transition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PdlToSmtTranslator extends AbstractTranslator
{
    private final PdlProgram pdlProgram;
    private final SmtProgram smtProgram;

    public Expression statesUniverse;
    public Expression statesIdentity;
    public Map<String, FunctionDeclaration> propositionMap;
    public Map<String, FunctionDeclaration> programsMap;

    PdlToSmtTranslator(PdlProgram program)
    {
        this.pdlProgram = program;
        this.smtProgram = new SmtProgram();
        this.propositionMap = new HashMap<>();
        this.programsMap = new HashMap<>();
        statesUniverse =  atomUniverse.getVariable();
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
        for (String state: frame.getStates())
        {
            throw new UnsupportedOperationException();
        }

        for (Map.Entry<String, List<String>> entry : frame.getPropositions().entrySet())
        {
            String name = entry.getKey();
            FunctionDeclaration declaration = new FunctionDeclaration(name, AbstractTranslator.setOfUnaryAtomSort);
            this.propositionMap.put(name, declaration);
            this.smtProgram.addFunction(declaration);
            for (String state: entry.getValue())
            {
                throw new UnsupportedOperationException();
            }
        }

        for (Map.Entry<String, List<Transition>> entry : frame.getPrograms().entrySet())
        {
            String name = entry.getKey();
            FunctionDeclaration declaration = new FunctionDeclaration(name, AbstractTranslator.setOfBinaryAtomSort);
            this.programsMap.put(name, declaration);
            this.smtProgram.addFunction(declaration);
            for (Transition transition: entry.getValue())
            {
                throw new UnsupportedOperationException();
            }
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
