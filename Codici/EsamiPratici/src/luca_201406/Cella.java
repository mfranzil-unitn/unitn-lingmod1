package luca_201406;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucamartinelli
 */
public class Cella extends StackPane {

    Circle c;
    Rectangle r;
    Boolean visible;

    Cella() {
        c = new Circle(12, Color.RED);
        r = new Rectangle(30, 30, Color.WHITE);
        c.setVisible(false);
        c.setMouseTransparent(true);
        r.setStroke(Color.BLACK);
        this.getChildren().addAll(r, c);

        r.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (c.isVisible() == true) {
                    c.setVisible(false);
                } else {
                    c.setVisible(true);
                }
            }
        });

    }

}
