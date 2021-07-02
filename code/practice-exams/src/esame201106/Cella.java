/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201106;

import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * @author Matteo Franzil
 */
public class Cella extends StackPane {

    public static final int SIZE = 80;
    public static final int MAX_CLICKS = 4;
    private Color color, defaultColor;
    private int clickCount;
    private Circle ellipse;

    public Cella(Color color) {
        clickCount = 0;
        this.color = color;
        this.defaultColor = color;
        setBackground(new Background(new BackgroundFill(color, new CornerRadii(10), Insets.EMPTY)));
        setPrefWidth(SIZE);
        setMinWidth(10);
        setPrefHeight(SIZE);
        setMinHeight(10);

        ellipse = new Circle(this.SIZE * 0.45, Pannello.C4);
        ellipse.setVisible(false);

        getChildren().add(ellipse);

        addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            if (clickCount < MAX_CLICKS) {
                switchColor();
                clickCount++;
            }
            if (clickCount == MAX_CLICKS) {
                setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            }
        });
    }

    public void switchColor() {
        if (color == Pannello.C3) {
            color = defaultColor;
        } else if (color == Pannello.C1) {
            color = Pannello.C3;
        } else if (color == Pannello.C2 && !ellipse.isVisible()) {
            ellipse.setVisible(true);
        } else if (color == Pannello.C2 && ellipse.isVisible()) {
            ellipse.setVisible(false);
        }
        setBackground(new Background(new BackgroundFill(color, new CornerRadii(10), Insets.EMPTY)));
    }

    @Override
    public String toString() {
        return "Cella di colore " + color.toString();
    }

}
