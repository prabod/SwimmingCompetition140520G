/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swimmingcompetition140520g;


public class FemaleSwimmer extends Swimmer {
    
    protected final String clothColor = "Blue";
    
    public FemaleSwimmer(String name) {
        super(name);
    }

    @Override
    public void swimFreeStyle() {
        while(kick()){
            moveLeftHand();
            breath();
            moveRightHand();
            breath();
        }
    }

    @Override
    public void swimButterflyStroke() {
        
        while(true){
            kick();
            moveBothHands();
            breath();
            kick();
        }
    }

    @Override
    public void swimBackStroke() {
        while(kick()){
            moveLeftHand();
            moveRightHand();
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
