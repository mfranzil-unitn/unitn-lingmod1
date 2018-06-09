package luca_201406;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucamartinelli
 */
public class Bottoni extends HBox {

    Timeline t;
    Button print, clear, step, start, stop;
    Stage thirdstage;
    Text output;
    StackPane panetext;
    Scene outscena;
    int save[][];

    Bottoni(int dimensione, Cella celle[][]) {

        t = new Timeline();
        clear = new Button("Clear");
        print = new Button("Print");
        step = new Button("Step");
        start = new Button("Start");
        stop = new Button("Stop");

        this.getChildren().addAll(clear, print, step, start, stop);
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);

        print.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                thirdstage = new Stage();
                panetext = new StackPane();
                output = new Text("");

                for (int i = 0; i < dimensione; i++) {
                    for (int j = 0; j < dimensione; j++) {
                        if (celle[i][j].c.isVisible() == true) {
                            output.setText(output.getText() + " 1 ");
                        } else {
                            output.setText(output.getText() + " 0 ");
                        }
                    }
                    output.setText(output.getText() + "\n");
                }

                panetext.getChildren().add(output);
                outscena = new Scene(panetext);

                thirdstage.setTitle("Print");
                thirdstage.setScene(outscena);
                thirdstage.show();
            }
        });

        clear.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                cancella(dimensione, celle);
            }
        });

        step.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                movimento(celle, dimensione, Algoritmi.alg);
            }
        });

        start.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                animazione(celle, dimensione, Algoritmi.alg);

            }
        });

        stop.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                t.stop();
            }
        });

    }

    public void cancella(int dimensione, Cella celle[][]) {
        for (int i = 0; i < dimensione; i++) {
            for (int j = 0; j < dimensione; j++) {
                if (celle[i][j].c.isVisible() == true) {
                    celle[i][j].c.setVisible(false);
                }
            }
        }
    }

    public void movimento(Cella celle[][], int dimensione, int alg) {
        save = new int[dimensione][dimensione];
        for (int i = 0; i < dimensione; i++) {
            for (int j = 0; j < dimensione; j++) {
                if (celle[i][j].c.isVisible() == true) {
                    save[i][j] = 1;
                } else {
                    save[i][j] = 0;
                }
            }
        }
        cancella(dimensione, celle);
        switch (alg) {
            case 1:
                azione1(celle, dimensione);
                break;
            case 2:
                azione2(celle, dimensione);
                break;
            case 3:
                azione3(celle, dimensione);
                break;
        }
    }

    public void azione1(Cella celle[][], int dimensione) {
        for (int i = 0; i < dimensione; i++) {
            for (int j = 0; j < dimensione; j++) {
                if (save[i][j] == 1) {
                    if (j == dimensione - 1 && i == 0) {
                        celle[dimensione - 1][0].c.setVisible(true);
                    } else if (j != dimensione - 1 && i == 0) {
                        celle[dimensione - 1][j + 1].c.setVisible(true);
                    } else if (j == dimensione - 1 && i != 0) {
                        celle[i - 1][0].c.setVisible(true);
                    } else {
                        celle[i - 1][j + 1].c.setVisible(true);
                    }
                }
            }
        }
    }

    public void azione2(Cella celle[][], int dimensione) {
        for (int i = 0; i < dimensione; i++) {
            for (int j = 0; j < dimensione; j++) {
                if (save[i][j] == 1) {
                    if (j == 0) {
                        celle[i][dimensione - 1].c.setVisible(true);
                    } else {
                        celle[i][j - 1].c.setVisible(true);
                    }
                }
            }
        }
    }

    public void azione3(Cella celle[][], int dimensione) {
        for (int i = 0; i < dimensione; i++) {
            for (int j = 0; j < dimensione; j++) {
                if (save[i][j] == 1) {
                    if (i == dimensione - 1) {
                        celle[0][j].c.setVisible(true);
                    } else {
                        celle[i + 1][j].c.setVisible(true);
                    }
                }
            }
        }
    }

    public void animazione(Cella celle[][], int dimensione, int alg) {
        t.setCycleCount(-1);
        KeyFrame c = new KeyFrame(Duration.seconds(1), new EventHandler() {
            @Override
            public void handle(Event event) {
                movimento(celle, dimensione, Algoritmi.alg);
            }
        });
        t.getKeyFrames().add(c);
        t.play();
    }
}
