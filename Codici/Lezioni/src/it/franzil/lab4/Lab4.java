/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.franzil.lab4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * @author nicolo.gottardello
 */
public class Lab4 extends Application {

    static boolean isX = true;
    static int destroyCount = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();
        Scene scene = new Scene(root, 1200, 750);

        Group btnRoot = new Group();
        Scene btnScene = new Scene(btnRoot, 400, 50);


        Cerchio crc = new Cerchio();
        crc.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            if (isX) {
                if (crc.getCenterX() <= 0) {
                    crc.setCenterX(scene.getWidth());
                }
                crc.moveX(-10);
            } else {
                if (crc.getCenterY() <= 0) {
                    crc.setCenterY(scene.getHeight());
                }
                crc.moveY(-10);
            }
        });

        crc.addEventHandler(MouseEvent.MOUSE_DRAGGED, (MouseEvent e) -> {
            destroyCount++;
            if (destroyCount > 10) {
                crc.setRadius(crc.getRadius() - 0.1);
            }
        });

        crc.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e) -> {
            destroyCount = 0;
            crc.setRadius(10.0f);
        });

        Button btnR = new Button("Move Circle Right");
        btnR.setLayoutX(175);
        btnR.setOnAction((ActionEvent event) -> {
            if (isX) {
                if (crc.getCenterX() >= scene.getWidth()) {
                    crc.setCenterX(0);
                }
                crc.moveX(10);
            } else {
                if (crc.getCenterY() >= scene.getHeight()) {
                    crc.setCenterY(0);
                }
                crc.moveY(10);
            }
        });

        Button btnL = new Button("Move Circle Left");

        btnL.setOnAction((ActionEvent event) -> {
            if (isX) {
                if (crc.getCenterX() >= scene.getWidth()) {
                    crc.setCenterX(0);
                }
                crc.moveX(-10);
            } else {
                if (crc.getCenterY() >= scene.getHeight()) {
                    crc.setCenterY(0);
                }
                crc.moveY(-10);
            }
        });

        Button btnXY = new Button("Sposta su y");
        btnXY.setLayoutX(100);
        btnXY.setOnAction((ActionEvent event) -> {
            if (isX) {
                isX = false;
                btnXY.setText("Sposta su x");
            } else {
                isX = true;
                btnXY.setText("Sposta su y");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent e) -> {
            if (null != e.getCode()) {
                switch (e.getCode()) {
                    case LEFT:
                        btnL.fire();
                        break;
                    case RIGHT:
                        btnR.fire();
                        btnR.isPressed();
                        break;
                    case DOWN:
                        btnXY.fire();
                        break;
                    case END:
                        Platform.exit();
                        break;
                    default:
                        break;
                }
            }
        });

        root.getChildren().addAll(crc);
        btnRoot.getChildren().addAll(btnR, btnL, btnXY);

        Stage stage = new Stage();
        stage.setTitle("Controlli");
        stage.setY(105);
        stage.setX(200);
        stage.setScene(btnScene);
        stage.show();

        primaryStage.setTitle("Cerchio!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
