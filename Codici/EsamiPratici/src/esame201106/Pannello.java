/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201106;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author Matteo Franzil
 */
public class Pannello extends GridPane {

    public static final int N = 5;
    public static final Color C1 = Color.AQUA;
    public static final Color C2 = Color.CORAL;
    public static final Color C3 = Color.GOLD;
    public static final Color C4 = Color.LIGHTSTEELBLUE;

    public Pannello() {
        Cella cella;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((j + i) % 2 == 0) {
                    cella = new Cella(C1);
                } else {
                    cella = new Cella(C2);
                }
                GridPane.setConstraints(cella, j, i, 1, 1);
                getChildren().addAll(cella);
            }

            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100.0 / N);
            getColumnConstraints().add(column);

            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 / N);
            getRowConstraints().add(row);
        }
    }

    public void stampa() {
        TextArea area = new TextArea();
        for (Node a : getChildren()) {
            area.appendText(a.toString() + " in posizione " + GridPane.getRowIndex(a) + " " + GridPane.getColumnIndex(a) + "\n");
        }
        Scene scene = new Scene(area);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Boh");
        stage.show();
    }

    public void resetAll() {
        getChildren().clear();
        Cella cella;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((j + i) % 2 == 0) {
                    cella = new Cella(C1);
                } else {
                    cella = new Cella(C2);
                }
                GridPane.setConstraints(cella, j, i, 1, 1);
                getChildren().addAll(cella);
            }
        }
    }

    public void mescola() {
        LinkedList<Cella> celle = new LinkedList<>();
        for (Node a : getChildren()) {
            if (a instanceof Cella) {
                celle.add((Cella) a);
            }
        }
        getChildren().clear();
        Collections.shuffle(celle);
        Cella cella;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cella = celle.get(i * N + j);
                GridPane.setConstraints(cella, j, i, 1, 1);
                getChildren().addAll(cella);
            }

        }
    }
}
