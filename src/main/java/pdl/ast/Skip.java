package pdl.ast;

public class Skip extends Program
{
    private final static Skip instance = new Skip();
    private Skip() {}

    public static Skip getInstance()
    {
        return instance;
    }
}
