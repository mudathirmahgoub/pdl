package pdl.ast;

public class AtomicProgram extends Program
{
    private final String symbol;

    public AtomicProgram(String symbol)
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
        if (!(object instanceof AtomicProgram))
        {
            return false;
        }
        AtomicProgram program = (AtomicProgram) object;
        return this.symbol.equals(program.symbol);
    }
}
