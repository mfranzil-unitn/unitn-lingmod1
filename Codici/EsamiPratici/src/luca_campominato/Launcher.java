/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luca_campominato;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author lucamartinelli
 */
public class Launcher extends Application {

    CampoMinato a;

    @Override
    public void start(Stage primaryStage) {

        a = new CampoMinato();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
