package esame201807.figure;

import esame201807.CellContainer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class TriangoloGiallo extends Polygon {

    public TriangoloGiallo() {
        super(0, 0,
                0 + CellContainer.SIZE, 0,
                0 + CellContainer.SIZE / 2.0, CellContainer.SIZE * Math.sqrt(3) / 2.0);
        setFill(Color.YELLOW);
        setStroke(Color.RED);
        setStrokeWidth(1);
    }

    @Override
    public String toString() {
        return "Triangolo";
    }
}
