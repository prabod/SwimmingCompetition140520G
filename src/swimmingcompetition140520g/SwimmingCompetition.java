/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swimmingcompetition140520g;

import java.util.ArrayList;
import model.*;
import java.util.HashMap;
import java.util.List;

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
    static ScoreBoard sBoard;
    static PeopleInfoGUI peopleInfo;
    static SwimmingPool pool;
    static HashMap<String, HashMap> names;

    //Empty Arrays to Hold Swimmers, Lanes, Spectators, Judges
    protected static ArrayList<Swimmer> mSwimmers = new ArrayList<>();
    protected static ArrayList<Swimmer> fSwimmers = new ArrayList<>();
    protected static ArrayList<Lane> lanes = new ArrayList<>();
    protected static ArrayList<Spectator> spectators = new ArrayList<>();
    protected static ArrayList<Judge> judges = new ArrayList<>();
    protected static ArrayList<SupportStaff> supportStaff = new ArrayList<>();

    public static void main(String[] args) {
        SwimmingCompetitionGui SCGui = new SwimmingCompetitionGui();
        SCGui.setVisible(true);
        sBoard = new ScoreBoard();
        
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
        noOfMSwimmers = (int) quantities.get(0);                          //# of Female Swimmers
        noOfFSwimmers = (int) quantities.get(1);                          //# of Male Swimmers
        noOfLanes = 5;                                                    //# of Lanes
        noOfSpectators = (int) quantities.get(2);                         //# of Spectators
        noOfJudges = (int) quantities.get(3);                             //# of Judges
        noOfSupportStaff = (int) quantities.get(4);
    }

    private static void createMaleSwimmers(HashMap<String, String> names) {
        for (int i = 0; i < SwimmingCompetition.noOfMSwimmers; i++) {
            String name = names.get("mSwimmer" + (i + 1));
            mSwimmers.add(new MaleSwimmer(name));
        }
    }

    private static void createFemaleSwimmers(HashMap<String, String> names) {
        for (int i = 0; i < SwimmingCompetition.noOfFSwimmers; i++) {
            fSwimmers.add(new FemaleSwimmer((String) names.get("fSwimmer" + (i + 1))));
        }
    }

    private static void createSupportStaff() {
        for (int i = 0; i < noOfSupportStaff; i++) {
            supportStaff.add(new SupportStaff());
        }
    }

    public static void createLanes() {
        ArrayList<Swimmer> temp = null;
        if(type == 1){
            temp = mSwimmers;
        }
        else if (type == 2){
            temp = fSwimmers;
        }   
        
        for (int i = 0; i < temp.size(); i++) {
            lanes.add(new Lane(i,temp.get(i)));
            lanes.get(i).addObserver(sBoard);
        }
    }
    public static void startit(){
        for (Lane lane : lanes) {
            lane.start();
        }
        sBoard.setNames();
           
    }
    
    public static void notifySpec(HashMap scores){
        for(Spectator spec: spectators){
            spec.watch(scores);
        }
    }
    
    private static void createSpectators() {
        for (int i = 0; i < noOfSpectators; i++) {
            spectators.add(new Spectator());
        }
    }

    private static void createJudges(HashMap<String, String> names) {
        for (int i = 0; i < noOfJudges; i++) {
            judges.add(new Judge((String) names.get("judge " + (i + 1))));
        }
    }

}
