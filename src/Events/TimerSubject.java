package Events;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TimerSubject implements Subject{
    private List<Observer> observers = new ArrayList<>();
    private  Timer timer = new Timer();
    private static TimerSubject instance;
    private double startTime;

    public static TimerSubject getInstance()
    {
        if (instance == null)
            instance = new TimerSubject();
        return instance;
    }

    public void newTimerEvent(int ms)
    {
        startTime = System.nanoTime();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                notifyObservers();
            }
        }, ms);
    }

    public void newTimer()
    {
        startTime = System.nanoTime();
    }

    public double getTime()
    {
        return (System.nanoTime() - startTime) / 1000000000L;
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.updateOnEvent(this);
        }
    }
}
