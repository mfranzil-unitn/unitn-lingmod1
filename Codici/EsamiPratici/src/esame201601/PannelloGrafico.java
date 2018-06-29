/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201601;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.LinkedList;

/**
 * @author Matteo Franzil
 */
public class PannelloGrafico extends Pane {

    public static final int X = 600;

    private int shapeCounter;
    private boolean isFirst;
    private LinkedList<Shape> figure;

    private Color C1, C2;
    private double size;

    public PannelloGrafico() {
        shapeCounter = 0;
        isFirst = true;
        figure = new LinkedList<>();

        C1 = Color.BLACK;
        C2 = Color.BLACK;
        size = 30;

        Stage graphicStage = new Stage();
        Scene graphicScene = new Scene(this, X, X);

        addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
            switch (shapeCounter % 3) {
                case 0:
                    Quadrato quad = new Quadrato(e.getX(), e.getY(), size, getColor(e.getX()));
                    figure.add(quad);
                    getChildren().add(quad);
                    break;
                case 1:
                    Cerchio circ = new Cerchio(e.getX(), e.getY(), size / 2, getColor(e.getX()));
                    figure.add(circ);
                    getChildren().add(circ);
                    break;
                case 2:
                    Rombo rombo = new Rombo(e.getX(), e.getY(), size, getColor(e.getX()));
                    figure.add(rombo);
                    getChildren().add(rombo);
                    break;
                default:
                    break;
            }
            shapeCounter++;
        });

        graphicScene.setOnKeyPressed((KeyEvent e) -> {
            switch (e.getCode()) {
                case C:
                    clear();
                    break;
                case L:
                    clearLast();
                    break;
                case F:
                    clearFirst();
                    break;
                default:
                    break;
            }
        });

        graphicStage.setTitle("Pannello grafico");
        graphicStage.setScene(graphicScene);
        graphicStage.setOnCloseRequest((WindowEvent e) -> {
            e.consume();
        });
        graphicStage.show();
    }

    public Color getColor(double x) {
        Color res;
        if (isFirst) {
            res = Color.BLACK;
            isFirst = false;
        } else {
            res = (x < getLastX() ? C2 : C1);
        }
        return res;
    }

    public double getLastX() {
        double res;
        Shape temp = figure.peekLast();
        if (temp instanceof Cerchio) {
            res = ((Cerchio) temp).getCenterX();
        } else if (temp instanceof Quadrato) {
            res = ((Quadrato) temp).getX();
        } else {
            res = -1;
        }
        return res;
    }

    public void clear() {
        shapeCounter = 0;
        isFirst = true;
        figure.clear();
        getChildren().clear();
    }

    public void clearFirst() {
        if (!figure.isEmpty()) {
            Shape temp = figure.removeFirst();
            getChildren().remove(temp);
        }
    }

    public void clearLast() {
        if (!figure.isEmpty()) {
            Shape temp = figure.removeLast();
            getChildren().remove(temp);
        }
    }

    public void setC1(Color C1) {
        this.C1 = C1;
    }

    public void setC2(Color C2) {
        this.C2 = C2;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public LinkedList<Shape> getFigure() {
        return figure;
    }

}
