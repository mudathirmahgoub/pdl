package pdl.ast;

import edu.uiowa.smt.smtAst.Expression;
import pdl.printers.PdlAstVisitor;
import pdl.translator.PdlToSmtTranslator;

import java.util.Arrays;

public class ITEProgram extends Program
{
    private final Formula condition;
    private final Program thenProgram;
    private final Program elseProgram;

    public ITEProgram(Formula condition, Program thenProgram, Program elseProgram)
    {
        if (condition == null)
        {
            throw new RuntimeException("Formula is null");
        }
        if (thenProgram == null)
        {
            throw new RuntimeException("Then program is null");
        }

        if (elseProgram == null)
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

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof ITEProgram))
        {
            return false;
        }
        ITEProgram ite = (ITEProgram) object;
        return condition.equals(ite.condition) &&
                thenProgram.equals(ite.thenProgram) &&
                elseProgram.equals(ite.elseProgram);
    }

    @Override
    public Expression translate(PdlToSmtTranslator translator)
    {
        GuardedCommand thenCommand = new GuardedCommand(condition, thenProgram);
        UnaryFormula not = new UnaryFormula(UnaryFormula.Op.Not, condition);
        GuardedCommand elseCommand = new GuardedCommand(not, elseProgram);
        MultiGurardedCommand fi = new MultiGurardedCommand(MultiGurardedCommand.Op.If, Arrays.asList(thenCommand, elseCommand));
        return fi.translate(translator);
    }

    @Override
    public void accept(PdlAstVisitor visitor)
    {
        visitor.visit(this);
    }
}
