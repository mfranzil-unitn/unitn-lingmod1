package esame201607.bandiere;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BandieraCroceDoppia extends BandieraCroce {

    public BandieraCroceDoppia(Color a, Color b, Color c) {
        super(a, b);

        Rectangle dRect = new Rectangle(getPrefWidth() / 5.0 + getPrefWidth() / 40.0,
                0, getPrefWidth() / 20.0, getPrefHeight());
        dRect.setFill(c);
        dRect.toFront();
        getChildren().add(dRect);

        Rectangle eRect = new Rectangle(0, getPrefHeight() / 2.5 + getPrefWidth() / 30.0,
                getPrefWidth(), getPrefHeight() / 10.0);
        eRect.setFill(c);
        eRect.toFront();
        getChildren().add(eRect);
    }


}
