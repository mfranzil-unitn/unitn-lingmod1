package esame200507;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Button state = new Button("Cambia stato");
        Text st_txt = new Text("DISABILITATO");
        TextField xCoord = new TextField("0");
        TextField yCoord = new TextField("0");
        Text x_txt = new Text("X");
        Text y_txt = new Text("Y");

        BorderPane root = new BorderPane();
        GridPane panel = new GridPane();
        Area area = new Area(xCoord, yCoord);
        // Panel


        state.setOnAction(e -> {
            area.setxMode(!area.isxMode());
            st_txt.setText(area.isxMode() ? "ABILITATO" : "DISABILITATO");
        });

        panel.add(state, 0, 0);
        panel.add(st_txt, 1, 0);
        panel.add(x_txt,2,0);
        panel.add(xCoord, 3, 0);
        panel.add(y_txt,2,1);
        panel.add(yCoord, 3, 1);

        panel.setHgap(10);
        panel.setVgap(10);
        panel.setPadding(new Insets(10,10,10,10));


        root.setTop(panel);
        root.setCenter(area);

        Scene scene = new Scene(root, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ics");
        primaryStage.show();
    }
}
