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
}
