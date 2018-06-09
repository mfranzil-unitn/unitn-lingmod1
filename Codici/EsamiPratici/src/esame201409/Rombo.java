/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201409;

import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Matteo Franzil
 */
public class Rombo extends Quadrato {

    public Rombo(int size) {
        super(size);
        setRotate(45);
        setFill(Color.BROWN);

    }

}
