/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JLabel;
import view.SwimmingPool;

/**
 *
 * @author Student
 */
public class Lane extends Observable implements Runnable {

    Thread t;
    protected int laneNumber;
    protected Swimmer swimmer;
    protected long startTime;
    protected float finishTime;
    protected Touchpad touchpad;
    JLabel label;

    @Override
    public void run() {

        change();

    }

    public Lane(int laneNumber, Swimmer swimmer) {
        this.laneNumber = laneNumber;
        this.swimmer = swimmer;
        this.touchpad = new Touchpad();
    }

    public synchronized void change() {                      //change the icons location
        while (SwimmingPool.returnX(label) <= 700) {
            long cTime = System.currentTimeMillis() - this.startTime;
            setChanged();
            ArrayList s = new ArrayList();
            s.add((float) cTime / 1000);
            s.add(this.laneNumber);
            if (SwimmingPool.returnX(label)==700){
                s.add(true);
                touchpad.touch((float) cTime / 1000);
                setFinishTime((float) cTime / 1000);
            }
            else s.add(false);
            notifyObservers(s);                             //notify scoreboard
            SwimmingPool.setX(label, SwimmingPool.returnX(label) + 1);
            try {
                Thread.sleep(swimmer.speed);                
            } catch (InterruptedException ex) {
            }
        }

    }

    public void setLabel(JLabel label) {
        this.label = label;
    }
    public Swimmer getSwimmer(){
        return this.swimmer;
    }
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setFinishTime(float finishTime) {
        this.finishTime = finishTime;
    }

    public void start() {
        if (t == null) {
            t = new Thread(this);
            t.start();              //start the thread
            setStartTime(System.currentTimeMillis()); //set start time
        }
    }
    public void stop(){
        t.stop();           //stop the thread
    }

}
