package pdl.ast;

import edu.uiowa.smt.smtAst.BinaryExpression;
import edu.uiowa.smt.smtAst.Expression;
import pdl.printers.PdlAstVisitor;
import pdl.translator.PdlToSmtTranslator;

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

    @Override
    public Expression translate(PdlToSmtTranslator translator)
    {
        Expression programMeaning = program.translate(translator);
        Expression formulaMeaning = formula.translate(translator);
        switch (op)
        {
            case Box:
            {
                // m([a] p) =  K - (m(a) o (K - m(p)))
                Expression formulaComplement = new BinaryExpression(translator.statesUniverse, BinaryExpression.Op.SETMINUS, formulaMeaning);
                Expression join = new BinaryExpression(programMeaning, BinaryExpression.Op.JOIN, formulaComplement);
                Expression necessity = new BinaryExpression(translator.statesUniverse, BinaryExpression.Op.SETMINUS, join);
                return necessity;
            }
            case Diamond:
            {
                // m(<a> p) =  m(a) o m(p)
                Expression join = new BinaryExpression(programMeaning, BinaryExpression.Op.JOIN, formulaMeaning);
                return join;
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void accept(PdlAstVisitor visitor)
    {
        visitor.visit(this);
    }
}
