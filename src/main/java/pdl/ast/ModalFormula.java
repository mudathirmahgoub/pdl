package pdl.ast;

public class ModalFormula extends Formula
{
    private final Op op;
    private final Program program;
    private final Formula formula;

    public ModalFormula(Op op, Program program, Formula formula)
    {
        this.op = op;
        if (program == null)
        {
            throw new RuntimeException("Program is null");
        }
        if (formula == null)
        {
            throw new RuntimeException("Formula is null");
        }
        this.program = program;
        this.formula = formula;
    }

    public Op getOP()
    {
        return this.op;
    }

    public Program getProgram()
    {
        return this.program;
    }

    public Formula getFormula()
    {
        return this.formula;
    }

    public enum Op
    {
        Box("box"),
        Diamond("diamond"),
        ;

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
        if (!(object instanceof ModalFormula))
        {
            return false;
        }
        ModalFormula modal = (ModalFormula) object;
        return this.program.equals(modal.program) &&
                this.formula.equals(modal.formula);
    }
}
