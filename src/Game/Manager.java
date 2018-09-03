package Game;

import Elements.*;
import Events.Observer;
import HUD.HUD;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Manager{
    private ArrayList<String> nameList = new ArrayList<>(Arrays.asList("a", "b", "c", "e", "g", "h", "j", "s", "t"));
    private Random r = new Random();
    private String letra = null;
    private Observer subscriber;
    private int cardIndex = 0;

    public void fisherYatesShuffle()
    {
        cardIndex = 0;
        String m;
        for(int i=0; i<nameList.size()-1;i++){
            int j = r.nextInt(nameList.size()-i);
            m = nameList.get(j);
            nameList.set(j, nameList.get(i));
            nameList.set(i, m);
        }
    }

    public ArrayList<Card> initializeTurn()
    {
        this.fisherYatesShuffle();
        int ccard = r.nextInt(3);
        ArrayList<Card> cards = new ArrayList<>();
        for(int i =0; i<3; i++)
        {
            Card card;
            if (i == ccard)
            {
                card = giveCorrect();
                letra = card.getName();
                ((CorrectCard) card).subscribe(HUD.getInstance());
                ((CorrectCard) card).subscribe(subscriber);

            }
            else
            {
                card = giveCard();
            }
            cards.add(card);
        }
        return cards;
    }

    public Card giveCard()
    {
        Card card = (Card) ElementFactory.getInstance().createElement("card");
        Sprite front = (Sprite) ElementFactory.getInstance().createElement("sprite");
        front.setImage(nameList.get(cardIndex));
        Sprite back = (Sprite) ElementFactory.getInstance().createElement("sprite");
        back.setImage("mal");
        card.setFace(front);
        card.setBack(back);
        card.setName(nameList.get(cardIndex));
        cardIndex++;
        return card;
    }

    public Card giveCorrect()
    {
        Card card = (Card) ElementFactory.getInstance().createElement("correctCard");
        Sprite front = (Sprite) ElementFactory.getInstance().createElement("sprite");
        front.setImage(nameList.get(cardIndex));
        Sprite back = (Sprite) ElementFactory.getInstance().createElement("sprite");
        back.setImage("bien");
        card.setFace(front);
        card.setBack(back);
        card.setName(nameList.get(cardIndex));
        nameList.remove(cardIndex);
        return card;
    }

    public void setSubscriber(Observer observer)
    {
        subscriber = observer;
    }

    public String getLetra() {
        return letra;
    }


}
