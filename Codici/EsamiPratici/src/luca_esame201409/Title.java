package luca_esame201409;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Questa classe definisce il "titolo" presente nella GUI.
 *
 */
public class Title extends Group {

    public Title() {
        Label lab = new Label("Super\n  Slot");
        lab.setAlignment(Pos.CENTER);
        lab.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        lab.setLayoutX(250);
        lab.setLayoutY(15);
        Rectangle rect = new Rectangle(600, 100);
        rect.setFill(Color.YELLOW);
        rect.setStroke(Color.BLACK);
        rect.setStrokeWidth(5);
        this.getChildren().addAll(rect, lab);
    }
}
