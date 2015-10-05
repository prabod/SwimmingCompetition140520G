/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swimmingcompetition140520g;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Student
 */
public class SwimmingCompetition{

    private int noOfSwimmers;                           //# of Swimmers
    private int noOfLanes;                              //# of Lanes
    private int noOfSpectators;                         //# of Spectators
    private int noOfJudges;                             //# of Judges
    
    //Empty Arrays to Hold Swimmers, Lanes, Spectators, Judges
    private Swimmer[] swimmers;
    private Lane[] lanes;
    private Spectator[] spectators;
    private Judge[] judges;
    
    protected ArrayList<Object> people = new ArrayList<Object>();
    
    public SwimmingCompetition(int noOfSwimmers,int noOfLanes,
            int noOfSpectators, int noOfJudges){
        
        //Set No Of Each Fields
        this.noOfSwimmers = noOfSwimmers;
        this.noOfLanes = noOfLanes;
        this.noOfSpectators = noOfSpectators;
        this.noOfJudges = noOfJudges;
        
        //Create Competition
        createSwimmers();
        createLanes();
        createSpectators();
        createJudges();
        
        //add people to arrayList
        people.addAll(Arrays.asList(this.swimmers));
        people.addAll(Arrays.asList(this.judges));
        people.addAll(Arrays.asList(this.lanes));
        people.addAll(Arrays.asList(this.spectators));
        
        
    }
    
    private void createSwimmers(){
        this.swimmers = new Swimmer[this.noOfSwimmers];
    }
    
    private void createLanes(){
        this.lanes = new Lane[this.noOfLanes];
    }
    
    private void createSpectators(){
        this.spectators = new Spectator[this.noOfSpectators];
    }
    
    private void createJudges(){
        this.judges = new Judge[this.noOfJudges];
    }
    
    public int getNoOfPeople(){
        return people.size();
    }
}
