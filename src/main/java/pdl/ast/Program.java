package pdl.ast;

import edu.uiowa.smt.smtAst.Expression;
import pdl.translator.PdlToSmtTranslator;

public abstract class Program extends PdlAst
{
    abstract public boolean equals(Object object);

    public abstract Expression translate(PdlToSmtTranslator translator);
}
