/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 140520G
 */
public abstract class Person {
    protected String name;
    
    Person(String name){
        this.name = name;           //Set the name
        
    }
    
    //Blank Constructor for Objects that doesn't have a unique name
    Person(){}
    
    public void setName(String Name){
        this.name = Name;
    }
}
    