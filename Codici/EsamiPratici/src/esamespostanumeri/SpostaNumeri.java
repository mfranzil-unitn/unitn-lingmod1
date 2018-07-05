/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esamespostanumeri;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 * @author Matteo Franzil
 */
public class SpostaNumeri extends Application {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setPrefHeight(100);
        root.setPrefWidth(100);

        for (int j = 0; j < 3; j++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(33);
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(33);
            for (int i = 0; i < 3 && (3 * j + i < 8); i++) {
                BottoneMovimentato temp = new BottoneMovimentato(i, j);
                GridPane.setConstraints(temp, i, j);
                root.getChildren().add(temp);
            }
        }

        BottoneMovimentato vuoto = new BottoneMovimentato(2, 2);
        GridPane.setConstraints(vuoto, 2, 2);
        vuoto.setVisible(false);
        root.getChildren().add(vuoto);

        primaryStage.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            try {
                Button temp = (Button) root.getChildren().get(Integer.parseInt(e.getCode().getName()) - 1);
                Integer i1 = GridPane.getColumnIndex(vuoto);
                Integer j1 = GridPane.getRowIndex(vuoto);
                Integer i2 = GridPane.getColumnIndex(temp);
                Integer j2 = GridPane.getRowIndex(temp);
                System.out.println(i1 + ", " + j1 + " -> " + i2 + ", " + j2);
                if ((i2.equals(i1 - 1) && j2.equals(j1))
                        || (i2.equals(i1 + 1) && j2.equals(j1))
                        || (j2.equals(j1 - 1) && i2.equals(i1))
                        || (j2.equals(j1 + 1) && i2.equals(i1))) {
                    GridPane.setConstraints(vuoto, i2, j2);
                    GridPane.setConstraints(temp, i1, j1);
                }
            } catch (Exception ex) {
                e.consume();
            }
        });

        Scene scene = new Scene(root);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
