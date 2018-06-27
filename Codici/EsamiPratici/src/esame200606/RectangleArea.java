package esame200606;

import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleArea extends Pane {

    public static final int DIM = 10;
    private Rectangle yellowRect, blueRect;
    private boolean blueSelected;

    public RectangleArea() {
        blueSelected = false;
    }

    public void redraw(int x_yellow_coord, int y_yellow_coord,
                       int x_blue_coord, int y_blue_coord) {
        getChildren().clear();
        yellowRect = new Rectangle(x_yellow_coord, y_yellow_coord, Color.ORANGE);
        blueRect = new Rectangle(x_blue_coord, y_blue_coord, Color.BLUE);

        yellowRect.setOpacity(0.5);
        blueRect.setOpacity(0.5);

        yellowRect.setX(0);
        yellowRect.setY(0);

        blueRect.setX(this.getWidth() - blueRect.getWidth());
        blueRect.setY(this.getHeight() - blueRect.getHeight());

        getChildren().addAll(yellowRect, blueRect);
    }

    public void setBlueSelected(boolean blueSelected) {
        this.blueSelected = blueSelected;
    }

    public boolean isBlueSelected() {
        return blueSelected;
    }

    public void move(boolean isBlue, int direction) {
        Rectangle rect;
        if (isBlue) {
            rect = blueRect;
        } else {
            rect = yellowRect;
        }

        switch(direction) {
            case 0:
                rect.setTranslateX(rect.getTranslateX() + DIM);
                break;
            case 1:
                rect.setTranslateX(rect.getTranslateX() - DIM);
                break;
            case 2:
                rect.setTranslateY(rect.getTranslateY() - DIM);
                break;
            case 3:
                rect.setTranslateY(rect.getTranslateY() + DIM);
                break;
            default:
                break;
        }
    }
}
