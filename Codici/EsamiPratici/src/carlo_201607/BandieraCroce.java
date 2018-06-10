package carlo_201607;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Classe rappresentante una bandiera a croce
 *
 * @author Carlo Corradini
 */
public class BandieraCroce extends Bandiera {

    /**
     * Costruttore Bandiera caratterizzata da una croce
     *
     * @param crossColor Colore della croce
     * @param backgroundColor Colore di sfondo
     */
    public BandieraCroce(Color crossColor, Color backgroundColor) {
        Rectangle rec;
        rec = new Rectangle(0, 0, 60, 30);
        rec.setFill(crossColor);
        super.getChildren().add(rec);
        rec = new Rectangle(0, 0, 12, 12);
        rec.setFill(backgroundColor);
        super.getChildren().add(rec);
        rec = new Rectangle(0, 18, 12, 12);
        rec.setFill(backgroundColor);
        super.getChildren().add(rec);
        rec = new Rectangle(18, 0, 42, 12);
        rec.setFill(backgroundColor);
        super.getChildren().add(rec);
        rec = new Rectangle(18, 18, 42, 12);
        rec.setFill(backgroundColor);
        super.getChildren().add(rec);
    }
}
