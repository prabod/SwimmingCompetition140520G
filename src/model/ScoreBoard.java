/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.SwimmingCompetition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTable;

/**
 *
 * @author Student
 */
public class ScoreBoard implements Observer {

    private JTable scoreBoard;
    protected HashMap scores;
    protected HashMap times =  new HashMap();

    public void setTable(JTable table) {
        this.scoreBoard = table;
    }

    public void collectFinishTimes() { //collect finish times from swimmers
         if (this.times.size() == SwimmingCompetition.getLane().size()){
             compareFinishTimes();
             SwimmingCompetition.notifySpec(this.times);
             SwimmingCompetition.notifyJudge(this.times);
             SwimmingCompetition.notifyStaff(this.times);
             SwimmingCompetition.stopit();
         }
    }

    public void insertScore(JTable table, int row, int column, Object value) {
        SwimmingCompetition.pool.updateTable(table, row, column, value);
    }

    public void compareFinishTimes() { //compare finish times and rank them
        Object[] a = this.times.entrySet().toArray();
        Arrays.sort(a, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<String, Float>) o2).getValue().compareTo(
                        ((Map.Entry<String, Float>) o1).getValue());
            }
        });
        int i = SwimmingCompetition.getLane().size();
        for (Object e : a) {
            insertScore(this.scoreBoard, Integer.parseInt(((Map.Entry<String, Integer>) e).getKey()), 3, i--);

        }
    }
    
    public void setNames(){ //set names in the scoreboard
        for(int i = 0 ;i< SwimmingCompetition.getLane().size();i++){
            Lane lane = SwimmingCompetition.getLane().get(i);
            insertScore(this.scoreBoard,i,1,lane.getSwimmer().getName());
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        ArrayList<Object> aList = (ArrayList) arg;

        insertScore(this.scoreBoard, (int) aList.get(1), 2, (float) aList.get(0));
        if ((boolean) aList.get(2)) {
            this.times.put(String.valueOf((int) aList.get(1)), (float) aList.get(0));
            collectFinishTimes();
        }
    }
}
