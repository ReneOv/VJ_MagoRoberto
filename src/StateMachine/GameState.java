package StateMachine;

import java.awt.*;

public abstract class GameState {
    GameContext context;

    public abstract void stopGame();

    public abstract void changeToTurn1();
    public abstract void changeToTurn2();

    public abstract void gameUpdate();
    public abstract void gameRender(Graphics g);

    public void setGameContext(GameContext context)
    {
        this.context = context;
    }
}
