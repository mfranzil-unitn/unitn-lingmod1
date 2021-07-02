/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201106;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * @author Matteo Franzil
 */
public class ButtonBox extends VBox {

    public ButtonBox(Pannello pannello) {
        Button stampa = new Button("Stampa");
        Button reset = new Button("Reset");
        Button mescola = new Button("Mescola");

        stampa.setOnAction(e -> pannello.stampa());

        reset.setOnAction(e -> pannello.resetAll());

        mescola.setOnAction(e -> pannello.mescola());

        getChildren().addAll(stampa, reset, mescola);
    }

}
