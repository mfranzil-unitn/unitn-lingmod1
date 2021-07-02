/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201107;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

/**
 * @author Matteo Franzil
 */
public class Rett extends GridPane {

    public static final int size = 65;
    Button x, o, c, r;
    Character mode;

    public Rett(boolean random) {
        Pane disegno = new StackPane();
        disegno.setPrefHeight(size * 1.2);
        disegno.setPrefWidth(size * 1.2);
        disegno.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        if (random) {
            r = new Button("r");
        } else {
            x = new Button("x");
            o = new Button("o");
        }
        c = new Button("c");
        mode = 'c';

        if (random) {
            r.setOnAction((ActionEvent e) -> {
                disegno.getChildren().clear();
                if (new Random().nextBoolean()) {
                    Ics ics = new Ics(size);
                    disegno.getChildren().add(ics);
                    mode = 'x';
                } else {
                    Circle circle = new Circle(size / 2.0, Color.BLACK);
                    disegno.getChildren().add(circle);
                    mode = 'o';
                }
            });
        } else {
            x.setOnAction((ActionEvent e) -> {
                disegno.getChildren().clear();
                Ics ics = new Ics(size);
                disegno.getChildren().add(ics);
                mode = 'x';
            });

            o.setOnAction((ActionEvent e) -> {
                disegno.getChildren().clear();
                Circle circle = new Circle(size / 2.0, Color.BLACK);
                disegno.getChildren().add(circle);
                mode = 'o';
            });
        }

        c.setOnAction((ActionEvent e) -> {
            disegno.getChildren().clear();
            mode = 'c';
        });

        GridPane.setConstraints(disegno, 0, 0, 3, 3);
        if (random) {
            GridPane.setConstraints(r, 1, 3);
        } else {
            GridPane.setConstraints(x, 2, 3);
            GridPane.setConstraints(o, 1, 3);
        }
        GridPane.setConstraints(c, 0, 3);

        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        row1.setPercentHeight(80);
        row1.setPercentHeight(20);
        getRowConstraints().addAll(row1, row2);

        if (random) {
            getChildren().add(r);
        } else {
            getChildren().addAll(x, o);
        }
        getChildren().addAll(c, disegno);
    }

    public void reset() {
        c.fire();
    }

    @Override
    public String toString() {
        return "RETT di tipo" + (r != null ? " random " : " normale ") + "con " + (mode == 'c' ? "niente" : mode);
    }

}
