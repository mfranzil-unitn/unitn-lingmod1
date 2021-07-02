package carlo_esame201707;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.Random;

/**
 * Classe rappresentante un Dado
 *
 * @author Carlo Corradini
 */
public class Dado extends Pane implements Comparable<Dado> {

    /**
     * Grandezza Faccia Dado
     */
    public static final int DADO_SIZE = 100;

    /**
     * Grandezza Punto
     */
    public static final int DOT_SIZE = 10;

    /**
     * Massimo Valore di un Dado
     */
    public static final int MAX_VALUE = 6;

    /**
     * Durata Animazione
     */
    public static final Duration TRANSITION_DURATION = Duration.millis(2500);
    private int value;
    private Campo campo;

    /**
     * Costruttore Dado
     *
     * @param posX  Posizione X Dado
     * @param posY  Posizione Y Dado
     * @param value Valore del Dado
     * @param campo Riferimento al campo
     * @throws IllegalDadoValueException Lanciato quando il valore non è ammesso
     */
    public Dado(double posX, double posY, int value, Campo campo) throws IllegalDadoValueException {
        if (value < 1 || value > MAX_VALUE) {
            throw new IllegalDadoValueException("Tentativo di creazione dado con valore non ammesso [" + value + "]");
        }
        super.setLayoutX(posX);
        super.setLayoutY(posY);
        super.setPrefSize(DADO_SIZE, DADO_SIZE);
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        super.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        this.value = value;
        this.campo = campo;
        setInterface(this.value);
        handleClick();
    }

    /**
     * Ritorna il valore del Dado
     *
     * @return Valore Dado
     */
    public int getValue() {
        return value;
    }

    private void handleClick() {
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            Random random = new Random(System.currentTimeMillis());
            int newValue = value;
            do {
                newValue = random.nextInt(MAX_VALUE) + 1;
            } while (newValue == value);
            super.getChildren().clear();
            value = newValue;
            setInterface(newValue);
            campo.decrementaContatore();
            campo.checkVictory();
            event.consume();
        });
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
                System.out.println("[INFO]: SetInterface | Valore ignorato -> " + value);
                break;
            }
        }
    }

    /**
     * Ritorna una copia esatta del Dado(this)
     *
     * @return Copia this
     * @throws IllegalDadoValueException Lanciato quando il valore non è ammesso
     */
    public Dado copy() throws IllegalDadoValueException {
        return new Dado(0, 0, value, campo);
    }

    /**
     * Animazione Spostamento
     */
    public void moveAway() {
        super.setDisable(true);
        Random random = new Random(System.currentTimeMillis());
        int direction;
        TranslateTransition tt = new TranslateTransition(TRANSITION_DURATION, this);
        tt.setFromX(super.getTranslateX());
        tt.setFromY(super.getTranslateY());
        switch (random.nextInt(4)) {
            case 0: {
                tt.setToX(campo.getWidth() * (random.nextInt(value) + 1));
                tt.setToY(campo.getHeight() * (random.nextInt(value) + 1));
                break;
            }
            case 1: {
                tt.setToX(campo.getWidth() * (random.nextInt(value) + 1));
                tt.setToY(campo.getHeight() * -(random.nextInt(value) + 1));
                break;
            }
            case 2: {
                tt.setToX(campo.getWidth() * -(random.nextInt(value) + 1));
                tt.setToY(campo.getHeight() * (random.nextInt(value) + 1));
                break;
            }
            case 3: {
                tt.setToX(campo.getWidth() * -(random.nextInt(value) + 1));
                tt.setToY(campo.getHeight() * -(random.nextInt(value) + 1));
                break;
            }
            default: {
                tt.setToX(campo.getWidth() * 1);
                tt.setToY(campo.getHeight() * 1);
                break;
            }
        }
        tt.setOnFinished(((event) -> {
            campo.remove(this);
        }));
        tt.play();
    }

    /**
     * Animazione dissolvenza
     */
    public void dissolve() {
        super.setDisable(true);
        FadeTransition ft = new FadeTransition(TRANSITION_DURATION, this);
        ft.setFromValue(1f);
        ft.setToValue(0f);
        ft.setOnFinished((ActionEvent event) -> {
            campo.remove(this);
        });
        ft.play();
    }

    @Override
    public int compareTo(Dado o) {
        return this.value - o.getValue();
    }

    @Override
    public String toString() {
        return "[DADO]: " + value;
    }
}
