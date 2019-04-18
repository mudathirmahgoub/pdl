package pdl.ast;

public class PartialCorrectnessFormula extends Formula
{
    private final Program program;
    private final Formula precondition;
    private final Formula postcondition;

    public PartialCorrectnessFormula(Formula precondition, Program program ,Formula postcondition)
    {
        if(program == null)
        {
            throw new RuntimeException("Program is null");
        }
        if(precondition == null)
        {
            throw new RuntimeException("Precondition is null");
        }
        if(postcondition == null)
        {
            throw new RuntimeException("Postcondition is null");
        }
        this.program = program;
        this.precondition = precondition;
        this.postcondition = postcondition;
    }

    public Program getProgram()
    {
        return this.program;
    }

    public Formula getPrecondition()
    {
        return this.precondition;
    }
    public Formula getPostcondition()
    {
        return this.postcondition;
    }
}
