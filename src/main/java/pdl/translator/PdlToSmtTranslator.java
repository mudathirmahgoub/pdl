package pdl.translator;

import edu.uiowa.smt.AbstractTranslator;
import edu.uiowa.smt.smtAst.SmtProgram;
import pdl.ast.PdlProgram;

public class PdlToSmtTranslator extends AbstractTranslator
{
    private final PdlProgram program;
    public PdlToSmtTranslator(PdlProgram program)
    {
        this.program = program;
    }

    @Override
    public SmtProgram translate()
    {
        return null;
    }
}
