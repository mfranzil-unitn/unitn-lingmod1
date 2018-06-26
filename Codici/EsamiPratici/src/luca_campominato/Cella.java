/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luca_campominato;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * @author lucamartinelli
 */
public class Cella extends StackPane {

    Circle c;
    Rectangle r;
    Boolean visible;
    Text near;
    int val, nearbomb = 0;

    Cella(int val) {
        near = new Text("" + nearbomb);
        near.setVisible(false);
        c = new Circle(20, Color.RED);
        r = new Rectangle(40, 40, Color.WHITE);
        c.setVisible(false);
        c.setMouseTransparent(true);
        r.setStroke(Color.BLACK);
        this.val = val;
        this.getChildren().addAll(r, c, near);

        r.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                azione(val);
            }
        });

    }

    void azione(int val) {
        switch (val) {
            case 0:
                r.setFill(Color.GRAY);
                CampoMinato.tot -= 1;
                break;
            case 1:
                c.setVisible(true);
                CampoMinato.tot -= 100;
                break;
            case 2:
                r.setFill(Color.RED);
                near.setText("" + nearbomb);
                near.setVisible(true);
                CampoMinato.tot -= 1;
                break;
        }

        CampoMinato.controlla();
    }

}
