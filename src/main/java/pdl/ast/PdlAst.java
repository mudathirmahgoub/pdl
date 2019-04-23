package pdl.ast;

import pdl.printers.PdlAstVisitor;

public abstract class PdlAst
{
    @Override
    abstract public boolean equals(Object obj);

    public abstract void accept(PdlAstVisitor visitor);
}
