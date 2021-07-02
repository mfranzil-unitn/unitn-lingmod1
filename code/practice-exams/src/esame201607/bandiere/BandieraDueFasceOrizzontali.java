package esame201607.bandiere;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BandieraDueFasceOrizzontali extends Bandiera {
    public BandieraDueFasceOrizzontali(Color a, Color b) {
        Rectangle aRect = new Rectangle(0, 0, getPrefWidth(), getPrefHeight() / 2.0);
        aRect.setFill(a);
        getChildren().add(aRect);

        Rectangle bRect = new Rectangle(0, getPrefHeight() / 2.0, getPrefWidth(), getPrefHeight() / 2.0);
        bRect.setFill(b);
        getChildren().add(bRect);
    }
}
