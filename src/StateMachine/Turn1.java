package StateMachine;

import Events.TimerSubject;
import HUD.HUD;

import java.awt.*;
import java.text.DecimalFormat;

public class Turn1 extends Turn{

    @Override
    public void stopGame() {

    }

    @Override
    public void changeToTurn1() {

    }

    @Override
    public void changeToTurn2() {
        ((Turn) context.getTurn2()).getContainer().addCards(context.getManager().initializeTurn());
        TimerSubject.getInstance().newTimer();
        context.setCurrent(context.getTurn2());
    }

    @Override
    public void gameUpdate() {

    }

    @Override
    public void gameRender(Graphics g) {
        g.setColor(Color.black);
        HUD.getInstance().render(g);
        g.drawString("Es turno del "+HUD.getInstance().getPlayer1()+"                      Tiempo: ",180, 40);
        g.drawString(String.valueOf((int)TimerSubject.getInstance().getTime()),420,40);
        g.drawString("Que animal empieza con "+context.getManager().getLetra(),270,80);
        cardCont.render(g);

    }

    @Override
    public void setGameContext(GameContext context){
        this.context = context;
    }
}
