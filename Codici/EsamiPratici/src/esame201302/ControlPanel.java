/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201302;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author Matteo Franzil
 */
public class ControlPanel extends VBox {

    Button up, down, start, stop, reset;
    TextField figura;

    Thread corsa;

    public ControlPanel(Pannello pannello) {
        setPadding(new Insets(12, 15, 12, 15));
        up = new Button("Up");
        down = new Button("Down");
        start = new Button("Start");
        stop = new Button("Stop");
        reset = new Button("Reset");

        down.setOnAction((ActionEvent e) -> {
            pannello.moveFigura(figura.getText(), 10);
        });

        up.setOnAction((ActionEvent e) -> {
            pannello.moveOthers(figura.getText(), -10);
        });

        reset.setOnAction((ActionEvent e) -> {
            pannello.reset();
            down.setDisable(false);
            up.setDisable(false);
            start.setDisable(false);
            stop.setDisable(false);
        });

        start.setOnAction((ActionEvent e) -> {
            pannello.start();
            stop.setDisable(false);
            start.setDisable(true);
        });

        stop.setOnAction((ActionEvent e) -> {
            pannello.stop(corsa);
            stop.setDisable(true);
            start.setDisable(false);
        });

        figura = new TextField();
        figura.setPrefSize(50, USE_PREF_SIZE);
        figura.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.equals("C") && !newValue.equals("Q") && !newValue.equals("T")) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Valore non valido!", new ButtonType("Ok"));
                alert.showAndWait();
                figura.clear();
            }
        });

        getChildren().addAll(up, down, start, stop, reset, figura);
    }

}
