package StateMachine;

import Elements.CorrectCard;
import Events.Observer;
import Events.Subject;
import Events.TimerSubject;
import org.w3c.dom.css.Counter;

public class StateMachineObserver implements Observer {
    private GameContext context;

    public StateMachineObserver(GameContext context)
    {
        this.context = context;
        this.context.getManager().setSubscriber(this);
        TimerSubject.getInstance().subscribe(this);
    }

    @Override
    public void updateOnEvent(Subject subject) {
        if(subject == TimerSubject.getInstance()){
            context.changeToTurn1();
        }
        if(subject instanceof CorrectCard){
            if(context.getCurrent() == context.getTurn1())
                context.changeToTurn2();
            else
                context.changeToTurn1();
        }
    }
}
