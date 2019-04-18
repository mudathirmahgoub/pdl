package pdl.ast;

public class Repeat extends Program
{
    private final Formula formula;
    private final Program program;

    public Repeat(Program program, Formula formula)
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
