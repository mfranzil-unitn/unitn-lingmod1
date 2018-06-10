/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esamepressanumeri;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 *
 * @author Matteo Franzil
 */
public class SpostaNumeri extends Application {

    BottoneMovimentato[][] buttons;

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setPrefHeight(100);
        root.setPrefWidth(100);

        buttons = new BottoneMovimentato[3][3];

        for (int j = 0; j < 3; j++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(33);
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(33);
            for (int i = 0; i < 3 && (3 * j + i < 8); i++) {
                BottoneMovimentato temp = new BottoneMovimentato(i, j);
                GridPane.setConstraints(temp, i, j);
                buttons[i][j] = temp;
                root.getChildren().add(temp);
            }
        }
        BottoneMovimentato vuoto = new BottoneMovimentato(2, 2);
        GridPane.setConstraints(vuoto, 2, 2);
        buttons[2][2] = vuoto;
        vuoto.setVisible(false);
        root.getChildren().add(vuoto);

        primaryStage.addEventFilter(KeyEvent.KEY_PRESSED, new Handler());

        Scene scene = new Scene(root);

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

    class Handler implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent event) {

        }
    }

    public BottoneMovimentato getNearby(int i, int j) {
        BottoneMovimentato temp = null;
        while (!temp.getText().equals(8)) {
            temp = buttons[i - 1][j - 1];
        }
        return null;
    }
}
