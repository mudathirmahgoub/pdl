package pdl.ast;

import edu.uiowa.smt.smtAst.Expression;
import pdl.printers.PdlAstVisitor;
import pdl.translator.PdlToSmtTranslator;

public class Skip extends Program
{
    private final static Skip instance = new Skip();

    private Skip()
    {
    }

    public static Skip getInstance()
    {
        return instance;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof Skip))
        {
            return false;
        }
        return true;
    }

    @Override
    public Expression translate(PdlToSmtTranslator translator)
    {
        return translator.statesIdentity;
    }

    @Override
    public void accept(PdlAstVisitor visitor)
    {
        visitor.visit(this);
    }
}
