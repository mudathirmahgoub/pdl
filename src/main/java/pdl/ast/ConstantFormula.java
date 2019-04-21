package pdl.ast;

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
        if(this == object)
        {
            return true;
        }
        if(!(object instanceof ConstantFormula))
        {
            return false;
        }
        ConstantFormula formula = (ConstantFormula) object;
        return this.value == formula.value;
    }
}
