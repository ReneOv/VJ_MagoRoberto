package Game;

import Elements.CorrectCard;
import Events.Observer;
import Events.Subject;
import Events.TimerSubject;
import StateMachine.GameContext;

public class GeneralObserver implements Observer{
    private GameContext context;
    private int turnChanges = 0;

    public GeneralObserver(GameContext context)
    {
        this.context = context;
        TimerSubject.getInstance().subscribe(this);
    }

    @Override
    public void updateOnEvent(Subject subject) {
        if(subject == TimerSubject.getInstance())
        {
            context.getManager().setSubscriber(this);
            context.changeToTurn1();
        }
        if(subject instanceof CorrectCard)
        {
            if(turnChanges == 5)
            {
                context.stopGame();
            }
            else if(turnChanges % 2 == 0)
            {
                context.changeToTurn2();
            }
            else
            {
                context.changeToTurn1();
            }
            turnChanges++;
        }
    }
}
