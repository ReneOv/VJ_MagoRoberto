package Events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class MouseSubject implements Subject, MouseListener{
    private List<Observer> observers = new ArrayList<>();
    private List<Observer> toAdd = new ArrayList<>();
    protected int[] state = {0, 0, 0};
    public static int PRESSED = 2;

    private static MouseSubject instance;
    public static MouseSubject getInstance()
    {
        if(instance==null)
            instance = new MouseSubject();
        return instance;
    }

    public void subscribe(Observer observer){
        toAdd.add(observer);
    }

    public int[] getState() {
        return state;
    }

    public void notifyObservers(){
        if(!toAdd.isEmpty())
            observers.clear();
        observers.addAll(toAdd);
        toAdd.clear();
        for(Observer observer : observers)
            observer.updateOnEvent(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        state[0] = e.getX();
        state[1] = e.getY();
        state[2] = PRESSED;
        notifyObservers();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
