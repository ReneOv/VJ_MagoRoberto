package Game;

import StateMachine.GameContext;

import javax.swing.*;

public class Main{
    public static void main(String[] args)
    {
        GameContext context = new GameContext();
        JFrame window = new JFrame("Mago Roberto - René Ojeda");
        GamePanel miPanel = new GamePanel(context);
        GeneralObserver observer = new GeneralObserver(context);
        window.getContentPane().add(miPanel);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(miPanel.getPreferredSize());
        window.setVisible(true);
    }
}
