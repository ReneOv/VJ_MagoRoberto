package StateMachine;

import HUD.HUD;

import java.awt.*;

public class GameOverState extends GameState{

    @Override
    public void stopGame() {

    }

    @Override
    public void changeToTurn1() {

    }

    @Override
    public void changeToTurn2() {

    }

    @Override
    public void gameUpdate() {

    }

    public String getGanador()
    {
        if(HUD.getInstance().getScores().get(0).size() == 3 && HUD.getInstance().getScores().get(1).size() == 3 ){
            double p1 = 0, p2 = 0;
            for(double score : HUD.getInstance().getScores().get(0))
                p1 += score;
            for(double score : HUD.getInstance().getScores().get(1))
                p2 += score;
            if(p1>p2)
                return "Jugador 2";
            return "Jugador 1";
        }
        return null;
    }

    @Override
    public void gameRender(Graphics g) {
        g.setColor(Color.black);
        g.drawString("El ganador es "+getGanador(),220,200);
        HUD.getInstance().render(g);
    }
}
