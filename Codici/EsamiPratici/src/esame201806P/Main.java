package esame201806P;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
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

        GridPane root = new GridPane();
        VBox info = new VBox();
        info.getChildren().addAll(punteggio,tentativi);
        info.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));
        root.add(info,0,0);
        root.add(griglia,0,1);

        RowConstraints r1 = new RowConstraints();
        r1.setPercentHeight(10);
        RowConstraints r2 = new RowConstraints();
        r2.setPercentHeight(90);
        ColumnConstraints c1 = new ColumnConstraints();
        c1.setPercentWidth(100);

        root.getRowConstraints().addAll(r1,r2);
        root.getColumnConstraints().add(c1);

        Scene scene = new Scene(root);

        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.setTitle("Lucky Click");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
