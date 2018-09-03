package HUD;

import Elements.Element;
import Events.Observer;
import Events.Subject;
import Events.TimerSubject;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class HUD extends Element implements Observer{
    private static HUD instance;

    public static HUD getInstance() {
        if (instance == null)
            instance = new HUD();
        return instance;
    }

    private double scoreToAdd;
    boolean flag =false;

    private HUD()
    {
        x = 220;
        y = 350;
    }

    private String player1 = "Jugador 1";
    private String player2 = "Jugador 2";

    private DecimalFormat df = new DecimalFormat(".##");

    public ArrayList<ArrayList<Double>> getScores() {
        return scores;
    }

    private ArrayList<ArrayList<Double>> scores = new ArrayList<>(Arrays.asList(new ArrayList<Double>(), new ArrayList<Double>()));

    public String getPlayer1()
    {
        return player1;
    }

    public String getPlayer2()
    {
        return player2;
    }


    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

        double p1 = 0, p2 = 0;
        for(double score : scores.get(0))
            p1 += score;
        for(double score : scores.get(1))
            p2 += score;

        g.setColor(Color.black);
        g.drawString("TIEMPOS", x, y);
        g.drawString("Turno 1", x+70, y);
        g.drawString("Turno 2", x+120, y);
        g.drawString("Turno 3", x+170, y);
        g.drawString(player1, x, y+20);
        g.drawString(player2, x, y+40);
        for(int i = 0; i<scores.size(); i++){
            for(int j = 0; j<scores.get(i).size(); j++)
                g.drawString(String.valueOf(df.format(scores.get(i).get(j))), x+70+j*50, y+20+i*20);
            for(int j = scores.get(i).size(); j<3; j++)
                g.drawString("0.0", x+70+j*50, y+20+i*20);
        }
        g.drawString("Suma de Tiempos", x+220, y);
        g.drawString(String.valueOf(df.format(p1)), x+220, y+20);
        g.drawString(String.valueOf(df.format(p2)), x+220, y+40);
    }

    @Override
    public void updateOnEvent(Subject subject) {
        scoreToAdd = TimerSubject.getInstance().getTime()-0.1;
        if(!flag) {
            scores.get(0).add(scoreToAdd);
            flag = true;
        }
        else {
            scores.get(1).add(scoreToAdd);
            flag = false;
        }
    }
}
