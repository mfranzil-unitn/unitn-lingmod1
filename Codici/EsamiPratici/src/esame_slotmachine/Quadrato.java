/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame_slotmachine;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Matteo Franzil
 */
public class Quadrato extends Rectangle {

    public Quadrato(int size) {
        super(size, size);
        setFill(Color.RED);
    }
    
}
