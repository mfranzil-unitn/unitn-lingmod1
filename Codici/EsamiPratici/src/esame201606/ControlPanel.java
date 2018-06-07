/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201606;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Matteo Franzil
 */
public class ControlPanel {

    Button destra, sinistra, su, giu, random, start, stop;
    Thread thr;

    public ControlPanel(Griglia griglia) {
        destra = new Button("Destra");
        sinistra = new Button("Sinistra");
        su = new Button("Su");
        giu = new Button("Giu");
        random = new Button("Random");
        start = new Button("Start");
        stop = new Button("Stop");
        stop.setDisable(true);

        destra.setOnAction((ActionEvent e) -> {
            griglia.moveAllCars("Destra");
        });

        su.setOnAction((ActionEvent e) -> {
            griglia.moveAllCars("Su");
        });

        giu.setOnAction((ActionEvent e) -> {
            griglia.moveAllCars("Giu");
        });

        sinistra.setOnAction((ActionEvent e) -> {
            griglia.moveAllCars("Sinistra");
        });

        random.setOnAction((ActionEvent e) -> {
            griglia.randomSingleMovement();
        });

        start.setOnAction((ActionEvent e) -> {
            griglia.startAutoMovement();
            start.setDisable(true);
            stop.setDisable(false);
        });

        stop.setOnAction((ActionEvent e) -> {
            griglia.stopThread();
            start.setDisable(false);
            stop.setDisable(true);
        });

        FlowPane root = new FlowPane();

        root.getChildren().addAll(destra, sinistra, su, giu, random, start, stop);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setOnCloseRequest((WindowEvent e) -> {
            e.consume();
        });
        stage.show();
    }

}
