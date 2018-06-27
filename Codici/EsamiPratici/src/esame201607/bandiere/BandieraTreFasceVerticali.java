package esame201607.bandiere;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BandieraTreFasceVerticali extends Bandiera {

    public BandieraTreFasceVerticali(Color a, Color b, Color c) {
        Rectangle aRect = new Rectangle(0, 0, getPrefWidth() / 3, getPrefHeight());
        aRect.setFill(a);
        getChildren().add(aRect);

        Rectangle bRect = new Rectangle(getPrefWidth() / 3.0, 0, getPrefWidth() / 3.0, getPrefHeight());
        bRect.setFill(b);
        getChildren().add(bRect);

        Rectangle cRect = new Rectangle(getPrefWidth() * 2 / 3.0, 0, getPrefWidth() / 3, getPrefHeight());
        cRect.setFill(c);
        getChildren().add(cRect);
    }
}
