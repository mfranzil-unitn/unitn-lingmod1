/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.franzil.lab5;

import javafx.scene.canvas.GraphicsContext;

/**
 * @author nicolo.gottardello
 */
public class Segmento {
    double x_i, y_i, x_f, y_f;

    public Segmento(double x, double y) {
        x_i = x;
        y_i = y;
    }

    public void setFinale(double x, double y) {
        x_f = x;
        y_f = y;
    }

    public void disegna(GraphicsContext gC) {
        gC.strokeLine(x_i, y_i, x_f, y_f);
    }
}
