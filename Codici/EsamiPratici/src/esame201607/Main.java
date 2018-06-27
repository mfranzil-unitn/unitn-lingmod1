package esame201607;

import esame201607.views.Girone;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.LinkedList;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        LinkedList<Squadra> squadre = Squadra.getSquadreRandom();

        Girone g1 = new Girone(Color.WHITE, squadre.subList(0, 4));
        Girone g2 = new Girone(Color.YELLOW, squadre.subList(4, 8));
        Girone g3 = new Girone(Color.YELLOW, squadre.subList(8, 12));
        Girone g4 = new Girone(Color.WHITE, squadre.subList(12, 16));

        Stage controls = new Controls(Arrays.asList(g1,g2,g3,g4), squadre);

        GridPane root = new GridPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(10);
        root.setHgap(10);

        root.add(g1, 0, 0);
        root.add(g2, 1, 0);
        root.add(g3, 0, 1);
        root.add(g4, 1, 1);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Europei");
        primaryStage.show();

        controls.show();
    }
}
