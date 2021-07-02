package esame201607.bandiere;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BandieraTreFasceOrizzontali extends Bandiera {
    public BandieraTreFasceOrizzontali(Color a, Color b, Color c) {
        Rectangle aRect = new Rectangle(0, 0, getPrefWidth(), getPrefHeight() / 3.0);
        aRect.setFill(a);
        getChildren().add(aRect);

        Rectangle bRect = new Rectangle(0, getPrefHeight() / 3.0, getPrefWidth(), getPrefHeight() / 3.0);
        bRect.setFill(b);
        getChildren().add(bRect);

        Rectangle cRect = new Rectangle(0, getPrefHeight() * 2.0 / 3.0, getPrefWidth(), getPrefHeight() / 3);
        cRect.setFill(c);
        getChildren().add(cRect);
    }
}
