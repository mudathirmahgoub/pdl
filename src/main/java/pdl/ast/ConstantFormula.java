package pdl.ast;

import edu.uiowa.smt.AbstractTranslator;
import edu.uiowa.smt.smtAst.BoolConstant;
import edu.uiowa.smt.smtAst.Expression;
import edu.uiowa.smt.smtAst.UnaryExpression;
import pdl.translator.PdlToSmtTranslator;

public class ConstantFormula extends Formula
{
    private final boolean value;

    public ConstantFormula(boolean value)
    {
        this.value = value;
    }

    public boolean getValue()
    {
        return value;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof ConstantFormula))
        {
            return false;
        }
        ConstantFormula formula = (ConstantFormula) object;
        return this.value == formula.value;
    }

    @Override
    public Expression translate(PdlToSmtTranslator translator)
    {
        if(value)
        {
            return translator.statesUniverse;
        }
        else
        {
            return new UnaryExpression(UnaryExpression.Op.EMPTYSET, AbstractTranslator.setOfUnaryAtomSort);
        }
    }
}
