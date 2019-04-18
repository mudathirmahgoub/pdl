package pdl.ast;

public class Iteration extends Program
{
    private final Program program;

    public Iteration(Program program)
    {
        if(program == null)
        {
            throw new RuntimeException("Program is null");
        }
        this.program = program;
    }
}
