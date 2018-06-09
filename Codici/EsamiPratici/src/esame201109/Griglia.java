/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201109;

import static java.awt.SystemColor.info;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Matteo Franzil
 */
public class Griglia extends GridPane {

    public static final int N = 20;
    private boolean speculare, whiteOnly;

    public Griglia(boolean whiteOnly) {
        this.whiteOnly = whiteOnly;
        speculare = false;
        for (int i = 0; i < N; i++) {
            // Riga di strada            
            for (int j = 0; j < N; j++) {
                Cella cella = new Cella(whiteOnly);
                GridPane.setConstraints(cella, j, i, 1, 1);
                getChildren().add(cella);
            }
        }

    }

    public void setSpeculare(boolean speculare) {
        this.speculare = speculare;
    }

    public boolean isSpeculare() {
        return speculare;
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

    public void changeCell(int i, int j) {
        Node temp = standardGetElementAt(i, j);
        if (temp instanceof Cella) {
            ((Cella) temp).forceSwitchBackground();
        }
    }

    public void reset() {
        for (Node a : getChildren()) {
            if (a instanceof Cella && !((Cella) a).isCurrentlyWhite()) {
                ((Cella) a).forceSwitchBackground();
            }
        }
    }

    public void print() {
        StackPane info = new StackPane();
        TextArea area = new TextArea();
        for (Node a : getChildren()) {
            if (a instanceof Cella && !((Cella) a).isCurrentlyWhite()) {
                area.appendText(a + " con coordinate " + GridPane.getRowIndex(a) + ", " + GridPane.getColumnIndex(a) + "\n");
            }
        }
        info.getChildren().add(area);
        Scene scene = new Scene(info);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }
}
