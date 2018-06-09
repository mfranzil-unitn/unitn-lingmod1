package luca_201406;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucamartinelli
 */
public class Pop {

    Stage primarystage;
    TextField textdimensione;
    Text titolo;
    BorderPane layout;
    Button conferma;

    Pop() {
        primarystage = new Stage();
        textdimensione = new TextField();
        titolo = new Text("Dimensione");
        layout = new BorderPane();
        conferma = new Button("Conferma");

        layout.setTop(titolo);
        layout.setBottom(conferma);
        layout.setCenter(textdimensione);

        BorderPane.setAlignment(titolo, Pos.TOP_CENTER);
        BorderPane.setAlignment(conferma, Pos.BOTTOM_CENTER);
        BorderPane.setAlignment(textdimensione, Pos.CENTER);

        Scene scene = new Scene(layout, 200, 100);

        primarystage.setTitle("Inserisci Dimensione");
        primarystage.setScene(scene);
        primarystage.show();

    }

}
