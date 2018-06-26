/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201409;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author Matteo Franzil
 */
public class Slash extends Rectangle {

    public Slash(int size) {
        super(size, size / 10);
        setRotate(75);
        setFill(Color.CHOCOLATE);
    }
}
