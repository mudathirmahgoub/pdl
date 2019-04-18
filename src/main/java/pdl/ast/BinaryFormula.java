package pdl.ast;

public class BinaryFormula extends Formula
{
    private final Op op;
    private final Formula left;
    private final Formula right;

    public BinaryFormula(Op op, Formula left, Formula right)
    {
        this.op = op;
        if(left == null)
        {
            throw new RuntimeException("Left formula is null");
        }
        if(right == null)
        {
            throw new RuntimeException("Right formula is null");
        }
        this.left = left;
        this.right = right;
    }

    public Op getOP()
    {
        return this.op;
    }

    public Formula getLeft()
    {
        return this.left;
    }

    public Formula getRight()
    {
        return this.right;
    }

    public enum Op
    {
        And ("and"),
        Or ("or"),
        Implies("->"),
        Equivalence("<->");

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
