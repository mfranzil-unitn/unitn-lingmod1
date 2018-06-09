/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201601;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Matteo Franzil
 */
public class Quadrato extends Rectangle {

    public Quadrato(double x, double y, double size, Color c) {
        super(x, y, size, size);
        setFill(c);
    }

}
