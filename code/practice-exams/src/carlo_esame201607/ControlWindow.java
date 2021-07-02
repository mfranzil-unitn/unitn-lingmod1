package carlo_esame201607;

import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

/**
 * Classe rappresentante la schermata di controllo
 *
 * @author Carlo Corradini
 */
public class ControlWindow extends BorderPane {

    private final Button[] buttons;

    /**
     * Costruttore della classe che rappresenta la schermata di controllo
     *
     * @param window Pannello principale
     */
    public ControlWindow(MainWindow window) {
        GridPane buttonsPane = new GridPane();
        buttonsPane.setHgap(10);
        buttonsPane.setVgap(10);
        buttons = new Button[6];
        buttons[0] = new Button("1a Giornata");
        buttons[1] = new Button("2a Giornata");
        buttons[2] = new Button("3a Giornata");
        buttons[3] = new Button("Quarti");
        buttons[4] = new Button("Semifinale");
        buttons[5] = new Button("Finale");

        for (Button button : buttons) {
            button.setMinWidth(100);
            button.setPadding(new Insets(10));
        }

        Circle cerchio = new Circle(50, 150, 25);
        cerchio.setFill(Color.rgb(33, 133, 208));
        cerchio.setStroke(Color.rgb(0, 0, 0));
        cerchio.setStrokeWidth(2);
        super.getChildren().add(cerchio);

        Path path = new Path();
        MoveTo moveTo = new MoveTo(50, 150);
        QuadCurveTo qt1 = new QuadCurveTo(100, 10, 150, 150);
        QuadCurveTo qt2 = new QuadCurveTo(225, 50, 300, 150);
        path.getElements().add(moveTo);
        path.getElements().add(qt1);
        path.getElements().add(qt2);
        path.setStrokeLineCap(StrokeLineCap.ROUND);
        PathTransition transition = new PathTransition(Duration.millis(1000), path, cerchio);

        buttons[0].addEventHandler(ActionEvent.ACTION, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                buttons[0].setDisable(true);
                transition.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        window.toStep(1);
                        buttons[1].setDisable(false);
                    }
                });
                transition.play();
            }
        });
        buttons[1].addEventHandler(ActionEvent.ACTION, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                buttons[1].setDisable(true);
                transition.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        window.toStep(2);
                        buttons[2].setDisable(false);
                    }
                });
                transition.play();
            }
        });
        buttons[2].addEventHandler(ActionEvent.ACTION, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                buttons[2].setDisable(true);
                transition.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        window.toStep(3);
                        buttons[3].setDisable(false);
                    }
                });
                transition.play();
            }
        });
        buttons[3].addEventHandler(ActionEvent.ACTION, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                Alert alert = new Alert(AlertType.ERROR, "La funzionalità richiesta non è supportata", ButtonType.OK);
                alert.setHeaderText("Errore!");
                alert.setTitle("Coming Soon");
                alert.showAndWait();
                Platform.exit();
                System.exit(0);
            }
        });

        buttonsPane.setAlignment(Pos.CENTER);
        buttons[1].setDisable(true);
        buttons[2].setDisable(true);
        buttons[3].setDisable(true);
        buttons[4].setDisable(true);
        buttons[5].setDisable(true);

        buttonsPane.add(buttons[0], 0, 0);
        buttonsPane.add(buttons[1], 1, 0);
        buttonsPane.add(buttons[2], 2, 0);
        buttonsPane.add(buttons[3], 0, 1);
        buttonsPane.add(buttons[4], 1, 1);
        buttonsPane.add(buttons[5], 2, 1);

        super.setBottom(buttonsPane);
    }
}
