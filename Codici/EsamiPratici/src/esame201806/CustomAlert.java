/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201806;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Classe che rappresenta un Popup che viene mostrato in caso di errore.
 *
 * @author Matteo Franzil - 192198
 */
public class CustomAlert extends Stage {

    /**
     * Costruisce un nuovo CustomAlert che viene inizializzato con un messaggio.
     *
     * @param message Il messaggio da mostrare nel popup.
     */
    public CustomAlert(String message) {
        StackPane root = new StackPane();
        Text text = new Text(message);
        root.getChildren().add(text);

        Scene scene = new Scene(root, message.length() * 9, 40);

        setTitle("Errore!");
        setResizable(false);
        setScene(scene);
    }

    @Override
    public void showAndWait() {
        Platform.runLater(() -> {
            super.showAndWait();
        });
    }

}
