package esame201607.bandiere;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Bandiera extends Pane {
    Bandiera() {
        setPrefSize(50, 30);
        Rectangle rec = new Rectangle(this.getPrefWidth(), this.getPrefHeight());
        rec.setStroke(Color.BLACK);
        rec.setStrokeWidth(2);
        rec.toFront();
        super.getChildren().add(rec);
    }
}
