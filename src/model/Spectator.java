/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;

/**
 *
 * @author prabod
 */
public class Spectator extends Person{
    
    private HashMap scores;
    private static int noOfSpectators = 0;
    
    public Spectator() {
        super();                        //Construct person
        noOfSpectators++;               //Increment number of Spectators
    }
    
    /**
     * Set Spectator state to Watching
     */
    public void watch(HashMap score){
        this.scores = score;
    }
    
    /**
     *
     * @return Number of Spectators
     */
    public static int getNoOfSpectators(){
        return noOfSpectators;
    }
}
