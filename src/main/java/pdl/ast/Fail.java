package pdl.ast;

public class Fail extends Program
{
    private final static Fail instance = new Fail();
    private Fail() {}

    public static Fail getInstance()
    {
        return instance;
    }
}
