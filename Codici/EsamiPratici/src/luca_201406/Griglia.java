package luca_201406;


import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucamartinelli
 */
public class Griglia extends GridPane{
    
    Griglia(int dimensione, Cella celle[][]){
        for(int i = 0; i < dimensione;i++){
            for(int j = 0; j < dimensione;j++){
                celle[i][j] = new Cella();
                this.add(celle[i][j], j, i);
            }
        }
        this.setAlignment(Pos.CENTER);
        
    }
    
}
