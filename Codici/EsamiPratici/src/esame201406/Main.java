/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201406;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Matteo Franzil
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Scena di richiesta del numero
        NumberRequestWindow rq = new NumberRequestWindow(primaryStage);
        rq.setOnCloseRequest((WindowEvent e) -> {
            try {
                Griglia.N = rq.n;
                primaryStage.show();
            } catch (NullPointerException ex) {
                Griglia.N = 20;
                System.out.println("No number found");
            }
        });
        rq.showAndWait();

        // Scena effettiva
        VBox root = new VBox();

        Griglia griglia = new Griglia();

        UpperPanel upperpanel = new UpperPanel(griglia);
        LowerPanel lowerpanel = new LowerPanel(griglia);

        root.getChildren().addAll(upperpanel, griglia, lowerpanel);
        Scene scene = new Scene(root);

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent e) -> {
            switch (e.getCode()) {
                case C:
                    lowerpanel.clear.fire();
                    break;
                case S:
                    lowerpanel.step.fire();
                    break;
                default:
                    break;
            }
        });

        primaryStage.setOnCloseRequest((WindowEvent e) -> {
            lowerpanel.killThread();
            Platform.exit();
        });

        primaryStage.setTitle("Palline che si muovono un po' a caso");
        primaryStage.setScene(scene);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
