/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201706;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.LinkedList;

import static esame201706.Lineare.DIM;
import static esame201706.Lineare.SIZE;

/**
 * @author Matteo Franzil
 */
public class Contenitore {

    Rectangle rect;
    Circle c;
    boolean circleOn;

    public Contenitore(int i, int j, GridPane root, boolean isBigGrid, LinkedList<Button> modifiers) {
        rect = new Rectangle(DIM * i, DIM * j, SIZE, SIZE);
        rect.setFill(Paint.valueOf("WHITE"));
        rect.setStroke(Paint.valueOf("BLACK"));
        GridPane.setConstraints(rect, i, j, 1, 1);

        c = new Circle(SIZE / 2, Paint.valueOf("BLUE"));
        GridPane.setConstraints(c, GridPane.getColumnIndex(rect), GridPane.getRowIndex(rect), 1, 1);
        circleOn = false;

        if (!isBigGrid) {
            rect.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
                if (!circleOn) {
                    drawCircle(root);
                } else {
                    removeCircle(root);
                }
                if (Lineare.lastPressedButton != -1) {
                    modifiers.get(Lineare.lastPressedButton).fire();
                }
            });

            c.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
                removeCircle(root);
                modifiers.get(Lineare.lastPressedButton).fire();
            });
        } else {
            rect.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
                infoWindow();
            });

            c.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
                infoWindow();
            });
        }
    }

    public void drawCircle(GridPane root) {
        root.getChildren().add(c);
        circleOn = true;
    }

    public void removeCircle(GridPane root) {
        root.getChildren().remove(c);
        circleOn = false;

    }

    public void infoWindow() {
        StackPane root = new StackPane();
        Stage infoStage = new Stage();
        Scene infoScene = new Scene(root, 100, 50);
        Text txt = new Text(circleOn ? "Occupato" : "Libero");
        root.getChildren().add(txt);
        infoStage.setScene(infoScene);
        infoStage.setTitle("Stato");
        infoStage.show();

    }

}
