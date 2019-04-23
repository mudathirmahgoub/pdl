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
    public Map<String, FunctionDeclaration> propositionMap;

    PdlToSmtTranslator(PdlProgram program)
    {
        this.pdlProgram = program;
        this.smtProgram = new SmtProgram();
        this.propositionMap = new HashMap<>();

        this.smtProgram.addSort(atomSort);
        this.smtProgram.addSort(uninterpretedInt);
        this.smtProgram.addFunction(atomUniverse);
        statesUniverse =  AbstractTranslator.atomUniverse.getVariable();
        this.smtProgram.addAssertion(new Assertion("Universe definition for Atom", new BinaryExpression(atomUniverse.getVariable(), BinaryExpression.Op.EQ, new UnaryExpression(UnaryExpression.Op.UNIVSET, setOfUnaryAtomSort))));
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
            this.propositionMap.put(entry.getKey(), declaration);
            this.smtProgram.addFunction(declaration);
            for (String state: entry.getValue())
            {
                throw new UnsupportedOperationException();
            }
        }

        for (Map.Entry<String, List<Transition>> entry : frame.getPrograms().entrySet())
        {
            throw new UnsupportedOperationException();
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
