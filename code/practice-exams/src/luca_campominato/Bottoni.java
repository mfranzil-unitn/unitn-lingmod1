/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luca_campominato;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static javafx.application.Application.STYLESHEET_CASPIAN;

/**
 * @author lucamartinelli
 */
public class Bottoni extends HBox {

    Text bomb;

    Bottoni() {

        bomb = new Text("Mine: " + Griglia.conta);
        bomb.setFont(Font.font(STYLESHEET_CASPIAN, 50));
        this.getChildren().add(bomb);
        this.setSpacing(100);
        this.setAlignment(Pos.CENTER);

    }

}
