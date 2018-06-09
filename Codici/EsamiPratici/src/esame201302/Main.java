/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201302;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Matteo Franzil
 */
public class Main extends Application {

    public static final int SIZE = 30;

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        Pannello pannello = new Pannello();
        ControlPanel comandi = new ControlPanel(pannello);

        GridPane.setConstraints(pannello, 0, 0, 8, 10);
        GridPane.setConstraints(comandi, 9, 0, 2, 2);

        root.getChildren().addAll(pannello, comandi);

        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Hello World!");
        primaryStage.setOnCloseRequest((WindowEvent e) -> {
            Platform.exit();
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
