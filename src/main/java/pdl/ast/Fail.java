package pdl.ast;

public class Fail extends Program
{
    private Fail instance = new Fail();
    private Fail() {}

    public Fail getInstance()
    {
        return instance;
    }
}
