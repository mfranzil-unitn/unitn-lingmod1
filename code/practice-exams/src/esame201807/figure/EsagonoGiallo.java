package esame201807.figure;

import esame201807.CellContainer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class EsagonoGiallo extends Polygon {

    public EsagonoGiallo() {
        super(CellContainer.SIZE / 2.0, 0,
                CellContainer.SIZE, 0,
                CellContainer.SIZE + CellContainer.SIZE / 4.0, CellContainer.SIZE * Math.sqrt(3) / 4.0,
                CellContainer.SIZE, CellContainer.SIZE * Math.sqrt(3) / 2.0,
                CellContainer.SIZE / 2.0, CellContainer.SIZE * Math.sqrt(3) / 2.0,
                CellContainer.SIZE / 4.0, CellContainer.SIZE * Math.sqrt(3) / 4.0);
        setRotate(180);
        setFill(Color.YELLOW);
        setStroke(Color.RED);
        setStrokeWidth(1);
    }

    @Override
    public String toString() {
        return "Esagono";
    }
}
