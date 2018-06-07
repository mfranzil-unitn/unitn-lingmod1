package esame201607_carlo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Classe rappresentante una bandiera a due fasce orizzontali
 *
 * @author Carlo Corradini
 */
public class BandieraDueFasceOrizzontali extends Bandiera {

    /**
     * Costruttore BandieraDueFasceOrizzontali caratterizzata da due bande
     * colorate
     *
     * @param topColor Colore superiore
     * @param bottomColor Colore inferiore
     */
    public BandieraDueFasceOrizzontali(Color topColor, Color bottomColor) {
        Rectangle rec = new Rectangle(0, 0, 60, 15);
        rec.setFill(topColor);
        super.getChildren().add(rec);
        rec = new Rectangle(0, 15, 60, 15);
        rec.setFill(bottomColor);
        super.getChildren().add(rec);
    }
}
