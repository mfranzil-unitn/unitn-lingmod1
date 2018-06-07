/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luca_201606;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

/**
 *
 * @author lucamartinelli
 */
public class Griglia extends GridPane {
    
    Griglia(Terreno celle[][]) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0 || i == 7) {
                    celle[i][j] = new Strada(i,j);
                } else if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6) {
                    if (j == 0 || j == 7) {
                        celle[i][j] = new Strada(i,j);
                    } else {
                        celle[i][j] = new Prato(i,j);
                    }
                }
            this.add(celle[i][j], j, i);
            }
        }
        this.setAlignment(Pos.CENTER);
    }
}
        
