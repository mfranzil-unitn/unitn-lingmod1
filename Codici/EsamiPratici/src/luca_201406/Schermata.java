package luca_201406;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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
class Schermata extends BorderPane {

    Stage secondstage;
    static Algoritmi al;
    Bottoni btn;
    Griglia grid;
    Cella celle[][];

    Schermata(int dimensione) {
        celle = new Cella[dimensione][dimensione];
        btn = new Bottoni(dimensione, celle);
        al = new Algoritmi();
        grid = new Griglia(dimensione, celle);
        secondstage = new Stage();

        this.setBottom(btn);
        this.setTop(al);
        this.setCenter(grid);

        Scene scene = new Scene(this);

        secondstage.setTitle("Live!");
        secondstage.setScene(scene);
        secondstage.show();
    }

}
