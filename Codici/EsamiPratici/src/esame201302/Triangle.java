/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201302;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 * @author Matteo Franzil
 */
public class Triangle extends Polygon {

    public Triangle(double x, double y, double size) {
        getPoints().addAll(new Double[]{
                x, y,
                x + size, y,
                x + size / 2.0, y + (size * Math.sqrt(3) / 2.0)});
        setFill(Color.BLUE);
    }
}
