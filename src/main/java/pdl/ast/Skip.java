package pdl.ast;

public class Skip extends Program
{
    private final static Skip instance = new Skip();

    private Skip()
    {
    }

    public static Skip getInstance()
    {
        return instance;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof Skip))
        {
            return false;
        }
        return true;
    }
}
