/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swimmingcompetition140520g;

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
    
    private static int type;
    
    static PeopleInfoGUI peopleInfo;
    static HashMap<String, HashMap> names;

    //Empty Arrays to Hold Swimmers, Lanes, Spectators, Judges
    protected static Swimmer[] mSwimmers;
    protected static Swimmer[] fSwimmers;
    protected static Lane[] lanes;
    protected static Spectator[] spectators;
    protected static Judge[] judges;
    protected static SupportStaff[] supportStaff;

    public static void main(String[] args) {
        SwimmingCompetitionGui SCGui = new SwimmingCompetitionGui();
        SCGui.setVisible(true);
        peopleInfo = new PeopleInfoGUI(noOfMSwimmers, noOfFSwimmers,
                noOfSpectators, noOfJudges, noOfSupportStaff);

    }
    public static void setType(int type){
        SwimmingCompetition.type = type;
        createLanes(type);
    }

    public static void createPeople(HashMap<String, HashMap> names) {
        //Create Competition
        createMaleSwimmers(names.get("mSwimmers"));
        createFemaleSwimmers(names.get("fSwimmers"));
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

    private static void createLanes(int type) {
        SwimmingCompetition.lanes = new Lane[SwimmingCompetition.noOfLanes];
        int limit = SwimmingCompetition.noOfLanes;
        Swimmer[] temp = null;
        if(type == 1){
            temp = mSwimmers;
        }
        else if (type == 2){
            temp = fSwimmers;
        }
        int j = 0;
        for (int i = 0; i < limit; i++) {
            lanes[i] = new Lane(i,temp[i]);
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
