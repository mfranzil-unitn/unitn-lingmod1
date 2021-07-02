package esame201807;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class CellContainer extends StackPane {

    public static final int SIZE = 40;
    private Shape figura;

    public CellContainer() {
        showBackground();
        setPrefSize(SIZE + 2, SIZE + 2);
        setRotate(180);
    }

    public void removeFigura() {
        getChildren().remove(figura);
        this.figura = null;
    }

    public Shape getFigura() {
        return figura;
    }

    public void setFigura(Shape figura) {
        this.figura = figura;
        getChildren().add(figura);
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

    public void showBackground() {
        setBackground(new Background(new BackgroundFill(Color.rgb(10, 10, 10, 0.8),
                CornerRadii.EMPTY, Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.rgb(230, 230, 230, 0.9),
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }

    public void hideBackground() {
        setBackground(null);
        setBorder(null);
    }
}

