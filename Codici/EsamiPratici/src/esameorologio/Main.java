package esameorologio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Scene clockScene;
    Stage clockStage;

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
        primaryStage.setScene(scene);
        primaryStage.setTitle("Orologi");
        primaryStage.show();

    }

    private void generateNewClock(String mode, ToggleGroup radio) {
        var orologio = new Orologio(mode,(String) radio.getSelectedToggle().getUserData());
        try {
            clockStage.close();
        } catch (NullPointerException ex) {
            System.err.println("Trying to close an empty stage");
        }
        clockStage = new Stage();
        if (mode.equals("Automatico")) {
            clockScene = new Scene(orologio, 360, 360);
        } else {
            clockScene = new Scene(orologio);
        }
        clockStage.setScene(clockScene);
        clockStage.setTitle("Orologio");
        clockStage.show();
    }
}
