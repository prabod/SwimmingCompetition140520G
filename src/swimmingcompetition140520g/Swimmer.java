/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swimmingcompetition140520g;


public class Swimmer extends Person {
    private static int noOfSwimmers = 0;
    
    public Swimmer(String name){
        super(name);                //Set the name
        noOfSwimmers++;             //Increment number of Swimmers
    }
    
    /**
     *
     * @return Number of Swimmers
     */
    public static int getNoOfSwimmers(){
        return noOfSwimmers;
    }
}
