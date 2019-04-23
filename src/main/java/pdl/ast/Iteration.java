package pdl.ast;

import edu.uiowa.smt.AbstractTranslator;
import edu.uiowa.smt.TranslatorUtils;
import edu.uiowa.smt.smtAst.*;
import pdl.translator.PdlToSmtTranslator;

public class Iteration extends Program
{
    private final Program program;

    public Iteration(Program program)
    {
        if (program == null)
        {
            throw new RuntimeException("Program is null");
        }
        this.program = program;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof Iteration))
        {
            return false;
        }
        Iteration iteration = (Iteration) object;
        return this.program.equals(iteration.program);
    }

    @Override
    public Expression translate(PdlToSmtTranslator translator)
    {
        Expression meaning = program.translate(translator);
        Expression transitiveClosure = new UnaryExpression(UnaryExpression.Op.TCLOSURE, meaning);
        Expression reflexiveTransitiveClosure = new BinaryExpression(meaning, BinaryExpression.Op.UNION, transitiveClosure);
        return reflexiveTransitiveClosure;
    }
}
