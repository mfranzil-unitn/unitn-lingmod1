/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201302;

import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Random;

/**
 * @author Matteo Franzil
 */
public class Pannello extends Pane {

    Rectangle quadrato;
    Circle cerchio;
    Triangle triangolo;

    public Pannello() {
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        setPrefHeight(400);
        setPrefWidth(400);
        quadrato = new Rectangle(50, 0, Main.SIZE, Main.SIZE);
        cerchio = new Circle(150, Main.SIZE / 2, Main.SIZE / 2);
        triangolo = new Triangle(200, 0, Main.SIZE);

        quadrato.setFill(Color.GREEN);
        cerchio.setFill(Color.RED);

        getChildren().addAll(quadrato, cerchio, triangolo);

    }

    public boolean moveFigura(String nome, double offset) {
        Node node;
        boolean res = false;
        switch (nome) {
            case "C":
                node = cerchio;
                break;
            case "Q":
                node = quadrato;
                break;
            case "T":
                node = triangolo;
                break;
            default:
                node = null;
                break;
        }

        try {
            node.setTranslateY(node.getTranslateY() + offset);
            if (node.getTranslateY() > getHeight()) {
                victory(node);
                res = true;
            }
        } catch (NullPointerException e) {
            System.out.println("Wrong shape!");
        }
        return res;
    }

    public void victory(Node node) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Vince IL " + node.getClass(), ButtonType.OK);
        alert.showAndWait();
    }

    public void moveOthers(String nome, double offset) {
        switch (nome) {
            case "C":
                moveFigura("Q", offset);
                moveFigura("T", offset);
                break;
            case "Q":
                moveFigura("C", offset);
                moveFigura("T", offset);
                break;
            case "T":
                moveFigura("Q", offset);
                moveFigura("C", offset);
                break;
            default:
                break;
        }

    }

    public void reset() {
        cerchio.setTranslateY(0);
        triangolo.setTranslateY(0);
        quadrato.setTranslateY(0);
    }

    public TranslateTransition start() {
        /*Task<Integer> task = new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                while (true) {
                    moveFigura("Q", new Random().nextInt(10) + 1);
                    moveFigura("C", new Random().nextInt(10) + 1);
                    moveFigura("T", new Random().nextInt(10) + 1);
                    Thread.sleep(1000);
                }
            }
        };
        Thread thread = new Thread(task);
        thread.start();
        return thread;*/
        TranslateTransition tt = new TranslateTransition(Duration.INDEFINITE, triangolo);
        tt.setByY(new Random().nextInt(10) + 1);
        tt.setByX(0);
        tt.play();
        return tt;
    }

    public void stop(Thread thread) {
        thread.interrupt();
    }
}
