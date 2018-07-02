package esame201807.figure;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static esame201807.CellContainer.SIZE;

public class CerchioGiallo extends Circle {

    public CerchioGiallo() {
        super(SIZE/2, Color.YELLOW);
        setStroke(Color.RED);
        setStrokeWidth(1);
    }

    @Override
    public String toString() {
        return "Cerchio";
    }
}
