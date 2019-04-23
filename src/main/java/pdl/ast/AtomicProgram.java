package pdl.ast;

import edu.uiowa.smt.smtAst.Expression;
import edu.uiowa.smt.smtAst.Variable;
import pdl.printers.PdlAstVisitor;
import pdl.translator.PdlToSmtTranslator;

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

    @Override
    public void accept(PdlAstVisitor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public Expression translate(PdlToSmtTranslator translator)
    {
        if(translator.programsMap.containsKey(symbol))
        {
            return translator.programsMap.get(symbol).getVariable();
        }
        else
        {
            throw new RuntimeException(String.format("Program %s is undefined", symbol));
        }
    }
}
