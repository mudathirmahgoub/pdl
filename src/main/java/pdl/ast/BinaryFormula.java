package pdl.ast;

import edu.uiowa.smt.AbstractTranslator;
import edu.uiowa.smt.smtAst.BinaryExpression;
import edu.uiowa.smt.smtAst.Expression;
import edu.uiowa.smt.smtAst.UnaryExpression;
import pdl.translator.PdlToSmtTranslator;

public class BinaryFormula extends Formula
{
    private final Op op;
    private final Formula left;
    private final Formula right;

    public BinaryFormula(Op op, Formula left, Formula right)
    {
        this.op = op;
        if (left == null)
        {
            throw new RuntimeException("Left formula is null");
        }
        if (right == null)
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
        And("and"),
        Or("or"),
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

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof BinaryFormula))
        {
            return false;
        }
        BinaryFormula formula = (BinaryFormula) object;
        return this.op == formula.op &&
                this.left.equals(formula.left) &&
                this.right.equals(formula.right);
    }

    @Override
    public Expression translate(PdlToSmtTranslator translator)
    {
        Expression leftMeaning = left.translate(translator);
        Expression rightMeaning = right.translate(translator);
        switch (op)
        {
            case And:
            {
                return new BinaryExpression(leftMeaning, BinaryExpression.Op.INTERSECTION, rightMeaning);
            }
            case Or:
            {
                return new BinaryExpression(leftMeaning, BinaryExpression.Op.UNION, rightMeaning);
            }
            case Implies:
            {
                Expression difference = new BinaryExpression(translator.statesUniverse, BinaryExpression.Op.SETMINUS, leftMeaning);
                return new BinaryExpression(difference, BinaryExpression.Op.UNION, rightMeaning);
            }
            case Equivalence:
            {
                Formula implies1 = new BinaryFormula(Op.Implies, left, right);
                Formula implies2 = new BinaryFormula(Op.Implies, right, left);
                Formula equivalence = new BinaryFormula(Op.And, implies1, implies2);
                return equivalence.translate(translator);
            }
        }
        throw new UnsupportedOperationException();
    }
}
