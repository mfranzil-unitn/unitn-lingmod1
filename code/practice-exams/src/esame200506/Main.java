/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame200506;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

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

        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        column1.setPercentWidth(70);
        column2.setPercentWidth(30);
        column1.setHgrow(Priority.ALWAYS);
        root.getColumnConstraints().addAll(column1, column2);

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(100);
        root.getRowConstraints().add(row1);

        GraphicPanel graphic = new GraphicPanel();
        ControlPanel control = new ControlPanel(graphic);

        GridPane.setConstraints(graphic, 0, 0);
        GridPane.setConstraints(control, 1, 0);
        root.getChildren().addAll(graphic, control);

        Scene scene = new Scene(root, 250, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
