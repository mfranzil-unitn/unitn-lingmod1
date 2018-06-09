/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201409;

import java.util.LinkedList;
import java.util.Random;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Matteo Franzil
 */
public class SpinItem extends StackPane {

    LinkedList<Shape> forme;
    private int currentshape;

    public SpinItem(Pannello panel) {
        setPrefHeight(200);
        setPrefWidth(400);
        forme = new LinkedList<>();
        currentshape = -1;
        setForme();
        getChildren().addAll(forme);

        addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            if (panel.getPunteggio() > 0) {
                switchShape();
            }
        });

        setStyle("-fx-border-color: black");
    }

    private void setForme() {
        forme.add(new Circle(25, Color.BLUE));
        forme.add(new Triangolo(50));
        forme.add(new Quadrato(50));
        forme.add(new Rombo(50));
        forme.add(new Plus(50));
        forme.add(new Slash(50));
        for (int i = 0; i < forme.size(); i++) {
            forme.get(i).setVisible(false);
        }
    }

    public void switchShape(int number) {
        if (currentshape > -1 && number > -1) {
            forme.get(currentshape).setVisible(false);
            forme.get(number).setVisible(true);
        } else if (currentshape > -1 && number <= -1) {
            forme.get(currentshape).setVisible(false);
        }

        currentshape = number;
    }

    public void switchShape() {
        System.out.println(forme.size());
        int number = new Random().nextInt(forme.size());
        if (currentshape > -1) {
            forme.get(currentshape).setVisible(false);
        }
        forme.get(number).setVisible(true);
        currentshape = number;
    }

    public int getCurrentshape() {
        return currentshape;
    }

}
