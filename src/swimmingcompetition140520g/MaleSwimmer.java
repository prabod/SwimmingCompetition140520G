/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swimmingcompetition140520g;

/**
 *
 * @author Student
 */
public class MaleSwimmer extends Swimmer {
    
    protected final String clothColor = "Blue"; 
    public MaleSwimmer(String name) {
        super(name);
    }

    @Override
    public void swimFreeStyle() {
        while(kick()){
            moveRightHand();
            breath();
            moveLeftHand();
            breath();
        }
    }

    @Override
    public void swimButterflyStroke() {
        
        while(true){
            kick();
            moveBothHands();
            kick();
            breath();
        }
    }

    @Override
    public void swimBackStroke() {
        while(kick()){
            moveRightHand();
            moveLeftHand();
            breath();
        }
    }

    @Override
    public void swimBreastStroke() {
        while(true){
            kick();
            moveBothHands();
            breath();
        }
    }
    
}
