package pdl.ast;

import edu.uiowa.smt.smtAst.BinaryExpression;
import edu.uiowa.smt.smtAst.Expression;
import pdl.translator.PdlToSmtTranslator;

public class BinaryProgram extends Program
{
    private final Op op;
    private final Program left;
    private final Program right;

    public BinaryProgram(Op op, Program left, Program right)
    {
        this.op = op;
        if (left == null)
        {
            throw new RuntimeException("Left program is null");
        }
        if (right == null)
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

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof BinaryProgram))
        {
            return false;
        }
        BinaryProgram binary = (BinaryProgram) object;
        return op.equals(binary.op) &&
                left.equals(binary.left) &&
                right.equals(binary.right);
    }

    public enum Op
    {
        Composition(";"),
        Choice("union");

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

    @Override
    public Expression translate(PdlToSmtTranslator translator)
    {
        Expression leftMeaning = left.translate(translator);
        Expression rightMeaning = right.translate(translator);
        switch (op)
        {
            case Composition:
            {
                //m(a;b) =  m(a) o m(b)
                Expression join = new BinaryExpression(leftMeaning, BinaryExpression.Op.JOIN, rightMeaning);
                return join;
            }
            case Choice:
            {
                //m(a;b) =  m(a) union m(b)
                Expression union = new BinaryExpression(leftMeaning, BinaryExpression.Op.UNION, rightMeaning);
                return union;
            }
        }
        throw new UnsupportedOperationException();
    }
}
