package luca_esame201406;

import javafx.scene.shape.Shape;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucamartinelli
 */
public class Figura {

    double x;
    double y;
    Shape forma;

    Figura() {
        x = 0;
        y = 0;
    }

    Figura(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
