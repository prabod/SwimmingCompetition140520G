/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swimmingcompetition140520g;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import model.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Student
 */
public class SwimmingCompetition{

    private static int noOfFSwimmers;                          //# of Female Swimmers
    private static int noOfMSwimmers;                          //# of Male Swimmers
    private static int noOfLanes;                              //# of Lanes
    private static int noOfSpectators;                         //# of Spectators
    private static int noOfJudges;                             //# of Judges
    private static int noOfSupportStaff;                       //# of Support Staff
    
    //Empty Arrays to Hold Swimmers, Lanes, Spectators, Judges
    protected Swimmer[] mSwimmers;
    protected Swimmer[] fSwimmers;
    protected Lane[] lanes;
    protected Spectator[] spectators;
    protected Judge[] judges;
    protected SupportStaff[] supportStaff;
   
    
    public static void main(String[] args) {
        SwimmingCompetitionGui SCGui = new SwimmingCompetitionGui();
        SCGui.setVisible(true);
        List quantities = SCGui.getInfo();
        noOfFSwimmers = (int) quantities.get(0);                          //# of Female Swimmers
        noOfMSwimmers = (int) quantities.get(1);                          //# of Male Swimmers
        noOfLanes = 5;                                                    //# of Lanes
        noOfSpectators = (int) quantities.get(2);                         //# of Spectators
        noOfJudges = (int) quantities.get(3);                             //# of Judges
        noOfSupportStaff = (int) quantities.get(4);
        final PeopleInfoGUI peopleInfo = new PeopleInfoGUI(noOfMSwimmers, noOfFSwimmers ,
                                    noOfSpectators, noOfJudges, noOfSupportStaff);
        SCGui.addWindowListener(new WindowListener(){

            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                peopleInfo.setVisible(true);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                 peopleInfo.setVisible(true);
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
        
        
    }
        /*
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
        
    */
        
    private void createMaleSwimmers(HashMap names){
        this.mSwimmers = new Swimmer[this.noOfMSwimmers];
        for (int i = 0 ; i < this.noOfMSwimmers ; i++){
            this.mSwimmers[i] = new MaleSwimmer((String) names.get("mSwimmer" + i + 1));
        }
        createLanes();
    }
    
    private void createFemaleSwimmers(HashMap names){
        this.fSwimmers = new Swimmer[this.noOfFSwimmers];
        for (int i = 0 ; i < this.noOfFSwimmers ; i++){
            this.fSwimmers[i] = new FemaleSwimmer((String) names.get("fSwimmer" + i + 1));
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
    
    private void createJudges(HashMap names){
        this.judges = new Judge[this.noOfJudges];
        for (int i = 0 ; i < this.noOfJudges ; i++){
            this.judges[i] = new Judge((String) names.get("judge " + i + 1));
        }
    }
    
    

}
