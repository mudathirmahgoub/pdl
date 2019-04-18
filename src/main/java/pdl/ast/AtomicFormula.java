package pdl.ast;

public class AtomicFormula extends Formula
{
    private final String symbol;
    public AtomicFormula(String symbol)
    {
        if(symbol.isEmpty())
        {
           throw new RuntimeException("Symbol is an empty string");
        }
        this.symbol = symbol;
    }
}
