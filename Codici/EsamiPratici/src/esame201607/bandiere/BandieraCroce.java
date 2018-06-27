package esame201607.bandiere;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BandieraCroce extends Bandiera {
    private Rectangle bRect, cRect;

    public BandieraCroce(Color a, Color b) {
        Rectangle aRect = new Rectangle(0, 0, getPrefWidth(), getPrefHeight());
        aRect.setFill(a);
        getChildren().add(aRect);

        Rectangle bRect = new Rectangle(getPrefWidth() / 5.0, 0, getPrefWidth() / 10.0, getPrefHeight());
        bRect.setFill(b);
        getChildren().add(bRect);

        Rectangle cRect = new Rectangle(0, getPrefHeight() / 2.5, getPrefWidth(), getPrefHeight() / 5.0);
        cRect.setFill(b);
        getChildren().add(cRect);

    }
}