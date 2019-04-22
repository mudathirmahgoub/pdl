package pdl.translator;

import edu.uiowa.smt.AbstractTranslator;
import edu.uiowa.smt.smtAst.Assertion;
import edu.uiowa.smt.smtAst.Expression;
import edu.uiowa.smt.smtAst.SmtProgram;
import pdl.ast.KripkeFrame;
import pdl.ast.PdlProgram;
import pdl.ast.Transition;

import java.util.List;
import java.util.Map;

public class PdlToSmtTranslator extends AbstractTranslator
{
    private final PdlProgram pdlProgram;
    private final SmtProgram smtProgram;

    public PdlToSmtTranslator(PdlProgram program)
    {
        this.pdlProgram = program;
        this.smtProgram = new SmtProgram();
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
            throw new UnsupportedOperationException();
        }

        for (Map.Entry<String, List<Transition>> entry : frame.getPrograms().entrySet())
        {
            throw new UnsupportedOperationException();
        }

    }

    private void translateFormula()
    {
        Expression expression = this.pdlProgram.getFormula().translate(this);
        Assertion assertion = new Assertion("Main formula", expression);
        smtProgram.addAssertion(assertion);
    }
}
