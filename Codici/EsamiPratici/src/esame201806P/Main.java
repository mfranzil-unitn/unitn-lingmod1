package esame201806P;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TextContainer<Integer> punteggio = new TextContainer<>("Punteggio");
        TextContainer<Integer> tentativi = new TextContainer<>("Tentativi");
        Griglia griglia = new Griglia(punteggio, tentativi);
        punteggio.setAssociatedValue(griglia.getPunteggio());
        tentativi.setAssociatedValue(griglia.getTentativi());


        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(punteggio, tentativi, griglia);

        Scene scene = new Scene(root);

        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.setTitle("Lucky Click");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
