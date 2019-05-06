package pdl.ast;

import edu.uiowa.smt.smtAst.Expression;
import edu.uiowa.smt.smtAst.UnaryExpression;
import pdl.printers.PdlAstVisitor;
import pdl.translator.PdlToSmtTranslator;

public class Converse extends Program
{
    private final Program program;

    public Converse(Program program)
    {
        if (program == null)
        {
            throw new RuntimeException("Program is null");
        }
        this.program = program;
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
        if (!(object instanceof Converse))
        {
            return false;
        }
        Converse converse = (Converse) object;
        return this.program.equals(converse.program);
    }

    @Override
    public Expression translate(PdlToSmtTranslator translator)
    {
        Expression meaning = program.translate(translator);
        Expression traspose = new UnaryExpression(UnaryExpression.Op.TRANSPOSE, meaning);
        return traspose;
    }

    @Override
    public void accept(PdlAstVisitor visitor)
    {
        visitor.visit(this);
    }
}
