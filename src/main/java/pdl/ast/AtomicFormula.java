package pdl.ast;

import edu.uiowa.smt.smtAst.Expression;
import edu.uiowa.smt.smtAst.Variable;
import pdl.printers.PdlAstVisitor;
import pdl.translator.PdlToSmtTranslator;

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

    @Override
    public Expression translate(PdlToSmtTranslator translator)
    {
        if(translator.propositionMap.containsKey(symbol))
        {
            return translator.propositionMap.get(symbol).getVariable();
        }
        else
        {
            throw new RuntimeException(String.format("Proposition %s is undefined", symbol));
        }
    }

    @Override
    public void accept(PdlAstVisitor visitor)
    {
        visitor.visit(this);
    }
}
