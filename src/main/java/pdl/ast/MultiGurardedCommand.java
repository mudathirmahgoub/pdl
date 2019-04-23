package pdl.ast;

import edu.uiowa.smt.smtAst.BinaryExpression;
import edu.uiowa.smt.smtAst.Expression;
import edu.uiowa.smt.smtAst.UnaryExpression;
import pdl.printers.PdlAstVisitor;
import pdl.translator.PdlToSmtTranslator;

import java.util.List;
import java.util.stream.Collectors;

public class MultiGurardedCommand extends Program
{
    private final List<GuardedCommand> guardedCommands;

    private final Op op;

    public MultiGurardedCommand(Op op, List<GuardedCommand> guardedCommands)
    {
        this.op = op;
        if (guardedCommands == null || guardedCommands.size() == 0)
        {
            throw new RuntimeException("Empty list of guarded commands");
        }
        this.guardedCommands = guardedCommands;
    }

    public Op getOp()
    {
        return op;
    }

    public List<GuardedCommand> getGuardedCommands()
    {
        return guardedCommands;
    }

    public enum Op
    {
        If("if"),
        Do("do");

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
        if (!(object instanceof MultiGurardedCommand))
        {
            return false;
        }
        MultiGurardedCommand command = (MultiGurardedCommand) object;
        return this.op == command.op &&
                this.guardedCommands.equals(command.guardedCommands);
    }

    @Override
    public Expression translate(PdlToSmtTranslator translator)
    {
        switch (op)
        {
            case If:
            {
                // m(if p -> a | q -> b | r -> c fi) = p?a ; union q?b ; union r?c
                List<Expression> commandsMeaning = guardedCommands
                        .stream().map(g -> g.translate(translator))
                        .collect(Collectors.toList());
                Expression union = commandsMeaning.get(0);
                if(commandsMeaning.size() > 1)
                {
                    for (int i = 1; i < commandsMeaning.size(); i++)
                    {
                        union = new BinaryExpression(union, BinaryExpression.Op.UNION, commandsMeaning.get(i));
                    }
                }
                return union;
            }
            case Do:
            {
                // m(do p -> a | q -> b | r -> c od) =
                // (p?a ; union q?b ; union r?c)* ; (not p and not q and not r)?
                List<Expression> commandsMeaning = guardedCommands
                        .stream().map(g -> g.translate(translator))
                        .collect(Collectors.toList());
                List<Expression> guards = guardedCommands
                        .stream()
                        .map
                        (   g -> new BinaryExpression
                            (
                                translator.statesUniverse,
                                BinaryExpression.Op.INTERSECTION,
                                g.getFormula().translate(translator)
                            )
                        )
                        .collect(Collectors.toList());

                Expression union = commandsMeaning.get(0);
                Expression and = guards.get(0);
                if(commandsMeaning.size() > 1)
                {
                    for (int i = 1; i < commandsMeaning.size(); i++)
                    {
                        union = new BinaryExpression(union, BinaryExpression.Op.UNION, commandsMeaning.get(i));
                        and = new BinaryExpression(and, BinaryExpression.Op.INTERSECTION, guards.get(i));
                    }
                }
                Expression transitiveClosure = new UnaryExpression(UnaryExpression.Op.TCLOSURE, union);
                Expression reflexiveTransitiveClosure = new BinaryExpression(union, BinaryExpression.Op.UNION, transitiveClosure);

                Expression product = new BinaryExpression(and, BinaryExpression.Op.PRODUCT, and);
                Expression intersection = new BinaryExpression(translator.statesIdentity,
                        BinaryExpression.Op.INTERSECTION, product);
                Expression composition = new BinaryExpression(reflexiveTransitiveClosure,
                        BinaryExpression.Op.JOIN, intersection);
                return composition;
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void accept(PdlAstVisitor visitor)
    {
        visitor.visit(this);
    }
}
