package luca_esame201406;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
public class Comandi {

    static int X = 300;
    static int Y = 300;

    Stage primarystage;
    ColorPicker colorpane, c1, c2;
    VBox root, color, butt;
    Button clearall, clearfirst, clearlast, print;
    TextField scale;

    Comandi() {

        primarystage = new Stage();

        colorpane = new ColorPicker();
        c1 = new ColorPicker(Color.RED);
        c2 = new ColorPicker(Color.GREEN);
        color = new VBox();
        color.getChildren().addAll(colorpane, c1, c2);
        color.setSpacing(5);
        color.setAlignment(Pos.CENTER);

        clearall = new Button("Clear-All");
        clearfirst = new Button("Clear-First");
        clearlast = new Button("Clear-Last");
        print = new Button("Print");
        butt = new VBox();
        butt.getChildren().addAll(clearall, clearfirst, clearlast, print);
        butt.setSpacing(5);
        butt.setAlignment(Pos.CENTER);

        scale = new TextField();
        scale.setText("20");

        root = new VBox();
        root.getChildren().addAll(color, butt, scale);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        Scene scena = new Scene(root, X, X);

        primarystage.setTitle("Comandi");
        primarystage.setScene(scena);
        primarystage.show();
        primarystage.setX(100);
    }

}
