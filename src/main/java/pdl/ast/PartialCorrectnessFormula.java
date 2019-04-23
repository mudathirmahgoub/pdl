package pdl.ast;

import edu.uiowa.smt.smtAst.Expression;
import pdl.printers.PdlAstVisitor;
import pdl.translator.PdlToSmtTranslator;

public class PartialCorrectnessFormula extends Formula
{
    private final Program program;
    private final Formula precondition;
    private final Formula postcondition;

    public PartialCorrectnessFormula(Formula precondition, Program program, Formula postcondition)
    {
        if (program == null)
        {
            throw new RuntimeException("Program is null");
        }
        if (precondition == null)
        {
            throw new RuntimeException("Precondition is null");
        }
        if (postcondition == null)
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

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof PartialCorrectnessFormula))
        {
            return false;
        }
        PartialCorrectnessFormula formula = (PartialCorrectnessFormula) object;
        return this.precondition.equals(formula.precondition) &&
                this.program.equals(formula.program) &&
                this.postcondition.equals(formula.postcondition);
    }

    @Override
    public Expression translate(PdlToSmtTranslator translator)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void accept(PdlAstVisitor visitor)
    {
        visitor.visit(this);
    }
}
