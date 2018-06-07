package it.franzil.javafx.test;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author matte
 */
public class CanvasTest extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Canvas canv = new Canvas(700, 700);
        GraphicsContext gc = canv.getGraphicsContext2D();

        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(100, 100, 40, 40, 30, 240, ArcType.OPEN);
        gc.setFont(new Font("Tahoma", 50));
        gc.fillText("Prova", 100, 100);
        /*gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40}, new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90}, new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140}, new double[]{210, 210, 240, 240}, 4);*/

        canv.addEventHandler(TouchEvent.TOUCH_MOVED, (TouchEvent e) -> {
            if (e.isAltDown() && e.isControlDown()) {
                gc.clearRect(e.getTouchPoint().getX() - 2, e.getTouchPoint().getY() - 2, 15, 15);
            }
        });

        canv.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent t) -> {
            if (t.getClickCount() > 1) {
                reset(canv, Color.BLUE);
            }
        });
        
        canv.addEventHandler(Event.ANY, new EventEcho(this));
                
                


        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Carica un'immagine");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        // fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File file = fileChooser.showOpenDialog(primaryStage);
        if (file == null) {
            System.out.println("No file chosen");
            System.exit(1);
        }
        Image image = new Image("file:///" + file.getCanonicalPath(), 500, 500, true, true);
        System.out.println(file.getAbsolutePath());
        ImageView iw = new ImageView(image);

        gc.drawImage(image, 0, 0);

        StackPane root = new StackPane();
        Scene scene = new Scene(root);
        root.getChildren().addAll(canv);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void reset(Canvas canvas, Color color) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

}
