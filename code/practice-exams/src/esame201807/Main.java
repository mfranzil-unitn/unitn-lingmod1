package esame201807;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        ContainerStack stack = new ContainerStack();
        Controls controls = new Controls(stack);

        root.setLeft(stack);
        root.setCenter(controls);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Figure geometriche");
        primaryStage.show();
    }
}
