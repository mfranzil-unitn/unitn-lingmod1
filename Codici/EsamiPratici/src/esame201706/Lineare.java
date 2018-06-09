/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201706;

import java.util.LinkedList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Matteo Franzil
 */
public class Lineare extends Application {

    public final static int DIM = 25;
    public final static int SIZE = 25;

    public static int lastPressedButton = -1;

    @Override
    public void start(Stage primaryStage) {

        Button rnd = new Button("Random"), allOn = new Button("All on"), allOff = new Button("All off");
        LinkedList<Button> modifiers = new LinkedList<>();
        Button linear = new Button("Linear"), sin = new Button("Sin"), cos = new Button("Cos"), sqrt = new Button("Sqrt");
        modifiers.add(linear);
        modifiers.add(sin);
        modifiers.add(cos);
        modifiers.add(sqrt);

        GridPane root = new GridPane();
        BigGrid bigGrid = new BigGrid();
        LinearGrid linearGrid = new LinearGrid(bigGrid, modifiers);

        rnd.setOnAction((ActionEvent event) -> {
            linearGrid.linearGridSwitcher(1, bigGrid, modifiers);
        });

        allOn.setOnAction((ActionEvent event) -> {
            linearGrid.linearGridSwitcher(2, bigGrid, modifiers);
        });

        allOff.setOnAction((ActionEvent event) -> {
            linearGrid.linearGridSwitcher(3, bigGrid, modifiers);
        });

        linear.setOnAction((ActionEvent event) -> {
            bigGrid.setLinearBigGrid(linearGrid);
            lastPressedButton = 0;
        });

        sin.setOnAction((ActionEvent event) -> {
            bigGrid.setSin(linearGrid, 3.0);
            lastPressedButton = 1;

        });

        cos.setOnAction((ActionEvent event) -> {
            bigGrid.setCos(linearGrid, 3.0);
            lastPressedButton = 2;

        });

        sqrt.setOnAction((ActionEvent event) -> {
            bigGrid.setSqrt(linearGrid);
            lastPressedButton = 3;

        });
        // bottoni...
        GridPane.setConstraints(bigGrid, 0, 0, DIM, DIM);
        GridPane.setConstraints(linearGrid, 0, DIM + 1, DIM, 1);
        GridPane.setConstraints(rnd, 0, DIM + 3, 1, 1);
        GridPane.setConstraints(allOn, 1, DIM + 3, 1, 1);
        GridPane.setConstraints(allOff, 2, DIM + 3, 1, 1);
        GridPane.setConstraints(linear, 3, DIM + 3, 1, 1);
        GridPane.setConstraints(sin, 4, DIM + 3, 1, 1);
        GridPane.setConstraints(cos, 5, DIM + 3, 1, 1);
        GridPane.setConstraints(sqrt, 6, DIM + 3, 1, 1);

        root.setHgap(10);
        root.setVgap(10);

        root.setPadding(new Insets(30, 30, 30, 30));
        root.getChildren().addAll(bigGrid, linearGrid, rnd, allOn, allOff, linear, sin, cos, sqrt);

        primaryStage.setOnCloseRequest((WindowEvent e) -> {
            Platform.exit();
        });
        Scene scene = new Scene(root, bigGrid.getMinWidth(), bigGrid.getMinHeight());

        primaryStage.setTitle("Hello World!");
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
