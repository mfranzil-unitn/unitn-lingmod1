/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luca_esame201606;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author lucamartinelli
 */
public class Common extends Application {

    static int auto = 3;
    HBox ogg;
    BorderPane root;
    Terreno celle[][] = new Terreno[8][8];
    Stage primaryStage;
    Griglia grid;
    Controlli controlli;
    TextField auto_disp;
    Button add_auto, inizia;
    Boolean aggiungibile = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage = new Stage();
        grid = new Griglia(celle);
        auto_disp = new TextField("Auto Disponibili: " + auto);
        add_auto = new Button("Aggiungi Auto");
        add_auto.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                aggiungibile = true;
            }
        });
        inizia = new Button("Inzia");
        inizia.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (auto == 0) {
                    controlli = new Controlli(celle, grid);
                }

            }
        });

        primaryStage.addEventFilter(MouseEvent.ANY, new EventHandler() {
            @Override
            public void handle(Event event) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        celle[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                int x = ((Terreno) event.getSource()).posi;
                                int y = ((Terreno) event.getSource()).posj;

                                if (event.getSource() instanceof Strada) {
                                    if (celle[x][y].circ == false && aggiungibile) {
                                        celle[x][y].circ = true;
                                        celle[x][y].c.setVisible(celle[x][y].circ);
                                        auto--;
                                        auto_disp.setText("Auto Disponibili: " + auto);
                                        if (auto == 0) {
                                            add_auto.setDisable(true);
                                        }
                                    } else {
                                        if (celle[x][y].circ == false) {
                                            grid.getChildren().remove(celle[x][y]);
                                            celle[x][y] = new Prato(x, y);
                                            grid.add(celle[x][y], y, x);
                                        }
                                    }
                                } else {
                                    grid.getChildren().remove(celle[x][y]);
                                    celle[x][y] = new Strada(x, y);
                                    grid.add(celle[x][y], y, x);
                                }
                                aggiungibile = false;
                            }
                        });
                    }
                }
            }
        });

        root = new BorderPane();
        ogg = new HBox();
        ogg.getChildren().addAll(add_auto, auto_disp, inizia);
        ogg.setAlignment(Pos.CENTER);

        root.setBottom(ogg);
        root.setTop(grid);

        Scene scene = new Scene(root);

        primaryStage.setTitle("Parking");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
