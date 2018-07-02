package esameorologio;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.time.LocalDateTime;

public class Orologio extends Pane {

    public static final int RADIUS = 180;
    public static final int OFFSET = 20;

    private Circle clock;
    private double ore, minuti, secondi;
    private Rectangle optionalClock;
    private String mode, assignedShape;

    public Orologio(String mode, String shape) {
        this.mode = mode;
        this.assignedShape = shape;

        clock = new Circle(OFFSET + RADIUS, OFFSET + RADIUS, RADIUS, AccentParser.getAccentColor());
        optionalClock = new Rectangle(OFFSET, OFFSET, RADIUS * 2, RADIUS * 2);
        optionalClock.setFill(AccentParser.getAccentColor());
        getChildren().addAll(optionalClock, clock);

        setStyle("-fx-background-color: rgba(255, 255, 255, 0);");

        if (shape.equals("Quadrato")) {
            optionalClock.setEffect(getShadow());
            clock.setOpacity(0);
            optionalClock.setOpacity(0.6);
        } else {
            optionalClock.setFill(Color.TRANSPARENT);
            clock.setEffect(getShadow());
            clock.setOpacity(0.6);
        }

        if (mode.equals("Manuale")) {
            var ore = new TextField("0") {{
                setPrefWidth(40);
            }};
            var duepunti1 = new Text(":");
            var minuti = new TextField("0") {{
                setPrefWidth(40);
            }};
            var duepunti2 = new Text(":");
            var secondi = new TextField("0") {{
                setPrefWidth(40);
            }};
            var aggiorna = new Button("Aggiorna");


            var choice = new HBox() {{
                getChildren().addAll(ore, duepunti1, minuti, duepunti2, secondi, aggiorna);
            }};

            choice.setLayoutX(RADIUS + OFFSET);
            choice.setLayoutY(2*OFFSET + 2*RADIUS);
            choice.setPadding(new Insets(OFFSET));
            getChildren().add(choice);

            aggiorna.setOnAction(e -> {
                if (checkRange(ore, minuti, secondi)) {
                    this.ore = Integer.parseInt(ore.getText());
                    this.minuti = Integer.parseInt(minuti.getText());
                    this.secondi = Integer.parseInt(secondi.getText());
                    getChildren().retainAll(choice, clock, optionalClock);
                    getChildren().addAll(drawArc(this.ore * 360 / 12, 2 * RADIUS / 3.0, 7, Color.RED),
                            drawArc(this.minuti * 360 / 60.0, RADIUS, 5, Color.GREEN),
                            drawArc(this.secondi * 360 / 60.0, 9 * RADIUS / 10.0, 1, Color.BLUE));
                } else {
                    new Alert(Alert.AlertType.ERROR, "Formato non corretto!", ButtonType.OK).showAndWait();
                }
            });

            setOnKeyPressed(e -> {
                System.out.println(e.getCode());
                if (e.getCode() == KeyCode.ENTER) {
                    aggiorna.fire();
                }
            });
        } else {
            this.ore = LocalDateTime.now().getHour() * 360 / 12;
            this.minuti = LocalDateTime.now().getMinute() * 360 / 60.0;
            this.secondi = (LocalDateTime.now().getSecond() + 3) * 360 / 60.0;

            var oreRoot = new Pane();
            var oreArc = drawArc(0, 3 * RADIUS / 4.0, 7, Color.RED);
            oreRoot.setLayoutX(0);
            oreRoot.setLayoutY(0);
            oreRoot.setPrefSize(2*OFFSET + 2*RADIUS, 2*OFFSET + 2*RADIUS);
            oreRoot.getChildren().add(oreArc);

            var minutiRoot = new Pane();
            var minutiArc = drawArc(0, RADIUS, 5, Color.GREEN);
            minutiRoot.setLayoutX(0);
            minutiRoot.setLayoutY(0);
            minutiRoot.setPrefSize(2*OFFSET + 2*RADIUS, 2*OFFSET + 2*RADIUS);
            minutiRoot.getChildren().add(minutiArc);

            var secondiRoot = new Pane();
            var secondiArc = drawArc(0, 9 * RADIUS / 10.0, 1, Color.BLUE);
            secondiRoot.setLayoutX(0);
            secondiRoot.setLayoutY(0);
            secondiRoot.setPrefSize(2*OFFSET + 2*RADIUS, 2*OFFSET + 2*RADIUS);
            secondiRoot.getChildren().add(secondiArc);

            getChildren().addAll(oreRoot, minutiRoot, secondiRoot);

            RotateTransition rt1 = new RotateTransition(Duration.millis(3000), oreRoot);
            rt1.setByAngle(this.ore);
            rt1.play();
            rt1.setOnFinished(e -> {
                rt1.setDuration(Duration.millis(1000 * 59 * 24));
                rt1.setByAngle(360 / 12.0);
                rt1.play();
            });

            RotateTransition rt2 = new RotateTransition(Duration.millis(3000), minutiRoot);
            rt2.setByAngle(this.minuti);
            rt2.play();
            rt2.setOnFinished(e -> {
                rt2.setDuration(Duration.millis(1000 * 59));
                rt2.setByAngle(360 / 60.0);
                rt2.play();
            });

            RotateTransition rt3 = new RotateTransition(Duration.millis(3000), secondiRoot);
            rt3.setByAngle(this.secondi);
            rt3.play();
            rt3.setOnFinished(e -> {
                rt3.setDuration(Duration.millis(925));
                rt3.setByAngle(6);
                rt3.play();
            });
        }
    }

    private Arc drawArc(double pos, double radius, double length, Color c) {
        pos = pos + 90 - 2 * pos;
        pos = pos % 360;
        Arc arc = new Arc();
        arc.setCenterX(OFFSET + RADIUS);
        arc.setCenterY(OFFSET + RADIUS);
        arc.setRadiusX(radius);
        arc.setRadiusY(radius);
        arc.setStartAngle(pos - length / 2.0);
        arc.setLength(length);
        arc.setFill(c);
        arc.setType(ArcType.ROUND);
        arc.setRotationAxis(Rotate.Z_AXIS);
        return arc;
    }

    private DropShadow getShadow() {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(3.0);
        dropShadow.setOffsetY(3.0);
        dropShadow.setColor(Color.color(0, 0, 0));
        return dropShadow;
    }

    private boolean checkRange(TextField ore, TextField minuti, TextField secondi) {
        boolean res = false;
        try {
            res = Integer.parseInt(ore.getText()) >= 0 && Integer.parseInt(ore.getText()) <= 23 &&
                    Integer.parseInt(minuti.getText()) >= 0 && Integer.parseInt(minuti.getText()) <= 59 &&
                    Integer.parseInt(secondi.getText()) >= 0 && Integer.parseInt(secondi.getText()) <= 59;
        } catch (NumberFormatException ex) {
            new Alert(Alert.AlertType.ERROR, "Formato non corretto!", ButtonType.OK).showAndWait();
        }
        return res;
    }

    public String getMode() {
        return mode;
    }

    public String getAssignedShape() {
        return this.assignedShape;
    }
}
