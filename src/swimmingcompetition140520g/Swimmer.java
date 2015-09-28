/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swimmingcompetition140520g;


public abstract class Swimmer extends Person {
    private static int noOfSwimmers = 0;
    
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
    
    public abstract void swimFreeStyle();
    public abstract void swimButterflyStroke();
    public abstract void swimBackStroke();
    public abstract void swimBreastStroke();
    
    public boolean kick(){
        return true;
    }
    public void moveLeftHand(){
        
    }
    
    public void moveRightHand(){
        
    }
    
    public void moveBothHands(){
        
    }
    
    public void breath(){
        
    }
}
