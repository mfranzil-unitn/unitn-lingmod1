/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame_pressanumeri;

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
public class PressaNumeri extends Application {
    
    ArrayList<Button> bottoni;
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane root = new GridPane();
        root.setPrefHeight(100);
        root.setPrefWidth(100);
        bottoni = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(33);
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(33);
            for (int i = 0; i < 3; i++) {                
                Button temp = new Button(String.valueOf(3 * j + i));
                temp.setPrefHeight(1000);
                temp.setPrefWidth(1000);
                GridPane.setConstraints(temp, i, j);
                bottoni.add(temp);
                root.getChildren().add(temp);
            }
        }
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
            if (event.getCode().isDigitKey() && !event.getCode().getName().equals("9")) {
                Button temp = bottoni.get(Integer.parseInt(event.getCode().getName()));
                temp.setVisible(!temp.isVisible());
            }
        }
    }
}
