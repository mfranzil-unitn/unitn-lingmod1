package luca_esame201406;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author lucamartinelli
 */
public class Dati {

    Stage stage;
    StackPane root;
    Scene scena;

    Dati(int min, int max, Figura a[]) {
        Text t = new Text("");
        for (int i = min; i < max; i++) {
            switch (i % 3) {
                case 0:
                    t.setText(t.getText() + "Quadrato" + " " + a[i].x + " " + a[i].y + "\n");
                    break;
                case 1:
                    t.setText(t.getText() + "Cerchio" + " " + a[i].x + " " + a[i].y + "\n");
                    break;
                case 2:
                    t.setText(t.getText() + "Rombo" + " " + a[i].x + " " + a[i].y + "\n");
                    break;
            }
        }
        stage = new Stage();
        root = new StackPane();
        root.getChildren().add(t);
        scena = new Scene(root);

        stage.setTitle("Stampa");
        stage.setScene(scena);
        stage.show();
        stage.setX(700);
    }

}
