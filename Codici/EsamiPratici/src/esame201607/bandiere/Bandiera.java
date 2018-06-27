package esame201607.bandiere;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Bandiera extends Pane {
    Bandiera() {
        setPrefSize(60, 30);
        Rectangle rec = new Rectangle(60, 30);
        rec.setStroke(Color.BLACK);
        rec.setStrokeWidth(2);
        rec.toFront();
        super.getChildren().add(rec);
    }
}
