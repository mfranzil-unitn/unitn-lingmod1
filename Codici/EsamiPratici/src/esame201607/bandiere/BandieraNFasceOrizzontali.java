package esame201607.bandiere;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Arrays;
import java.util.LinkedList;

public class BandieraNFasceOrizzontali extends Bandiera {
    public BandieraNFasceOrizzontali(Color... c) {
        LinkedList<Color> colors = new LinkedList<>(Arrays.asList(c));

        int i = 0;
        for (Color color : colors) {
            Rectangle rect = new Rectangle(0, getPrefHeight() * i / colors.size(),
                    getPrefWidth(), getPrefHeight() / colors.size());
            rect.setFill(color);
            getChildren().add(rect);
            i++;
        }
    }
}
