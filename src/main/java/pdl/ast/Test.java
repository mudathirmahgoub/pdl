package pdl.ast;

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
}
