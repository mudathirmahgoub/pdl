package pdl.ast;

public class Fail extends Program
{
    private final static Fail instance = new Fail();

    private Fail()
    {
    }

    public static Fail getInstance()
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
        if (!(object instanceof Fail))
        {
            return false;
        }
        return true;
    }
}
