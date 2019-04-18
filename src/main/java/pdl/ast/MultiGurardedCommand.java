package pdl.ast;

import java.util.List;

public class MultiGurardedCommand extends Program
{
    private final List<GuardedCommand> guardedCommands;

    private final Op op;

    public MultiGurardedCommand(Op op, List<GuardedCommand> guardedCommands)
    {
        this.op = op;
        if(guardedCommands == null || guardedCommands.size() == 0)
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
        If ("if"),
        Do ("do");

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