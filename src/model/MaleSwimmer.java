/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Student
 */
public class MaleSwimmer extends Swimmer {
    
    protected final String clothColor = "Blue"; 
    public MaleSwimmer(String name) {
        super(name);
    }

    /**
     *Simulate FreeStyle
     */
    @Override
    public void swimFreeStyle() {
        while(kick()){
            moveRightHand();
            breath();
            moveLeftHand();
            breath();
        }
    }

    /**
     *Simulate Butterfly Stroke
     */
    @Override
    public void swimButterflyStroke() {
        
        while(true){
            kick();
            moveBothHands();
            kick();
            breath();
        }
    }

    /**
     *Simulate Back Stroke
     */
    @Override
    public void swimBackStroke() {
        while(kick()){
            moveRightHand();
            moveLeftHand();
            breath();
        }
    }

    /**
     *Simulate Breast Stroke
     */
    @Override
    public void swimBreastStroke() {
        while(true){
            kick();
            moveBothHands();
            breath();
        }
    }
    
}
