package carlo_esame201607;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Classe rappresentante lo start Application
 *
 * @author Carlo Corradini
 */
public class Launcher extends Application {

    @Override
    public void start(Stage stage) {
        MainWindow mainWindow = new MainWindow();
        Scene mainScene = new Scene(mainWindow, 800, 700);

        stage.setOnHidden(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });
        stage.setTitle("Euro 2018");
        stage.setScene(mainScene);
        stage.setResizable(false);
        stage.show();

        ControlWindow controlWindow = new ControlWindow(mainWindow);
        Scene controlScene = new Scene(controlWindow, 350, 300);
        Stage controlStage = new Stage();
        controlStage.setOnHidden(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });
        controlStage.setTitle("Finestra di controllo");
        controlStage.setAlwaysOnTop(true);
        controlStage.setScene(controlScene);
        controlStage.setX(stage.getX() + stage.getWidth());
        controlStage.setY(stage.getY());
        controlStage.setResizable(false);
        controlStage.show();
    }

    /**
     * Main
     *
     * @param args Parametri passati da console
     */
    public static void main(String[] args) {
        launch(args);
    }
}
