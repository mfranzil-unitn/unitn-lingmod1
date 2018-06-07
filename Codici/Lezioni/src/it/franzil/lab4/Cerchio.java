/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.franzil.lab4;


import javafx.scene.shape.Circle;

/**
 *
 * @author nicolo.gottardello
 */
public class Cerchio extends Circle {

    public Cerchio() {
        setCenterX(100.0f);
        setCenterY(100.0f);
        setRadius(10.0f);
    //    setFill(Paint.valueOf(Color.BLACK));
    }
    
    public void moveX(int offset) {
        setCenterX(getCenterX() + offset);
    }
    
    public void moveY(int offset) {
        setCenterY(getCenterY() + offset);
    }    

}
