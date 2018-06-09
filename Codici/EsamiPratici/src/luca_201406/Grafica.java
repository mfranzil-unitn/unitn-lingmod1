package luca_201406;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
public class Grafica {

    static int X = 500;
    static int Y = 500;

    Stage secondstage;
    BorderPane root;
    Rectangle square;
    Scene scena;

    Grafica() {

        secondstage = new Stage();
        square = new Rectangle(X, Y);
        square.setFill(Color.WHITE);
        root = new BorderPane();
        root.getChildren().add(square);
        scena = new Scene(root, X, Y);

        secondstage.setTitle("Grafica");
        secondstage.setScene(scena);
        secondstage.show();

    }
}
