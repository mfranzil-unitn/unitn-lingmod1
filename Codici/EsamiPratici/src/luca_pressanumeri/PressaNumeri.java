package luca_pressanumeri;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class PressaNumeri extends Application {

    Button bottoni[] = new Button[9];
    boolean vivo[] = new boolean[9];

    @Override
    public void start(Stage primaryStage) {
        setButtons(bottoni);
        TilePane root = new TilePane();
        root.setPrefRows(3);
        root.setPrefColumns(3);
        for (int i = 0; i < 9; i++) {
            root.getChildren().add(bottoni[i]);
        }
        EventHandler<KeyEvent> pressato = new EventHandler<KeyEvent>() {
            //KeyEvent è generics, questo permette di farmi il cast direttamente
            //evitando di farlo nella funzione handle
            @Override
            public void handle(KeyEvent event) {
                int i = Integer.parseInt(event.getText());
                if (vivo[i] == true) {
                    eliminateButton(bottoni, i, root, vivo);
                } else {
                    ripristinaButton(bottoni, i, root, vivo);
                }
            }

        };
        Scene scena = new Scene(root);
        primaryStage.setScene(scena);
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, pressato);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    void setButtons(Button bottoni[]) {
        for (int i = 0; i < 9; i++) {
            bottoni[i] = new Button("" + i);
            bottoni[i].setPrefSize(100, 100);
            vivo[i] = true;
        }
    }

    void eliminateButton(Button bottoni[], int i, TilePane root, boolean vivo[]) {
        bottoni[i].setVisible(false);
        //root.getChildren().remove(bottoni[i]);
        vivo[i] = false;
    }

    void ripristinaButton(Button bottoni[], int i, TilePane root, boolean vivo[]) {
        bottoni[i].setVisible(true);
        //root.getChildren().add(bottoni[i]);
        vivo[i] = true;
    }
    /*
    campo.setOnMouseClicked(new EventHandler(){
            @Override
            public void handle(Event event) {
                if(Dado.MAX_COUNT<5){
                posx = ((MouseEvent)event).getX();
                posy = ((MouseEvent)event).getY();
                }
            }
     */

}
