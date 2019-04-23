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
                // if p -> a | q -> b | r -> c fi = p?a ; union q?b ; union r?c
                List<Program> commandsList = guardedCommands
                        .stream().map(g -> getProgram(g))
                        .collect(Collectors.toList());
                Program union = commandsList.get(0);
                if(commandsList.size() > 1)
                {
                    for (int i = 1; i < commandsList.size(); i++)
                    {
                        union = new BinaryProgram(BinaryProgram.Op.Choice, union, commandsList.get(i));
                    }
                }
                return union.translate(translator);
            }
            case Do:
            {
                // do p -> a | q -> b | r -> c od =
                // (p?a ; union q?b ; union r?c)* ; (not p and not q and not r)?
                List<Program> commandsList = guardedCommands
                        .stream().map(g -> getProgram(g))
                        .collect(Collectors.toList());

                List<Formula> guards = guardedCommands
                        .stream().map(g -> getGuard(g.getFormula()))
                        .collect(Collectors.toList());


                Program choices = commandsList.get(0);
                Formula and = guards.get(0);

                if(commandsList.size() > 1)
                {
                    for (int i = 1; i < commandsList.size(); i++)
                    {
                        choices = new BinaryProgram(BinaryProgram.Op.Choice, choices, commandsList.get(i));
                        and = new BinaryFormula(BinaryFormula.Op.And, and, guards.get(i));
                    }
                }
                Program test = new Test(and);
                Program iteration = new Iteration(choices);
                Program composition = new BinaryProgram(BinaryProgram.Op.Composition, iteration, test);
                return composition.translate(translator);
            }
        }
        throw new UnsupportedOperationException();
    }

    private Formula getGuard(Formula formula)
    {
        return new UnaryFormula(UnaryFormula.Op.Not, formula);
    }

    private Program getProgram(GuardedCommand g)
    {
        Program test = new Test(g.getFormula());
        Program composition = new BinaryProgram(BinaryProgram.Op.Composition,
                test, g.getProgram());
        return composition;
    }

    @Override
    public void accept(PdlAstVisitor visitor)
    {
        visitor.visit(this);
    }
}
