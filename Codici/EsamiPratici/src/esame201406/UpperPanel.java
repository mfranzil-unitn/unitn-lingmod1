/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201406;

import javafx.event.ActionEvent;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

/**
 *
 * @author Matteo Franzil
 */
public class UpperPanel extends HBox {

    public UpperPanel(Griglia griglia) {
        ToggleButton alg1 = new ToggleButton("Alg1");
        ToggleButton alg2 = new ToggleButton("Alg2");
        ToggleButton alg3 = new ToggleButton("Alg3");
        ToggleGroup tgl = new ToggleGroup();
        alg1.setToggleGroup(tgl);
        alg2.setToggleGroup(tgl);
        alg3.setToggleGroup(tgl);
        getChildren().addAll(alg1, alg2, alg3);
        
        alg1.setOnAction((ActionEvent e) -> {
            griglia.setCurrentAlg(1);
        });
        
        alg2.setOnAction((ActionEvent e) -> {
            griglia.setCurrentAlg(2);
        });
        
        alg3.setOnAction((ActionEvent e) -> {
            griglia.setCurrentAlg(3);
        });
    }
}
