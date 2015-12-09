/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author prabod
 */
public class Judge extends Person{
    
    private boolean whistle;
    
    private static int noOfJudges = 0;
    
    /**
     *
     * @param name
     */
    public Judge(String name){
        super(name);                        //constructs a person with name
        noOfJudges++;                       //Increase the judge count
    }
    
    /**
     *
     * @return number of Judges
     */
    public int getNoOfJudges(){
        return noOfJudges;
    } 
    
    /**
     *
     * @return true if blows Whistle
     */
    public boolean blowWhistle(){
        this.whistle = true;
        return this.whistle;
    }
}
