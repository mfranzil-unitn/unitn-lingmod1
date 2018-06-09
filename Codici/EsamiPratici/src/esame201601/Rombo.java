/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201601;

import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Matteo Franzil
 */
public class Rombo extends Quadrato {

    public Rombo(double x, double y, double size, Color c) {
        super(x - size / 2, y - size / 2, size, c);
        Rotate rot = new Rotate(45, x, y);
        getTransforms().add(rot);
    }

}
