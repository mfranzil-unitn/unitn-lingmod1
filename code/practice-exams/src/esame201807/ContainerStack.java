package esame201807;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.util.Iterator;
import java.util.LinkedList;

public class ContainerStack extends VBox {

    public static final int N = 5;

    private LinkedList<CellContainer> celle;

    public ContainerStack() {
        celle = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            CellContainer temp = new CellContainer();
            celle.add(temp);
            getChildren().add(temp);
        }
    }

    public void push(Shape shape) {
        if (getFirstEmpty() == -1) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Stack pieno!");
            alert.showAndWait();
        } else {
            celle.get(getFirstEmpty()).setFigura(shape);
        }
    }

    public void popTop() {
        if (getLastFull() == -1) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Stack vuoto!");
            alert.showAndWait();
        } else {
            Node temp = celle.get(getLastFull()).getFigura();

            FadeTransition ft = new FadeTransition();
            ft.setFromValue(1.0);
            ft.setToValue(0.0);
            ft.setDuration(Duration.seconds(1));
            ft.setNode(temp);
            ft.setOnFinished(e -> celle.get(getLastFull()).removeFigura());
            ft.play();
        }
    }

    public void popBottom() {
        if (getFirstFull() == -1) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Stack vuoto!");
            alert.showAndWait();
        } else {
            Node temp = celle.get(getFirstFull()).getFigura();

            FadeTransition ft = new FadeTransition();
            ft.setFromValue(1.0);
            ft.setToValue(0.0);
            ft.setDuration(Duration.seconds(1));
            ft.setNode(temp);
            ft.setOnFinished(e -> {
                celle.get(getFirstFull()).removeFigura();
                moveShapes();
            });
            ft.play();
        }
    }

    public void print() {
        String s = "";
        for (CellContainer aCelle : celle) {
            s += aCelle.toString() + " ";
        }
        new Alert(Alert.AlertType.INFORMATION, s).showAndWait();
    }

    private void moveShapes() {
        for (int i = celle.size() - 1; i > 0; i--) {
            try {
                celle.get(i).setFigura(celle.get(i - 1).getFigura());
            } catch (NullPointerException ex) {
                System.err.println("Writing an empty shape!");
            }
        }
        celle.get(0).removeFigura();
    }

    private int getFirstEmpty() {
        Iterator<CellContainer> it = celle.descendingIterator();
        int i = celle.size();
        while (it.hasNext()) {
            CellContainer temp = it.next();
            if (temp.getFigura() == null) {
                return i - 1;
            }
            i--;
        }
        return -1;
    }

    private int getFirstFull() {
        Iterator<CellContainer> it = celle.descendingIterator();
        int i = celle.size();
        while (it.hasNext()) {
            CellContainer temp = it.next();
            if (temp.getFigura() != null) {
                return i - 1;
            }
            i--;
        }
        return -1;
    }

    private int getLastEmpty() {
        Iterator<CellContainer> it = celle.iterator();
        int i = 0;
        while (it.hasNext()) {
            CellContainer temp = it.next();
            if (temp.getFigura() == null) {
                return i;
            }
            i++;
        }
        return -1;
    }


    private int getLastFull() {
        Iterator<CellContainer> it = celle.iterator();
        int i = 0;
        while (it.hasNext()) {
            CellContainer temp = it.next();
            if (temp.getFigura() != null) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
