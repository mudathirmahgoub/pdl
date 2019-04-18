package pdl.ast;

public class ITEFormula
{
    private final Formula condition;
    private final Program thenProgram;
    private final Program elseProgram;

    public ITEFormula(Formula condition, Program thenProgram, Program elseProgram)
    {
        if(condition == null)
        {
            throw new RuntimeException("Formula is null");
        }
        if(thenProgram == null)
        {
            throw new RuntimeException("Then program is null");
        }

        if(elseProgram == null)
        {
            throw new RuntimeException("Else program is null");
        }

        this.condition = condition;
        this.thenProgram = thenProgram;
        this.elseProgram = elseProgram;
    }

    public Formula getCondition()
    {
        return condition;
    }

    public Program getThenProgram()
    {
        return thenProgram;
    }

    public Program getElseProgram()
    {
        return elseProgram;
    }
}
