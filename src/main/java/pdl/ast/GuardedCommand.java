package pdl.ast;

public class GuardedCommand extends PdlAst
{
    private final Formula formula;
    private final Program program;

    public GuardedCommand(Formula formula, Program program)
    {
        if (formula == null)
        {
            throw new RuntimeException("Formula is null");
        }
        if (program == null)
        {
            throw new RuntimeException("Program is null");
        }

        this.formula = formula;
        this.program = program;
    }

    public Formula getFormula()
    {
        return formula;
    }

    public Program getProgram()
    {
        return program;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof GuardedCommand))
        {
            return false;
        }
        GuardedCommand command = (GuardedCommand) object;
        return this.program.equals(command.program) &&
                this.formula.equals(command.formula);
    }
}
