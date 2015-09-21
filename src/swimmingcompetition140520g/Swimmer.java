/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swimmingcompetition140520g;


public class Swimmer extends Person {
    private final Gender gender;
    protected String clothColor;
    
    public Swimmer(String name,Gender gender){
        super(name);                //Set the name
        this.gender = gender;       //Set the Gender
        setClothColor();            //Set the ClothColor
    }
    
    private void setClothColor(){
        try{
            if (this.gender == Gender.MALE){
                this.clothColor = "Blue";
            }
            else if (this.gender == Gender.FEMALE){
                this.clothColor = "Red";
            }
        }
        catch(NullPointerException e){}
    }
    
}
