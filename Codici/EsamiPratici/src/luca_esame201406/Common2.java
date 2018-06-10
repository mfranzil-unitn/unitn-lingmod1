package luca_esame201406;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 *
 * @author lucamartinelli
 */
public class Common2 extends Application {

    Pop a;
    Schermata b;
    static int dimensione;

    @Override
    public void start(Stage primaryStage) {
        a = new Pop();

        a.conferma.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    dimensione = Integer.parseInt(a.textdimensione.getText());
                    b = new Schermata(dimensione);
                    a.primarystage.close();
                } catch (Exception e) {
                    System.out.println("Errore: valore passato non è un numero");
                }

            }
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
