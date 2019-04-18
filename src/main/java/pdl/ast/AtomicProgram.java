package pdl.ast;

public class AtomicProgram
{
    private final String symbol;
    public AtomicProgram(String symbol)
    {
        if(symbol.isEmpty())
        {
            throw new RuntimeException("Symbol is an empty string");
        }
        this.symbol = symbol;
    }

    public String getSymbol()
    {
        return symbol;
    }
}