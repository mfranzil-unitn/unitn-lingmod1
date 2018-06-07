package disi.unitn.it.corradini.carlo;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Carlo Corradini
 */
public class Dado2 extends Pane {

    public static final int DADO_SIZE = 100;
    public static final int DOT_SIZE = 10;
    public static final int MAX_VALUE = 6;
    private final int value;

    public Dado2(double posX, double posY, int value) throws Exception {
        if (value < 1 || value > MAX_VALUE) {
            throw new Exception("Tentativo di creazione dado con valore non ammesso");
        }
        super.setLayoutX(posX);
        super.setLayoutY(posY);
        super.setPrefSize(DADO_SIZE, DADO_SIZE);
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        super.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        this.value = value;
        setInterface(this.value);
    }

    public int getValue() {
        return value;
    }

    private void setInterface(int value) {
        Circle circ;
        Color color = new Color(0, 0, 0, 1);
        switch (value) {
            case 1: {
                circ = new Circle(DADO_SIZE / 2, DADO_SIZE / 2, DOT_SIZE, color);
                super.getChildren().add(circ);
                break;
            }
            case 2: {
                circ = new Circle(25, 25, DOT_SIZE, color);
                super.getChildren().add(circ);
                circ = new Circle(DADO_SIZE - 25, DADO_SIZE - 25, DOT_SIZE, color);
                super.getChildren().add(circ);
                break;
            }
            case 3: {
                setInterface(1);
                setInterface(2);
                break;
            }
            case 4: {
                setInterface(2);
                circ = new Circle(DADO_SIZE - 25, 25, DOT_SIZE, color);
                super.getChildren().add(circ);
                circ = new Circle(25, DADO_SIZE - 25, DOT_SIZE, color);
                super.getChildren().add(circ);
                break;
            }
            case 5: {
                setInterface(1);
                setInterface(4);
                break;
            }
            case 6: {
                circ = new Circle(20, 25, DOT_SIZE, color);
                super.getChildren().add(circ);
                circ = new Circle(DADO_SIZE / 2, 25, DOT_SIZE, color);
                super.getChildren().add(circ);
                circ = new Circle(DADO_SIZE - 20, 25, DOT_SIZE, color);
                super.getChildren().add(circ);
                circ = new Circle(20, DADO_SIZE - 25, DOT_SIZE, color);
                super.getChildren().add(circ);
                circ = new Circle(DADO_SIZE / 2, DADO_SIZE - 25, DOT_SIZE, color);
                super.getChildren().add(circ);
                circ = new Circle(DADO_SIZE - 20, DADO_SIZE - 25, DOT_SIZE, color);
                super.getChildren().add(circ);
                break;
            }
            default: {
                System.out.println("[INFO]: SetInterface | Valore ignorato");
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "[DADO]: " + value;
    }
}
