package pdl.ast;

import pdl.printers.PdlAstVisitor;

public class PdlProgram extends PdlAst
{
    private final KripkeFrame frame;
    private final Formula formula;
    private final boolean isFrameProvided;

    public PdlProgram(KripkeFrame frame, Formula formula, boolean isFrameProvided)
    {
        this.isFrameProvided = isFrameProvided;
        // frame can be null
        this.frame = frame;
        // formula should not be null
        if (formula == null)
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

    public boolean isFrameProvided()
    {
        return isFrameProvided;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof PdlProgram))
        {
            return false;
        }
        PdlProgram program = (PdlProgram) object;
        return this.frame.equals(program.frame) &&
                this.formula.equals(program.formula);
    }

    @Override
    public void accept(PdlAstVisitor visitor)
    {
        visitor.visit(this);
    }
}
