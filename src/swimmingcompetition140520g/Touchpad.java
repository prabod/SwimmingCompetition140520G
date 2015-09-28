/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swimmingcompetition140520g;

/**
 *
 * @author Student
 */
public class Touchpad {
    protected boolean touched;
    protected float time;
    
    public Touchpad(){
        
    }
    public void touch(float time){
        this.time = time;
        this.touched = true;
    }
    
    public float getTime(){
        return this.time;
    }
}
