package pdl.ast;

public class GuardedCommand
{
    private final Formula formula;
    private final Program program;

    public GuardedCommand(Formula formula, Program program)
    {
        if(formula == null)
        {
            throw new RuntimeException("Formula is null");
        }
        if(program == null)
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
}
