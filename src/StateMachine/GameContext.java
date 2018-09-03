package StateMachine;

import Game.Manager;

import java.awt.*;

public class GameContext {
    private GameState turn1;
    private GameState turn2;
    private GameState start;
    private GameState over;
    private Manager manager;

    private GameState current;

    public void gameUpdate()
    {
        current.gameUpdate();
    }

    public void gameRender(Graphics g)
    {
        current.gameRender(g);
    }

    public void setCurrent(GameState state){
        current = state;
    }

    public void stopGame(){
        current.stopGame();
    }

    public void changeToTurn1(){
        current.changeToTurn1();
    }

    public void changeToTurn2(){
        current.changeToTurn2();
    }

    public GameState getCurrent()
    {
        return current;
    }

    public GameState getStopped()
    {
        return over;
    }

    public GameState getTurn1()
    {
        return turn1;
    }

    public GameState getTurn2()
    {
        return turn2;
    }

    public GameContext(){
        manager = new Manager();
        over = StateFactory.getInstance().createState("over");
        start = StateFactory.getInstance().createState("start");
        turn1 = StateFactory.getInstance().createState("turn1");
        turn2 = StateFactory.getInstance().createState("turn2");
        over.setGameContext(this);
        start.setGameContext(this);
        turn1.setGameContext(this);
        turn2.setGameContext(this);

        current = start;
    }

    public void setManager(Manager manager){
        this.manager = manager;
    }

    public Manager getManager(){
        return manager;
    }
}
