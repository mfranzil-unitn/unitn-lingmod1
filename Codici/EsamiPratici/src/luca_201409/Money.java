package luca_201409;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Money {

    Circle circle;
    Text testo;
    StackPane c;

    Money() {
        circle = new Circle(40);
        circle.setFill(Color.YELLOW);
        circle.setStroke(Color.BLACK);
        testo = new Text("1 euro");
        c = new StackPane(circle, testo);
        circle.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                PathTransition a = new PathTransition();
            }

        });
    }
}
