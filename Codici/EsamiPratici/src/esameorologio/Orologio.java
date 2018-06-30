package esameorologio;

import javafx.animation.RotateTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.time.LocalDateTime;

public class Orologio extends Pane {

    public static final int RADIUS = 160;
    private Circle clock;
    private double ore, minuti, secondi;
    private Rectangle optionalClock;

    public Orologio(String mode, String shape) {
        clock = new Circle(180, 180, RADIUS, Color.BLACK);
        optionalClock = new Rectangle(20, 20, RADIUS * 2, RADIUS * 2);
        getChildren().addAll(optionalClock, clock);

        if (!shape.equals("Quadrato")) {
            optionalClock.setFill(null);
        }

        if (mode.equals("Manuale")) {
            TextField ore = new TextField("0") {{
                setPrefWidth(40);
            }};
            TextField minuti = new TextField("0") {{
                setPrefWidth(40);
            }};
            TextField secondi = new TextField("0") {{
                setPrefWidth(40);
            }};
            Text text1 = new Text(":");
            Text text2 = new Text(":");
            Button aggiorna = new Button("Aggiorna");


            HBox choice = new HBox() {{
                getChildren().addAll(ore, text1, minuti, text2, secondi, aggiorna);
            }};
            choice.setLayoutX(280);
            choice.setLayoutY(360);
            choice.setPadding(new Insets(20, 20, 20, 20));

            aggiorna.setOnAction(e -> {
                try {
                    if (Integer.parseInt(ore.getText()) >= 0 &&
                            Integer.parseInt(ore.getText()) <= 23 &&
                            Integer.parseInt(minuti.getText()) >= 0 &&
                            Integer.parseInt(minuti.getText()) <= 59 &&
                            Integer.parseInt(secondi.getText()) >= 0 &&
                            Integer.parseInt(secondi.getText()) <= 59) {
                        this.ore = Integer.parseInt(ore.getText());
                        this.minuti = Integer.parseInt(minuti.getText());
                        this.secondi = Integer.parseInt(secondi.getText());
                        getChildren().retainAll(choice, clock, optionalClock);
                        getChildren().addAll(drawArc(this.ore * 360 / 12, 2 * RADIUS / 3.0, 5, Color.RED),
                                drawArc(this.minuti * 360 / 60.0, RADIUS, 5, Color.GREEN),
                                drawArc(this.secondi * 360 / 60.0, 9*RADIUS/10.0, 2, Color.BLUE));
                    } else {
                        new Alert(Alert.AlertType.ERROR, "Formato non corretto!", ButtonType.OK).showAndWait();
                    }
                } catch (NumberFormatException ex) {
                    new Alert(Alert.AlertType.ERROR, "Formato non corretto!", ButtonType.OK).showAndWait();
                }
            });

            getChildren().add(choice);
        } else {
            this.ore = LocalDateTime.now().getHour() * 360 / 12;
            this.minuti =  LocalDateTime.now().getMinute() * 360 / 60.0;
            this.secondi =  (LocalDateTime.now().getSecond() - 3) * 360 / 60.0;

            var oreRoot = new Pane();
            var oreArc = drawArc(0 , 3 * RADIUS / 4.0, 8, Color.RED);
            oreRoot.setLayoutX(0);
            oreRoot.setLayoutY(0);
            oreRoot.setPrefSize(360,360);
            oreRoot.getChildren().add(oreArc);

            var minutiRoot = new Pane();
            var minutiArc = drawArc(0, RADIUS, 5, Color.GREEN);
            minutiRoot.setLayoutX(0);
            minutiRoot.setLayoutY(0);
            minutiRoot.setPrefSize(360,360);
            minutiRoot.getChildren().add(minutiArc);

            var secondiRoot = new Pane();
            var secondiArc = drawArc(0, 9*RADIUS/10.0, 2, Color.BLUE);
            secondiRoot.setLayoutX(0);
            secondiRoot.setLayoutY(0);
            secondiRoot.setPrefSize(360,360);
            secondiRoot.getChildren().add(secondiArc);

            getChildren().addAll(oreRoot,minutiRoot,secondiRoot);

            RotateTransition rt1 = new RotateTransition(Duration.millis(3000), oreRoot);
            rt1.setByAngle(this.ore);
            rt1.play();
            rt1.setOnFinished(e -> {
                rt1.setDuration(Duration.millis(1000*59*24));
                rt1.setByAngle(360 / 12.0);
                rt1.play();
            });

            RotateTransition rt2 = new RotateTransition(Duration.millis(3000), minutiRoot);
            rt2.setByAngle(this.minuti);
            rt2.play();
            rt2.setOnFinished(e -> {
                rt2.setDuration(Duration.millis(1000*59));
                rt2.setByAngle(360 / 60.0);
                rt2.play();
            });

            RotateTransition rt3 = new RotateTransition(Duration.millis(3000), secondiRoot);
            rt3.setByAngle(this.secondi);
            rt3.play();
            rt3.setOnFinished(e -> {
                rt3.setDuration(Duration.millis(1000*59));
                rt3.setByAngle(360);
                rt3.play();
            });

        }
    }

    private Arc drawArc(double pos, double radius, double length, Color c) {
        pos = pos + 90 - 2 * pos;
        pos = pos % 360;
        System.out.println(pos);
        Arc arc = new Arc();
        arc.setCenterX(180);
        arc.setCenterY(180);
        arc.setRadiusX(radius);
        arc.setRadiusY(radius);
        arc.setStartAngle(pos - length/2.0);
        arc.setLength(length);
        arc.setFill(c);
        arc.setType(ArcType.ROUND);
        arc.setRotationAxis(Rotate.Z_AXIS);
        return arc;
    }
}
