/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201107;

import javafx.scene.shape.Polygon;

/**
 * @author Matteo Franzil
 */
public class Ics extends Polygon {

    public Ics(double size) {
        double x = 0;
        double y = 0;

        getPoints().addAll(
                x, y,
                x, y + size / 2,
                x - size / 6, y + size / 2,
                x - size / 6, y,
                x - size / 6 - size / 2, y,
                x - size / 6 - size / 2, y - size / 6,
                x - size / 6, y - size / 6,
                x - size / 6, y - size / 6 - size / 2,
                x, y - size / 6 - size / 2,
                x, y - size / 6,
                x + size / 2, y - size / 6,
                x + size / 2, y
        );
        setRotate(45);
    }

}
