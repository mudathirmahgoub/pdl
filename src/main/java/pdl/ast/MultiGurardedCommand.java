package pdl.ast;

import edu.uiowa.smt.smtAst.BinaryExpression;
import edu.uiowa.smt.smtAst.Expression;
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
        }
        throw new UnsupportedOperationException();
    }
}
