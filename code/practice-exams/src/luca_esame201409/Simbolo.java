package luca_esame201409;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Simbolo extends javafx.scene.Group {

    public Simbolo(EventHandler simbolListener, int type) {

        addEventFilter(MouseEvent.MOUSE_CLICKED, simbolListener);

        this.setId("" + type);
        Shape tmp = null;
        switch (type) {
            case 0:
                tmp = new MyHexagon(Color.GREEN);
                break;
            case 1:
                tmp = new MyTriangle(Color.BLUE);
                break;
            case 2:
                tmp = new MyRect(Color.ORANGE);
                break;
            case 3:
                tmp = new MyCircle(Color.RED);
                break;
            case 4:
                tmp = new MyTriangle(Color.PURPLE);
                break;
            case 5:
                tmp = new MyHexagon(Color.YELLOW);
                break;
        }
        // ======== enclosing rectangle
        Rectangle rect = new Rectangle(130, 130);
        rect.setFill(Color.WHITE);
        rect.setStrokeWidth(7);
        rect.setStroke(Color.BLACK);
        // ======== put things together
        getChildren().addAll(rect, tmp);
    }

    //========== Classi interne di servizio =====================================
    private class MyCircle extends Circle {

        MyCircle(Color color) {
            super(35);
            System.out.println(color);
            setFill(color);
            setLayoutX(65);
            setLayoutY(65);
            setStroke(Color.BLACK);
            //setOpacity(1);
        }
    }

    private class MyRect extends Rectangle {

        MyRect(Color color) {
            super(70, 70);
            setFill(color);
            setLayoutX(30);
            setLayoutY(30);
            setStroke(Color.BLACK);
            //setOpacity(0);
        }
    }

    private class MyTriangle extends Polygon {

        MyTriangle(Color color) {
            super(35.0, 0.0, 0.0, 70.0, 70.0, 70.0);
            setFill(color);
            setLayoutX(30);
            setLayoutY(30);
            setStroke(Color.BLACK);
            //setOpacity(0);
        }
    }

    private class MyHexagon extends Polygon {

        MyHexagon(Color color) {
            //super(35.0,10.0,  60.0,25.0,  60.0,55.0,  35.0,70.0,  10.0,55.0,  10.0,25.0 ); 
            super(35.0, 2.0, 68.0, 20.0, 68.0, 53.0, 35.0, 70.0, 2.0, 53.0, 2.0, 20.0);
            setFill(color);
            setLayoutX(30);
            setLayoutY(30);
            setStroke(Color.BLACK);
            //setOpacity(0);
        }
    }
}
