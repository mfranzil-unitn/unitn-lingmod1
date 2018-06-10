package carlo_esame201607;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Classe rappresentante una bandiera a tre fasce verticali
 *
 * @author Carlo Corradini
 */
public class BandieraTreFasceVerticali extends Bandiera {

    /**
     * Costruttore BandieraTreFasceVerticali caratterizzata da tre bande
     * colorate
     *
     * @param leftColor Colore sinistro
     * @param centerColor Colore centrale
     * @param rightColor Colore destro
     */
    public BandieraTreFasceVerticali(Color leftColor, Color centerColor, Color rightColor) {
        Rectangle rec = new Rectangle(0, 0, 20, 30);
        rec.setFill(leftColor);
        super.getChildren().add(rec);
        rec = new Rectangle(20, 0, 20, 30);
        rec.setFill(centerColor);
        super.getChildren().add(rec);
        rec = new Rectangle(40, 0, 20, 30);
        rec.setFill(rightColor);
        super.getChildren().add(rec);
    }
}
