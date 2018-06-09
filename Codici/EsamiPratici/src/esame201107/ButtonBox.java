/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201107;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 *
 * @author Matteo Franzil
 */
public class ButtonBox extends VBox {

    public ButtonBox(Pannello pannello) {
        Button stampa = new Button("Stampa");
        Button reset = new Button("Reset");
        Button controlla = new Button("Controlla");
        
        stampa.setOnAction((ActionEvent e) -> {
            pannello.stampa();
        });

        reset.setOnAction((ActionEvent e) -> {
            pannello.resetAll();
        });
        
        controlla.setOnAction((ActionEvent e) -> {
            boolean result = pannello.controlla();
            if (result) {
                pannello.vittoria();
            } else {
                pannello.sconfitta();
            }
        });

        getChildren().addAll(stampa, reset, controlla);
    }

}
