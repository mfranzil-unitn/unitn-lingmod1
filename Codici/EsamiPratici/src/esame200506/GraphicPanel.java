/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame200506;

import java.util.Optional;
import java.util.Random;
import javafx.geometry.Insets;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Matteo Franzil
 */
public class GraphicPanel extends Pane {

    private Coordinate target;
    private int d1, d2, d3;

    public GraphicPanel() {
        d1 = 100;
        d2 = 50;

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Valore di D3");
        dialog.setHeaderText("Immetti il valore di D3.");
        Optional result = dialog.showAndWait();

        try {
            result.ifPresent(name -> {
                d3 = Integer.parseInt((String) name);
            });
        } catch (NumberFormatException e) {
            d3 = 10;
        }

        setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));
        setPrefWidth(160);
        setPrefHeight(250);

        addEventHandler(MouseEvent.MOUSE_MOVED, (MouseEvent e) -> {
            if (target != null) {
                Rectangle rect = new Rectangle(e.getX() - 2, e.getY() - 2, 4, 4);
                Coordinate temp = new Coordinate(e.getX(), e.getY());
                double scarto = temp.compareTo(target);
                System.out.println(scarto);
                if (scarto > d1) {
                    rect.setFill(Color.BLACK);
                } else if (scarto < d1 && scarto > d2) {
                    rect.setFill(Color.GREEN);
                } else if (scarto < d2 && scarto > d3) {
                    rect.setFill(Color.BLUE);
                } else if (scarto < d3) {
                    rect.setFill(Color.RED);
                } else if (scarto < 0) {
                    rect.setFill(Color.WHITE);
                } else if (scarto == 0) {
                    rect.setFill(Color.PURPLE);
                }
                getChildren().add(rect);
            }
        });
    }

    public void defineTarget() {
        target = new Coordinate(new Random().nextFloat() * getWidth(), new Random().nextFloat() * getHeight());
    }

    public int getD1() {
        return d1;
    }

    public void setD1(int d1) {
        this.d1 = d1;
    }

    public int getD2() {
        return d2;
    }

    public void setD2(int d2) {
        this.d2 = d2;
    }

    public void drawTarget() {
        Rectangle rect = new Rectangle(target.getX() - 2, target.getY() - 2, 4, 4);
        rect.setFill(Color.PURPLE);
        getChildren().add(rect);
    }

}
