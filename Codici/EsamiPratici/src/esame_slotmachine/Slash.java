/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame_slotmachine;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Matteo Franzil
 */
public class Slash extends Rectangle {

    public Slash(int size) {
        super(size, size/10);
        setRotate(75);
        setFill(Color.CHOCOLATE);
    }
}
