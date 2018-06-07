/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame_slotmachine;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 *
 * @author Matteo Franzil
 */
public class Moneta extends StackPane {

    Circle circle;
    Text text;

    public Moneta(Pannello panel) {
        circle = new Circle(50, Color.AQUAMARINE);
        text = new Text("1 Euro");

        getChildren().addAll(circle, text);

        addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            convert(panel);
        });
    }

    public void convert(Pannello panel) {
        setVisible(false); // ADD ANIMATION
        panel.setCredito(panel.getCredito() + 100);
    }

    public void reset() {
        setVisible(true);
    }

}
