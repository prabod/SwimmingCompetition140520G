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

    private final int noOfSwimmers;                           //# of Swimmers
    private final int noOfLanes;                              //# of Lanes
    private final int noOfSpectators;                         //# of Spectators
    private final int noOfJudges;                             //# of Judges
    private final int noOfSupportStaff;                       //# of Support Staff
    
    //Empty Arrays to Hold Swimmers, Lanes, Spectators, Judges
    private Swimmer[] swimmers;
    private Lane[] lanes;
    private Spectator[] spectators;
    private Judge[] judges;
    private SupportStaff[] supportStaff;
    
    protected ArrayList<Person> people = new ArrayList<>();
    
    public SwimmingCompetition(int noOfSwimmers,int noOfLanes,
            int noOfSpectators, int noOfJudges ,int noOfSupportStaff){
        
        //Set No Of Each Fields
        this.noOfSwimmers = noOfSwimmers;
        this.noOfLanes = noOfLanes;
        this.noOfSpectators = noOfSpectators;
        this.noOfJudges = noOfJudges;
        this.noOfSupportStaff = noOfSupportStaff;
        
        //Create Competition
        createSwimmers();
        createSpectators();
        createJudges();
        createSupportStaff();
        
        
        //add people to arrayList
        people.addAll(Arrays.asList(this.swimmers));
        people.addAll(Arrays.asList(this.judges));
        people.addAll(Arrays.asList(this.spectators));
        people.addAll(Arrays.asList(this.supportStaff));
        
        
    }
    
    private void createSwimmers(){
        this.swimmers = new Swimmer[this.noOfSwimmers];
        for (int i = 0 ; i < this.noOfSwimmers ; i++){
            this.swimmers[i] = new MaleSwimmer("Male Swimmer " + i + 1);
        }
        createLanes();
    }
    
    private void createSupportStaff(){
        this.supportStaff = new SupportStaff[this.noOfSupportStaff];
        for (int i = 0 ; i < this.noOfSupportStaff ; i++){
            this.supportStaff[i] = new SupportStaff();
        }
    }
    
    private void createLanes(){
        this.lanes = new Lane[this.noOfLanes];
        System.out.println(this.noOfLanes);
        int limit = this.noOfLanes >= this.noOfSwimmers ? 
                this.noOfSwimmers : this.noOfLanes; 
        for (int i = 0 ; i < limit ; i++){
            this.lanes[i] = new Lane(i+1,this.swimmers[i]);
        }
    }
    
    private void createSpectators(){
        this.spectators = new Spectator[this.noOfSpectators];
        for (int i = 0 ; i < this.noOfSpectators ; i++){
            this.spectators[i] = new Spectator();
        }
    }
    
    private void createJudges(){
        this.judges = new Judge[this.noOfJudges];
        for (int i = 0 ; i < this.noOfJudges ; i++){
            this.judges[i] = new Judge("Judge " + i + 1);
        }
    }
    
    public int getNoOfPeople(){
        return people.size();
    }
    
    @Override
    public String toString(){
        return "# of People" + getNoOfPeople();
    }
}
