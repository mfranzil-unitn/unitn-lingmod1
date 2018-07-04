package esameorologio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.time.LocalDateTime;

import static esameorologio.Orologio.OFFSET;
import static esameorologio.Orologio.RADIUS;

public class Main extends Application {

    private Scene clockScene;
    private Stage clockStage;
    private double xOffset, yOffset;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        var quadrato = new RadioButton("Quadrato");
        var rotondo = new RadioButton("Rotondo");
        var radio = new ToggleGroup();
        quadrato.setToggleGroup(radio);
        rotondo.setToggleGroup(radio);

        radio.selectToggle(rotondo);
        quadrato.setUserData("Quadrato");
        rotondo.setUserData("Rotondo");

        var manuale = new Button("Manuale");
        var automatico = new Button("Automatico");

        var vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(quadrato, rotondo, manuale, automatico);

        manuale.setOnAction(e -> generateNewClock(manuale.getText(), radio));
        automatico.setOnAction(e -> generateNewClock(automatico.getText(), radio));

        var scene = new Scene(vbox);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Orologi");
        primaryStage.show();

    }

    private void generateNewClock(String mode, ToggleGroup radio) {
        var orologio = new Orologio(mode, (String) radio.getSelectedToggle().getUserData());
        initActions(orologio);

        try {
            clockStage.close();
        } catch (NullPointerException ex) {
            System.err.println("Trying to close an empty stage");
        }

        if (mode.equals("Automatico")) {
            clockScene = new Scene(orologio, 2 * OFFSET + 2 * RADIUS, 2 * OFFSET + 2 * RADIUS);
        } else {
            clockScene = new Scene(orologio);
        }

        clockStage = new Stage();

        clockScene.setFill(Color.TRANSPARENT);

        clockStage.setScene(clockScene);
        clockStage.setTitle("Orologio");
        clockStage.initStyle(StageStyle.TRANSPARENT);
        clockStage.show();
    }

    private void initActions(Orologio orologio) {
        // Drag and drop
        orologio.setOnMousePressed(e -> {
            xOffset = clockStage.getX() - e.getScreenX();
            yOffset = clockStage.getY() - e.getScreenY();
        });

        orologio.setOnMouseDragged(e -> {
            clockStage.setX(e.getScreenX() + xOffset);
            clockStage.setY(e.getScreenY() + yOffset);
        });

        // Cursore
        orologio.setOnMouseEntered(e -> {
            if (!e.isPrimaryButtonDown()) {
                orologio.setCursor(Cursor.HAND);
            }
        });

        orologio.setOnMouseMoved(e ->
                Tooltip.install(orologio,
                        new Tooltip(LocalDateTime.now().getHour()
                                + ":" + LocalDateTime.now().getMinute()
                                + ":" + LocalDateTime.now().getSecond())
                )
        );
    }

}
