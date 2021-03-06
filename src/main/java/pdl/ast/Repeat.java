package pdl.ast;

import edu.uiowa.smt.smtAst.Expression;
import pdl.printers.PdlAstVisitor;
import pdl.translator.PdlToSmtTranslator;

public class Repeat extends Program
{
    private final Formula formula;
    private final Program program;

    public Repeat(Program program, Formula formula)
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
        if (!(object instanceof Repeat))
        {
            return false;
        }
        Repeat repeat = (Repeat) object;
        return this.program.equals(repeat.program) &&
                this.formula.equals(repeat.formula);
    }

    @Override
    public Expression translate(PdlToSmtTranslator translator)
    {
        // repeat a until p = a ; while not p do a
        Formula not = new UnaryFormula(UnaryFormula.Op.Not, formula);
        Program whileProgram = new While(not, program);
        Program composition = new BinaryProgram(BinaryProgram.Op.Composition, program, whileProgram);
        return composition.translate(translator);
    }

    @Override
    public void accept(PdlAstVisitor visitor)
    {
        visitor.visit(this);
    }
}
