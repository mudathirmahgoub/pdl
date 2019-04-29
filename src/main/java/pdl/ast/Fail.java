package pdl.ast;

import edu.uiowa.smt.AbstractTranslator;
import edu.uiowa.smt.smtAst.Expression;
import edu.uiowa.smt.smtAst.UnaryExpression;
import pdl.printers.PdlAstVisitor;
import pdl.translator.PdlToSmtTranslator;

public class Fail extends Program
{
    private final static Fail instance = new Fail();

    private Fail()
    {
    }

    public static Fail getInstance()
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
        if (!(object instanceof Fail))
        {
            return false;
        }
        return true;
    }

    @Override
    public Expression translate(PdlToSmtTranslator translator)
    {
        return new UnaryExpression(UnaryExpression.Op.EMPTYSET, AbstractTranslator.setOfBinaryAtomSort);
    }

    @Override
    public void accept(PdlAstVisitor visitor)
    {
        visitor.visit(this);
    }
}
