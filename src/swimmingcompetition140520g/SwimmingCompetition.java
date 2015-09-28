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
public class SwimmingCompetition{

    private int noOfSwimmers;
    private int noOfLanes;
    private int noOfSpectators;
    private int noOfJudges;
    private Swimmer[] swimmers;
    private Lane[] lanes;
    private Spectator[] spectators;
    private Judge[] judges;
    public SwimmingCompetition(int noOfSwimmers,int noOfLanes,
            int noOfSpectators, int noOfJudges){
        this.noOfSwimmers = noOfSwimmers;
        this.noOfLanes = noOfLanes;
        this.noOfSpectators = noOfSpectators;
        this.noOfJudges = noOfJudges;
    }
    
    public void createSwimmers(){
        this.swimmers = new Swimmer[this.noOfSwimmers];
    }
    
    public void createLanes(){
        this.lanes = new Lane[this.noOfLanes];
    }
    
    public void createSpectators(){
        this.spectators = new Spectator[this.noOfSpectators];
    }
    
    public void createJudges(){
        this.judges = new Judge[this.noOfJudges];
    }
    
}
