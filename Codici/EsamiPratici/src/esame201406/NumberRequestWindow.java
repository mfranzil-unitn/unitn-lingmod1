/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201406;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Matteo Franzil
 */
public class NumberRequestWindow extends Stage {

    int n;

    public NumberRequestWindow(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.setPadding(new Insets(5,5,5,5));
        TextField field = new TextField("Inserisci qui un valore di N...");

        field.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            try {
                n = Integer.parseInt(field.getText());
                Griglia.N = n;
            } catch (NumberFormatException ex) {
                n = 20;
                System.out.println("Wrong number!");
            }
            this.close();
            primaryStage.show();
        });
        pane.getChildren().addAll(field);
        Scene scene = new Scene(pane);
        setScene(scene);
    }
}
