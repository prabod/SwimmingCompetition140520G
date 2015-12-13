/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;

/**
 *
 * @author prabod
 */
public class SupportStaff extends Person {
    private HashMap scores;
    public SupportStaff(){
        super();
        
    }
    public void watch(HashMap score){
        this.scores = score;
    }
}
