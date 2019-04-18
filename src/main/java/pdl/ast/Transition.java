package pdl.ast;

public class Transition
{
    public String inputState;
    public String outputState;
    public Transition(String inputState, String outputState)
    {
        this.inputState = inputState;
        this.outputState = outputState;
    }
}
