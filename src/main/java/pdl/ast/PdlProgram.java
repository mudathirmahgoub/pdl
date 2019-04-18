package pdl.ast;

public class PdlProgram extends PdlAst
{
    private final KripkeFrame frame;
    private final Formula formula;

    public PdlProgram(KripkeFrame frame, Formula formula)
    {
        // frame can be null
        this.frame = frame;
        // formula should not be null
        if(formula == null)
        {
            throw new RuntimeException("Formula is null");
        }
        this.formula = formula;
    }

    public Formula getFormula()
    {
        return formula;
    }

    public KripkeFrame getFrame()
    {
        return frame;
    }
}
