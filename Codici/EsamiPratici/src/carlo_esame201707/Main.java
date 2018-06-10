package carlo_esame201707;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Main Class
 *
 * @author Carlo Corradini
 */
public class Main extends Application {

    private boolean isDissolve = true;

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        // Bottom
        Label lblContatore = new Label();
        // Center
        Campo campo = new Campo(500, lblContatore);
        // Top
        GridPane top = new GridPane();
        Button btnReset = new Button("RESET");
        btnReset.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            campo.reset(isDissolve);
        });
        Button btnStampa = new Button("STAMPA");
        btnStampa.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            campo.printDadi();
        });
        Button btnEffect = new Button("Dissolvimento");
        btnEffect.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            isDissolve = !isDissolve;
            if (isDissolve) {
                btnEffect.setText("Dissolvimento");
            } else {
                btnEffect.setText("Spostamento");
            }
        });
        top.setHgap(10);
        top.setVgap(10);
        top.add(btnReset, 0, 0);
        top.add(btnStampa, 1, 0);
        top.add(btnEffect, 3, 0);

        // Set Graphics
        root.setTop(top);
        root.setCenter(campo);
        root.setBottom(lblContatore);
        Scene scene = new Scene(root);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            if (event.getCode() == KeyCode.S) {
                campo.printDadi();
            } else if (event.getCode() == KeyCode.R) {
                campo.reset(isDissolve);
            }
        });
        stage.setScene(scene);
        stage.setTitle("DADI");
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
