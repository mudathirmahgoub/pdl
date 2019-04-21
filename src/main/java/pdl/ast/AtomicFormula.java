package pdl.ast;

public class AtomicFormula extends Formula
{
    private final String symbol;

    public AtomicFormula(String symbol)
    {
        if (symbol.isEmpty())
        {
            throw new RuntimeException("Symbol is an empty string");
        }
        this.symbol = symbol;
    }

    public String getSymbol()
    {
        return symbol;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof AtomicFormula))
        {
            return false;
        }
        AtomicFormula formula = (AtomicFormula) object;
        return symbol.equals(formula.symbol);
    }
}
