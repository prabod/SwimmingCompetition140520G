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

    private final int noOfFSwimmers;                          //# of Female Swimmers
    private final int noOfMSwimmers;                          //# of Male Swimmers
    private final int noOfLanes;                              //# of Lanes
    private final int noOfSpectators;                         //# of Spectators
    private final int noOfJudges;                             //# of Judges
    private final int noOfSupportStaff;                       //# of Support Staff
    
    //Empty Arrays to Hold Swimmers, Lanes, Spectators, Judges
    private Swimmer[] mSwimmers;
    private Swimmer[] fSwimmers;
    private Lane[] lanes;
    private Spectator[] spectators;
    private Judge[] judges;
    private SupportStaff[] supportStaff;
    
    protected ArrayList<Person> people = new ArrayList<>();
    
    public SwimmingCompetition(int noOfMSwimmers,int noOfFSwimmers,int noOfLanes,
            int noOfSpectators, int noOfJudges ,int noOfSupportStaff){
        
        //Set No Of Each Fields
        this.noOfFSwimmers = noOfFSwimmers;
        this.noOfMSwimmers = noOfMSwimmers;
        this.noOfLanes = noOfLanes;
        this.noOfSpectators = noOfSpectators;
        this.noOfJudges = noOfJudges;
        this.noOfSupportStaff = noOfSupportStaff;
        
        //Create Competition
        createMaleSwimmers();
        createFemaleSwimmers();
        createSpectators();
        createJudges();
        createSupportStaff();
        
        
        //add people to arrayList
        people.addAll(Arrays.asList(this.mSwimmers));
        people.addAll(Arrays.asList(this.fSwimmers));
        people.addAll(Arrays.asList(this.judges));
        people.addAll(Arrays.asList(this.spectators));
        people.addAll(Arrays.asList(this.supportStaff));
        
        
    }
    
    private void createMaleSwimmers(){
        this.mSwimmers = new Swimmer[this.noOfMSwimmers];
        for (int i = 0 ; i < this.noOfMSwimmers ; i++){
            this.mSwimmers[i] = new MaleSwimmer("Male Swimmer " + i + 1);
        }
        createLanes();
    }
    
    private void createFemaleSwimmers(){
        this.fSwimmers = new Swimmer[this.noOfFSwimmers];
        for (int i = 0 ; i < this.noOfFSwimmers ; i++){
            this.fSwimmers[i] = new FemaleSwimmer("Female Swimmer " + i + 1);
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
        int limit = this.noOfLanes >= this.noOfMSwimmers + this.noOfFSwimmers ? 
                this.noOfFSwimmers + this.noOfMSwimmers : this.noOfLanes; 
        int j = 0;
        for (int i = 0 ; i < limit ; i++){
            if(i%2 == 0){
                try{
                    this.lanes[i] = new Lane(i+1,this.mSwimmers[j]);
                }
                catch(NullPointerException | ArrayIndexOutOfBoundsException e){
                }
            }
            else{
                try{
                    this.lanes[i] = new Lane(i+1,this.fSwimmers[j]);
                }
                catch(NullPointerException | ArrayIndexOutOfBoundsException e){
                }
                j++;
            }
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
        return "# of People " + getNoOfPeople();
    }
}
