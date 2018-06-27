package esame200507;

import esame201107.Ics;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.Random;


public class Area extends Pane {

    private boolean xMode;

    public Area(TextField xCoord, TextField yCoord) {
        xMode = false;
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        setOnMouseClicked(event -> {
            if (xMode) {
                Ics ics = new Ics(10);
                ics.setFill(Color.rgb(new Random().nextInt(255),
                        new Random().nextInt(255),
                        new Random().nextInt(255)));
                ics.setLayoutX(event.getX());
                ics.setLayoutY(event.getY());
                getChildren().add(ics);
            }
        });

        addEventHandler(MouseEvent.ANY, e -> {
            xCoord.setText("" + e.getX());
            yCoord.setText("" + e.getY());
        });
    }


    public boolean isxMode() {
        return xMode;
    }

    public void setxMode(boolean xMode) {
        this.xMode = xMode;
    }
}
