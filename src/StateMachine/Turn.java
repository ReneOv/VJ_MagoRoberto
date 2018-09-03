package StateMachine;

import Elements.CardContainer;

public abstract class Turn extends GameState{
    protected CardContainer cardCont = new CardContainer();

    public CardContainer getContainer()
    {
        return cardCont;
    }
}
