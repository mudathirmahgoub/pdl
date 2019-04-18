package pdl.ast;

public class UnaryFormula extends Formula
{
    private final Op op;
    private final Formula formula;

    public UnaryFormula(Op op, Formula formula)
    {
        this.op     = op;
        if(formula == null)
        {
            throw new RuntimeException("Formula is null");
        }
        this.formula   = formula;
    }

    public Op getOP()
    {
        return this.op;
    }

    public Formula getFormula()
    {
        return this.formula;
    }

    public enum Op
    {
        Not ("not") ;

        private final String opStr;

        Op(String str)
        {
            this.opStr = str;
        }

        @Override
        public String toString()
        {
            return this.opStr;
        }
    }
}
