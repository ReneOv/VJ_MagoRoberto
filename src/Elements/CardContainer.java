package Elements;

import java.awt.*;
import java.util.ArrayList;

public class CardContainer extends Element{
    private ArrayList<Card> cards = new ArrayList<>();

    public void clear()
    {
        cards.clear();
    }

    public void addCards(ArrayList<Card> cardsToAdd)
    {
        clear();
        for(int i=0; i<3; i++)
        {
            cards.add(cardsToAdd.get(i));
            cards.get(i).setX(220*i + 50);
            cards.get(i).setY(100);
        }
    }


    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        for(int i=0; i<3; i++)
        {
            cards.get(i).render(g);
        }
    }
}
