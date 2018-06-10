/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201106;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Matteo Franzil
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pannello pannello = new Pannello();
        VBox buttons = new ButtonBox(pannello);
        GridPane root = new GridPane();

        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        column1.setPercentWidth(80);
        column2.setPercentWidth(20);

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(100);

        GridPane.setConstraints(pannello, 0, 0);
        GridPane.setConstraints(buttons, 1, 0);

        root.getChildren().addAll(pannello, buttons);

        Scene scene = new Scene(root);

        primaryStage.setTitle("Out of fantasia");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        launch(args);
    }

}
