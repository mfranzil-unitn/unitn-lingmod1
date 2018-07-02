package esame201807;

import esame201807.figure.CerchioGiallo;
import esame201807.figure.EsagonoGiallo;
import esame201807.figure.TriangoloGiallo;
import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class CellContainer extends StackPane {

    public static final int SIZE = 40;
    private Shape figura;

    public CellContainer() {
        setBackground(new Background(new BackgroundFill(Color.rgb(10, 10, 10, 0.8),
                CornerRadii.EMPTY, Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.rgb(230, 230, 230, 0.9),
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        setPrefSize(SIZE + 2, SIZE + 2);
        setRotate(180);
    }

    public void setFigura(Shape figura) {
        this.figura = figura;
        getChildren().add(figura);
    }

    public void removeFigura() {
        getChildren().remove(figura);
        this.figura = null;
    }

    public Shape getFigura() {
        return figura;
    }

    @Override
    public String toString() {
        String res;
        if (figura != null) {
            res = figura.toString();
        } else {
            res = "null";
        }
        return res;
    }
}
