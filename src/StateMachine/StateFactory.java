package StateMachine;

public class StateFactory {
    private static StateFactory instance;

    public static StateFactory getInstance()
    {
        if(instance==null)
            instance = new StateFactory();
        return instance;
    }

    public GameState createState(String stateType)
    {
        switch(stateType)
        {
            case "start":
                return new StartState();
            case "over":
                return new GameOverState();
            case "turn1":
                return new Turn1();
            case "turn2":
                return new Turn2();
            default:
                return null;
        }
    }
}
