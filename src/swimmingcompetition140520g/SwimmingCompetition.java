/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swimmingcompetition140520g;

import model.*;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Student
 */
public class SwimmingCompetition {

    private static int noOfFSwimmers;                          //# of Female Swimmers
    private static int noOfMSwimmers;                          //# of Male Swimmers
    private static int noOfLanes;                              //# of Lanes
    private static int noOfSpectators;                         //# of Spectators
    private static int noOfJudges;                             //# of Judges
    private static int noOfSupportStaff;                       //# of Support Staff
    
    public static int type;
    
    static PeopleInfoGUI peopleInfo;
    static SwimmingPool pool;
    static HashMap<String, HashMap> names;

    //Empty Arrays to Hold Swimmers, Lanes, Spectators, Judges
    protected static Swimmer[] mSwimmers;
    protected static Swimmer[] fSwimmers;
    protected static Lane[] lanes;
    protected static Spectator[] spectators;
    protected static Judge[] judges;
    protected static SupportStaff[] supportStaff;
    final static CyclicBarrier gate = new CyclicBarrier(6);

    public static void main(String[] args) {
        SwimmingCompetitionGui SCGui = new SwimmingCompetitionGui();
        SCGui.setVisible(true);
        try {
            gate.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(SwimmingCompetition.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(SwimmingCompetition.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void setType(int typei){
        type = typei;
    }

    public static void createPeople(HashMap<String, HashMap> names) {
        //Create Competition
        if(noOfMSwimmers != 0 ){
            createMaleSwimmers(names.get("mSwimmers"));
        }
        if(noOfFSwimmers != 0){
            createFemaleSwimmers(names.get("fSwimmers"));
        }
        createSpectators();
        createJudges(names.get("judges"));
        createSupportStaff();
        
    }

    public static void setQuantities(List<Integer> quantities) {
        noOfFSwimmers = (int) quantities.get(0);                          //# of Female Swimmers
        noOfMSwimmers = (int) quantities.get(1);                          //# of Male Swimmers
        noOfLanes = 5;                                                    //# of Lanes
        noOfSpectators = (int) quantities.get(2);                         //# of Spectators
        noOfJudges = (int) quantities.get(3);                             //# of Judges
        noOfSupportStaff = (int) quantities.get(4);
    }

    private static void createMaleSwimmers(HashMap<String, String> names) {
        SwimmingCompetition.mSwimmers = new Swimmer[SwimmingCompetition.noOfMSwimmers];
        for (int i = 0; i < SwimmingCompetition.noOfMSwimmers; i++) {
            SwimmingCompetition.mSwimmers[i] = new MaleSwimmer((String) names.get("mSwimmer" + i + 1));
        }
    }

    private static void createFemaleSwimmers(HashMap<String, String> names) {
        SwimmingCompetition.fSwimmers = new Swimmer[SwimmingCompetition.noOfFSwimmers];
        for (int i = 0; i < SwimmingCompetition.noOfFSwimmers; i++) {
            SwimmingCompetition.fSwimmers[i] = new FemaleSwimmer((String) names.get("fSwimmer" + i + 1));
        }
    }

    private static void createSupportStaff() {
        SwimmingCompetition.supportStaff = new SupportStaff[SwimmingCompetition.noOfSupportStaff];
        for (int i = 0; i < SwimmingCompetition.noOfSupportStaff; i++) {
            SwimmingCompetition.supportStaff[i] = new SupportStaff();
        }
    }

    public static void createLanes() {
        SwimmingCompetition.lanes = new Lane[SwimmingCompetition.noOfLanes];
        int limit = SwimmingCompetition.noOfLanes;
        Swimmer[] temp = null;
        if(SwimmingCompetition.type == 1){
            temp = mSwimmers;
        }
        else if (SwimmingCompetition.type == 2){
            temp = fSwimmers;
        }   
        for (int i = 0; i < temp.length; i++) {
            lanes[i] = new Lane(i,temp[i],gate);
        }
        
    }
    public static void startit(){
        for (Lane lane : lanes) {
            lane.start();
        }
    }
    
    private static void createSpectators() {
        SwimmingCompetition.spectators = new Spectator[SwimmingCompetition.noOfSpectators];
        for (int i = 0; i < SwimmingCompetition.noOfSpectators; i++) {
            SwimmingCompetition.spectators[i] = new Spectator();
        }
    }

    private static void createJudges(HashMap<String, String> names) {
        SwimmingCompetition.judges = new Judge[SwimmingCompetition.noOfJudges];
        for (int i = 0; i < SwimmingCompetition.noOfJudges; i++) {
            SwimmingCompetition.judges[i] = new Judge((String) names.get("judge " + i + 1));
        }
    }

}
