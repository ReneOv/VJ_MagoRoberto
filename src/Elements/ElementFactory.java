package Elements;

public class ElementFactory {
    private static ElementFactory instance;

    public static ElementFactory getInstance(){
        if(instance == null)
            instance = new ElementFactory();
        return instance;
    }

    public Element createElement(String type){
        switch(type) {
            case "sprite":
                return new Sprite();
            case "card":
                return new Card();
            case "correctCard":
                return new CorrectCard();
            default:
                return null;
        }
    }

}
