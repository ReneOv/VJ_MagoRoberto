package StateMachine;

import Events.TimerSubject;

import java.awt.*;

public class StartState extends GameState {

    public StartState()
    {
        TimerSubject.getInstance().newTimerEvent(3000);
    }

    @Override
    public void stopGame() {

    }

    @Override
    public void changeToTurn1() {
        ((Turn) context.getTurn1()).getContainer().addCards(context.getManager().initializeTurn());
        TimerSubject.getInstance().newTimer();
        context.setCurrent(context.getTurn1());
    }

    @Override
    public void changeToTurn2() {
    }

    @Override
    public void gameUpdate() {

    }

    @Override
    public void setGameContext(GameContext context){
        this.context = context;
    }

    @Override
    public void gameRender(Graphics g) {
        g.setColor(Color.black);
        g.drawString("El juego comienza en:  ", 180, 220);
        g.drawString(String.valueOf(3 -(int)TimerSubject.getInstance().getTime()), 320, 220);
    }
}
