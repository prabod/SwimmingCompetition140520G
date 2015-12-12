/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swimmingcompetition140520g;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTable;
import model.Lane;

/**
 *
 * @author Student
 */
public class ScoreBoard implements Observer {

    JTable scoreBoard;
    protected HashMap scores;
    protected HashMap times =  new HashMap();

    public void setTable(JTable table) {
        this.scoreBoard = table;
    }

    public void collectFinishTimes() {
         if (this.times.size() == SwimmingCompetition.lanes.size()){
             compareFinishTimes();
         }
    }

    public void insertScore(JTable table, int row, int column, Object value) {
        SwimmingCompetition.pool.updateTable(table, row, column, value);
    }

    public void compareFinishTimes() {
        Object[] a = this.times.entrySet().toArray();
        Arrays.sort(a, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<String, Float>) o2).getValue().compareTo(
                        ((Map.Entry<String, Float>) o1).getValue());
            }
        });
        int i = SwimmingCompetition.lanes.size();
        for (Object e : a) {
            insertScore(this.scoreBoard, Integer.parseInt(((Map.Entry<String, Integer>) e).getKey()), 3, i--);

        }
    }
    
    public void setNames(){
        for(int i = 0 ;i< SwimmingCompetition.lanes.size();i++){
            Lane lane = SwimmingCompetition.lanes.get(i);
            insertScore(this.scoreBoard,i,1,lane.getSwimmer().getName());
            System.out.println(lane.getSwimmer().getName());
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
