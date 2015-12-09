/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public abstract class Swimmer extends Person {
    private static int noOfSwimmers = 0; //Global Variable to hold # of swimmers
    
    public Swimmer(String name){
        super(name);                //Set the name
        noOfSwimmers++;             //Increment number of Swimmers
    }
    
    /**
     *
     * @return Number of Swimmers
     */
    public static int getNoOfSwimmers(){
        return noOfSwimmers;
    }
    
    // Methods for Swim
    public abstract void swimFreeStyle();
    public abstract void swimButterflyStroke();
    public abstract void swimBackStroke();
    public abstract void swimBreastStroke();
    
    /**
     * Simulate Kick
     * @return
     */
    public boolean kick(){
        return true;
    }
    
    /**
     *Simulate Left hand Movement
     */
    public void moveLeftHand(){
        
    }
    
    /**
     *Simulate Right hand Movement
     */
    public void moveRightHand(){
        
    }
    
    /**
     *Simulate Left and Right hand Movement at the Same time
     */
    public void moveBothHands(){
        
    }
    
    /**
     *Simulate Breath
     */
    public void breath(){
        
    }
}
