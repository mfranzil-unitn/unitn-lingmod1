package carlo_esame201607;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Classe rappresentante una bandiera vuota
 *
 * @author Carlo Corradini
 */
public abstract class Bandiera extends Pane {

    /**
     * Costruttore Bandiera
     *
     * @param width       Lunghezza bandiera
     * @param height      Altezza bandiera
     * @param borderColor Colore bordo bandiera
     */
    public Bandiera(double width, double height, Color borderColor) {
        super.setWidth(width);
        super.setHeight(height);
        Rectangle rec = new Rectangle(width, height);
        rec.setStroke(borderColor);
        rec.setStrokeWidth(2);
        super.getChildren().add(rec);
    }

    public Bandiera(double width, double height) {
        this(width, height, Color.BLACK);
    }

    public Bandiera() {
        this(60, 30);
    }
}
