/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201406;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Matteo Franzil
 */
public class NumberRequestWindow extends Stage {

    int n;

    public NumberRequestWindow(Stage primaryStage) {
        VBox pane = new VBox();
        Text text = new Text("N?");
        TextField field = new TextField();

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
        pane.getChildren().addAll(text, field);
        Scene scene = new Scene(pane, 200, 200);
        setScene(scene);
    }
}
