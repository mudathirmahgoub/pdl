package pdl.ast;

import edu.uiowa.smt.smtAst.Expression;
import pdl.translator.PdlToSmtTranslator;

public class Iteration extends Program
{
    private final Program program;

    public Iteration(Program program)
    {
        if (program == null)
        {
            throw new RuntimeException("Program is null");
        }
        this.program = program;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof Iteration))
        {
            return false;
        }
        Iteration iteration = (Iteration) object;
        return this.program.equals(iteration.program);
    }

    @Override
    public Expression translate(PdlToSmtTranslator translator)
    {
        throw new UnsupportedOperationException();
    }
}
