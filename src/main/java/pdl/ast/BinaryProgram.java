package pdl.ast;

public class BinaryProgram
{
    private final Op op;
    private final Program left;
    private final Program right;

    public BinaryProgram(Op op, Program left, Program right)
    {
        this.op = op;
        if(left == null)
        {
            throw new RuntimeException("Left program is null");
        }
        if(right == null)
        {
            throw new RuntimeException("Right program is null");
        }
        this.left = left;
        this.right = right;
    }

    public Op getOP()
    {
        return this.op;
    }

    public Program getLeft()
    {
        return this.left;
    }

    public Program getRight()
    {
        return this.right;
    }

    public enum Op
    {
        Composition (";"),
        Choice ("union");

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
