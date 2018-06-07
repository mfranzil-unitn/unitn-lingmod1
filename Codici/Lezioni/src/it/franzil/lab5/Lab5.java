/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.franzil.lab5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author nicolo.gottardello
 */
public class Lab5 extends Application {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;

    Boolean continua, isClicked, figura;
    Segmento sg;
    double x_fig, y_fig;

    @Override
    public void start(Stage primaryStage) {

        isClicked = false;
        continua = false;
        figura = false;

        Pane root = new Pane();
        root.setBackground(new Background(new BackgroundFill(Color.CORNSILK, CornerRadii.EMPTY, Insets.EMPTY)));

        Canvas tela = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gC = tela.getGraphicsContext2D();
        gC.setStroke(Color.SKYBLUE);
        gC.setLineWidth(4);

        tela.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            if (!continua && !figura) {
                if (!isClicked) {
                    sg = new Segmento(e.getX(), e.getY());
                    isClicked = true;
                } else {
                    x_fig = e.getX();
                    y_fig = e.getY();    
                    sg.setFinale(e.getX(), e.getY());
                    sg.disegna(gC);
                    isClicked = false;
                }
            } else if (continua && !figura) {
                if (!isClicked) {
                    sg = new Segmento(e.getX(), e.getY());
                    isClicked = true;

                } else {
                    sg.setFinale(e.getX(), e.getY());
                    sg.disegna(gC);
                    sg = new Segmento(e.getX(), e.getY());

                }
            } else if (figura && !continua) {
                if (!isClicked) {
                    sg = new Segmento(e.getX(), e.getY());
                    isClicked = true;
                    x_fig = e.getX();
                    y_fig = e.getY();

                } else {
                    sg.setFinale(e.getX(), e.getY());
                    sg.disegna(gC);
                    sg = new Segmento(e.getX(), e.getY());

                }
            }
        }
        );

        Button clc = new Button();
        clc.setText("Cancella");
        clc.setOnAction((ActionEvent event) -> {
            gC.clearRect(0, 0, tela.getWidth(), tela.getHeight());
        });

        ToggleButton fig = new ToggleButton();
        ToggleButton cnt = new ToggleButton();

        fig.setLayoutY(50);
        fig.setText("Figura");
        fig.setOnAction((ActionEvent event) -> {
            if (!figura) {
                figura = true;
                continua = false;
                isClicked = false;
                cnt.setSelected(false);
            } else {
                figura = false;
                isClicked = false;
                sg.setFinale(x_fig, y_fig);
                sg.disegna(gC);
            }
        });

        cnt.setLayoutY(25);
        cnt.setText("Linea Continua");
        cnt.setOnAction((ActionEvent event) -> {
            if (continua) {
                continua = false;
                isClicked = false;
            } else {
                continua = true;
                figura = false;
                fig.setSelected(false);
                sg.setFinale(x_fig, y_fig);
                sg.disegna(gC);
                isClicked = false;
                
            }
        });
        
        ColorPicker color = new ColorPicker((Color)gC.getStroke());
        color.setLayoutY(75);
        color.setOnAction((ActionEvent event) -> {
           //root.setBackground(new Background(new BackgroundFill(color.getValue(), CornerRadii.EMPTY, Insets.EMPTY)));
           gC.setStroke(color.getValue());
        });
        

        root.getChildren().addAll(tela, cnt, clc, fig, color);

        Scene scene = new Scene(root, WIDTH, HEIGHT);

        primaryStage.setTitle("Paint <3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
