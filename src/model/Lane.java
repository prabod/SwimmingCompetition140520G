/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Student
 */
public class Lane {
    
    protected int laneNumber;
    protected Swimmer swimmer;
    protected float startTime;
    protected float finishTime;
    protected Touchpad touchpad;
    
    public Lane(int laneNumber, Swimmer swimmer){
        this.laneNumber = laneNumber;
        this.swimmer = swimmer;
    }
    
    public void  setStartTime(float startTime){
        this.startTime = startTime;
    }
    
    public void  setFinishTime(float finishTime){
        this.finishTime = finishTime;
    }
    
}
