/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame200506;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author Matteo Franzil
 */
public class ControlPanel extends VBox {

    public ControlPanel(GraphicPanel graphic) {
        Label label = new Label("Chi cerca trova");
        Button inizia = new Button("Inizia");
        Button resa = new Button("Mi arrendo");
        TextField d1 = new TextField(String.valueOf(graphic.getD1()));
        TextField d2 = new TextField(String.valueOf(graphic.getD2()));

        d1.setPrefWidth(40);
        d2.setPrefWidth(40);

        inizia.setOnAction((ActionEvent e) -> {
            graphic.defineTarget();
        });

        d1.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            try {
                if (Integer.parseInt(newValue) > Integer.parseInt(d2.getText())) {
                    graphic.setD1(Integer.parseInt(d1.getText()));
                } else {
                    d1.setText(oldValue);
                }
            } catch (NumberFormatException e) {
                d1.setText(oldValue);
            }
        });

        resa.setOnAction((ActionEvent e) -> {
            graphic.drawTarget();
            label.setText("HAI PERSO");
        });

        getChildren().addAll(label, inizia, d1, d2, resa);
    }

}
