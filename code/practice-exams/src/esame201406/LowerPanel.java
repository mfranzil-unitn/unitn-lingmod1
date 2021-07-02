/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201406;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.LinkedList;

/**
 * @author Matteo Franzil
 */
public class LowerPanel extends HBox {

    Thread thr;
    Button print, clear, step, start, stop;

    public LowerPanel(Griglia griglia) {
        print = new Button("Print");
        clear = new Button("Clear");
        step = new Button("Step");
        start = new Button("Start");
        stop = new Button("Stop");

        start.setDisable(false);
        stop.setDisable(true);

        print.setOnAction((ActionEvent e) -> {
            print(griglia.getCelle());
        });

        clear.setOnAction((ActionEvent e) -> {
            griglia.clearAll();
        });

        step.setOnAction((ActionEvent e) -> {
            griglia.stepAll();
        });

        start.setOnAction((ActionEvent e) -> {
            thr = griglia.startTransition();
        });

        stop.setOnAction((ActionEvent e) -> {
            killThread();
        });

        getChildren().addAll(print, clear, step, start, stop);
    }

    public void print(LinkedList<Cella> celle) {
        StackPane pane = new StackPane();
        TextArea text = new TextArea();
        text.setEditable(false);
        pane.getChildren().add(text);
        Scene scene = new Scene(pane, 200, 200);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        for (int i = 0; i < celle.size(); i++) { // Lista memorizzata per righe
            text.appendText(celle.get(i).isCircVisible() ? "1" : "0");
            if ((i + 1) % Griglia.N == 0) {
                text.appendText("\n");
            }
        }
    }

    public void killThread() {
        try {
            thr.interrupt();
        } catch (NullPointerException e) {
            System.out.println("No thread to interrupt");
        }
    }

}
