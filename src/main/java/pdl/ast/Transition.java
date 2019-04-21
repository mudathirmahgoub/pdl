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

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if(!(object instanceof Transition))
        {
            return false;
        }
        Transition transition = (Transition) object ;
        return inputState.equals(transition.inputState) &&
                outputState.equals(transition.outputState);
    }
}
