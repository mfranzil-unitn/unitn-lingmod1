package carlo_esame201607;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Classe rappresentante una bandiera a tre fasce orizzontali
 *
 * @author Carlo Corradini
 */
public class BandieraTreFasceOrizzontali extends Bandiera {

    /**
     * Costruttore BandieraTreFasceOrizzontali caratterizzata da tre bande
     * colorate
     *
     * @param topColor    Colore superiore
     * @param middleColor Colore centrale
     * @param bottomColor Colore inferiore
     */
    public BandieraTreFasceOrizzontali(Color topColor, Color middleColor, Color bottomColor) {
        Rectangle rec = new Rectangle(0, 0, 60, 10);
        rec.setFill(topColor);
        super.getChildren().add(rec);
        rec = new Rectangle(0, 10, 60, 10);
        rec.setFill(middleColor);
        super.getChildren().add(rec);
        rec = new Rectangle(0, 20, 60, 10);
        rec.setFill(bottomColor);
        super.getChildren().add(rec);
    }
}
