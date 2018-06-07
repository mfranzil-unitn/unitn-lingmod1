package luca_201406;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucamartinelli
 */
public class Algoritmi extends HBox {
    
    ToggleButton alg1,alg2,alg3;
    static int alg=1;
    
    Algoritmi(){
        alg1 = new ToggleButton("Alg1");
        alg2 = new ToggleButton("Alg2");
        alg3 = new ToggleButton("Alg3");
        
        alg1.setSelected(true);
        
        this.getChildren().addAll(alg1,alg2,alg3);
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        
        alg1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
            alg1.setSelected(true);
            alg2.setSelected(false);
            alg3.setSelected(false);
            if (alg1.isSelected()) alg = 1;
            }
        });
        alg2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
            alg1.setSelected(false);
            alg2.setSelected(true);
            alg3.setSelected(false);
            if (alg2.isSelected()) alg = 2;
            }
        });
        alg3.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
            alg1.setSelected(false);
            alg2.setSelected(false);
            alg3.setSelected(true);
            if (alg3.isSelected()) alg = 3;
            }
        });

    }
}
