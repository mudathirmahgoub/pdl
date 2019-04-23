package pdl.ast;

import edu.uiowa.smt.smtAst.BinaryExpression;
import edu.uiowa.smt.smtAst.Expression;
import pdl.translator.PdlToSmtTranslator;

public class Test extends Program
{
    private final Formula formula;

    public Test(Formula formula)
    {
        if (formula == null)
        {
            throw new RuntimeException("Formula is null");
        }
        this.formula = formula;
    }

    public Formula getFormula()
    {
        return formula;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof Test))
        {
            return false;
        }
        Test test = (Test) object;
        return this.formula.equals(test.formula);
    }

    @Override
    public Expression translate(PdlToSmtTranslator translator)
    {
        Expression formulaMeaning = formula.translate(translator);
        Expression product = new BinaryExpression(formulaMeaning, BinaryExpression.Op.PRODUCT, formulaMeaning);
        Expression intersection = new BinaryExpression(translator.statesIdentity,
                BinaryExpression.Op.INTERSECTION, product);
        return intersection;
    }
}
