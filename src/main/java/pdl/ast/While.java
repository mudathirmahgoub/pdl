package pdl.ast;

import edu.uiowa.smt.smtAst.Expression;
import pdl.printers.PdlAstVisitor;
import pdl.translator.PdlToSmtTranslator;

import java.util.Arrays;
import java.util.Collections;

public class While extends Program
{
    private final Formula formula;
    private final Program program;

    public While(Formula formula, Program program)
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
        if (!(object instanceof While))
        {
            return false;
        }
        While whileProgram = (While) object;
        return this.program.equals(whileProgram.program) &&
                this.formula.equals(whileProgram.formula);
    }

    @Override
    public Expression translate(PdlToSmtTranslator translator)
    {
        // while p do a = do p -> a od
        GuardedCommand command = new GuardedCommand(formula, program);
        Program doProgram = new MultiGurardedCommand(MultiGurardedCommand.Op.Do,
                Arrays.asList(command));
        return doProgram.translate(translator);
    }

    @Override
    public void accept(PdlAstVisitor visitor)
    {
        visitor.visit(this);
    }
}
