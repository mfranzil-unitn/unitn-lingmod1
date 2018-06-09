/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201107;

import java.util.Random;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 *
 * @author Matteo Franzil
 */
public class Pannello extends GridPane {

    public static final int N = 4;

    public Pannello() {
        int randomCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                boolean temp = new Random().nextBoolean();
                Rett rett;
                if (temp) {
                    randomCount++;
                }
                if (randomCount <= (N * N / 2)) {
                    rett = new Rett(temp);
                } else {
                    rett = new Rett(false);
                }
                getChildren().add(rett);
                GridPane.setConstraints(rett, j, i);
            }

            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100.0 / N);
            getColumnConstraints().add(column);

            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 / N);
            getRowConstraints().add(row);
        }
        setPadding(new Insets(10, 10, 10, 10));
        setHgap(5);
        setVgap(5);
    }

    public boolean controlla() {
        // Controllo righe e colonne contemporaneamente
        boolean output = false;
        for (int i = 0; i < Pannello.N && !output; i++) {
            output = controlla(i, true);
            System.out.println(output);
            if (!output) {
                output = controlla(i, false);
                System.out.println(output);
            }
        }
        return output;
    }

    public boolean controlla(int index, boolean rigaMode) {
        char[] simboli = new char[N];
        if (rigaMode) {
            for (int j = 0; j < N; j++) {
                Node temp = standardGetElementAt(j, index);
                if (temp instanceof Rett) {
                    simboli[j] = ((Rett) temp).mode;
                }
            }
        } else {
            for (int j = 0; j < N; j++) {
                Node temp = standardGetElementAt(index, j);
                if (temp instanceof Rett) {
                    simboli[j] = ((Rett) temp).mode;
                }
            }
        }

        char pivot = simboli[0];
        if (pivot == 'c') {
            return false;
        }
        for (int i = 0; i < N - 1; i++) {
            if (simboli[i] != simboli[i + 1]) {
                return false;
            }
        }
        System.out.println(simboli);
        return true;
    }

    public void vittoria() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "HAI VINTO!", ButtonType.OK);
        alert.showAndWait();
    }

    public void sconfitta() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Hai perso, ritenta...", ButtonType.OK);
        alert.showAndWait();
    }

    public void resetAll() {
        for (Node a : getChildren()) {
            if (a instanceof Rett) {
                ((Rett) a).reset();
            }
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

    public Node standardGetElementAt(int i, int j) {
        Node res = null;
        for (Node x : getChildren()) {
            if (GridPane.getRowIndex(x) == i && GridPane.getColumnIndex(x) == j) {
                res = x;
                break;
            }
        }
        return res;
    }

}
