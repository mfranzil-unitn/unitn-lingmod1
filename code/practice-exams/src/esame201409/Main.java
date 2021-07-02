/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201409;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Matteo Franzil
 */
public class Main extends Application {

    Pannello panel;
    SpinBar roulette;
    Text titolo;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        titolo = new Text("SUPER SLOT");
        titolo.setFont(new Font(28));
        panel = new Pannello(this);
        roulette = new SpinBar(panel, this);

        panel.spin.setOnAction((ActionEvent e) -> {
            roulette.spin(true, panel);
        });

        VBox monete = new VBox();
        monete.getChildren().addAll(new Moneta(panel), new Moneta(panel), new Moneta(panel));

        root.setTop(titolo);
        root.setCenter(roulette);
        root.setRight(monete);
        root.setBottom(panel);

        BorderPane.setAlignment(titolo, Pos.CENTER);
        BorderPane.setAlignment(roulette, Pos.CENTER);
        BorderPane.setAlignment(monete, Pos.CENTER);
        BorderPane.setAlignment(panel, Pos.CENTER);

        Scene scene = new Scene(root, 500, 500);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void reset() {
        roulette.clear();
    }

}
