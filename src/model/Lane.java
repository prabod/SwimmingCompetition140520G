/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Observable;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import swimmingcompetition140520g.SwimmingPool;

/**
 *
 * @author Student
 */
public class Lane extends Observable implements Runnable {
    Thread t;
    protected int laneNumber;
    protected Swimmer swimmer;
    protected float startTime;
    protected float finishTime;
    protected Touchpad touchpad;
    CyclicBarrier gate;
    JLabel label;
    
    @Override
    public void run(){
        change();
        try {
            gate.await();
        } catch (InterruptedException ex) {
           
        } catch (BrokenBarrierException ex) {
            
        }
    }
    
    public Lane(int laneNumber, Swimmer swimmer, CyclicBarrier gate){
        this.gate = gate;
        this.laneNumber = laneNumber;
        this.swimmer = swimmer;
    }
    
    public void change(){
        while (SwimmingPool.returnX(label)<600){
            SwimmingPool.setX(label,SwimmingPool.returnX(label)+1);
            try {
                Thread.sleep(swimmer.speed);
            } catch (InterruptedException ex) {
                Logger.getLogger(Lane.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void setLabel(JLabel label){
        this.label = label;
    }
    public void  setStartTime(float startTime){
        this.startTime = startTime;
    }
    
    public void  setFinishTime(float finishTime){
        this.finishTime = finishTime;
    }

    public void start() {
        if (t == null)
      {
         t = new Thread (this);
         t.start ();
      }
    }
    
}
