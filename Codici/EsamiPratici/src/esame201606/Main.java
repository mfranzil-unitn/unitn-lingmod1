/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201606;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * @author Matteo Franzil
 */
public class Main extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        GridPane root = new GridPane();
        Griglia griglia = new Griglia();
        ToolBar bar = new ToolBar(griglia);

        GridPane.setConstraints(griglia, 0, 0, Griglia.N, Griglia.N);
        GridPane.setConstraints(bar, 0, Griglia.N, 1, Griglia.N);

        root.setMargin(bar, new Insets(20, 20, 20, 20));

        root.getChildren().addAll(griglia, bar);

        Scene scene = new Scene(root);

        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            bar.setAuto();
        });

        primaryStage.setOnCloseRequest((WindowEvent e) -> {
            Platform.exit();

        });
        primaryStage.setTitle("Terreno");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

}
