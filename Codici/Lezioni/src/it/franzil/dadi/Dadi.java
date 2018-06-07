/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.franzil.dadi;

import java.util.LinkedList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Matteo Franzil
 */
public class Dadi extends Application {

    boolean isMoveMode;
    LinkedList<Dado> dadi;
    Integer counter;
    Text contatore;

    @Override
    public void start(Stage primaryStage) {
        isMoveMode = true;
        counter = 10;
        dadi = new LinkedList<>();
        Campo campo = new Campo(dadi, this);
        Scene scene = new Scene(campo, 700, 700);
        GridPane root = new GridPane();
        contatore = new Text("Contatore: " + counter);

        Button moveBtn = new Button("Spostamento");
        Button reset = new Button("Reset");
        Button stampa = new Button("Stampa");
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            if (counter == 0) {
                Stage loseWindow = new Stage();
                StackPane losePane = new StackPane();
                Scene printScene = new Scene(losePane, 150, 150);
                Text loss = new Text("Hai perso!");
                losePane.getChildren().add(loss);
                loseWindow.setScene(printScene);
                loseWindow.setTitle("Hai perso!");
                loseWindow.setOnCloseRequest((WindowEvent f) -> {
                    Platform.exit();
                });
                loseWindow.show();
            } else if (campo.checkVictory(dadi)) {
                Stage winWindow = new Stage();
                StackPane winPane = new StackPane();
                Scene printScene = new Scene(winPane, 150, 150);
                Text victory = new Text("Hai vinto!");
                winPane.getChildren().add(victory);
                winWindow.setScene(printScene);
                winWindow.setTitle("Hai vinto!");
                winWindow.setOnCloseRequest((WindowEvent f) -> {
                    Platform.exit();
                });
                winWindow.show();
            }
        });

        reset.setOnAction((ActionEvent event) -> {
            event.consume();
            dadi.clear();
            this.counter = 10;
            contatore.setText("Contatore: " + counter);
            if (moveBtn.getText().equals("Spostamento")) {
                campo.moveDadi();
            } else if (moveBtn.getText().equals("Dissolvimento")) {
                campo.dissolveDadi();
            }
            campo.reset(root);
        });

        GridPane.setColumnIndex(moveBtn, 0);
        GridPane.setRowIndex(moveBtn, 0);
        GridPane.setColumnIndex(reset, 0);
        GridPane.setRowIndex(reset, 1);
        GridPane.setColumnIndex(stampa, 0);
        GridPane.setRowIndex(stampa, 2);
        GridPane.setColumnIndex(contatore, 0);
        GridPane.setRowIndex(contatore, 3);

        moveBtn.setOnAction((ActionEvent event) -> {
            isMoveMode = !isMoveMode;
            if (isMoveMode) {
                moveBtn.setText("Spostamento");
            } else {
                moveBtn.setText("Dissolvimento");
            }
        });

        stampa.setOnAction((ActionEvent event) -> {
            Stage printWindow = new Stage();
            StackPane printPane = new StackPane();
            Scene printScene = new Scene(printPane, 300, 300);
            TextArea txt = new TextArea();
            print(dadi, txt);
            printPane.getChildren().add(txt);
            printWindow.setScene(printScene);
            printWindow.setTitle("Dati:");
            printWindow.show();
        });

        root.setPadding(new Insets(12, 15, 12, 15));
        root.setHgap(10);
        root.setVgap(10);
        root.getChildren().addAll(moveBtn, reset, stampa, contatore);

        campo.getChildren().add(root);

        primaryStage.setTitle("DadoLand");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void print(LinkedList<Dado> dadi, TextArea txt) {
        int sum = 0, counter = 0;
        for (Dado a : dadi) {
            txt.appendText("Dado " + counter + " con valore " + a.value + "\n");
            sum += a.value;
            counter++;
        }
        txt.appendText("Somma: " + sum + "\n");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
