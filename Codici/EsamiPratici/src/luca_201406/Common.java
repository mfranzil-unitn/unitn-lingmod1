package luca_201406;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author lucamartinelli
 */
public class Common extends Application {

    Dati d;
    Comandi a;
    Grafica b;
    Group finestre;
    Figura figure[] = new Figura[400];
    static int raggio = 5;
    static int int_forma = 0;
    static int dim;
    double lastx;
    static int min = 0;
    static int max = 0;

    @Override
    public void start(Stage primaryStage) {

        a = new Comandi();
        b = new Grafica();

        a.primarystage.setOnCloseRequest(new EventHandler() {
            @Override
            public void handle(Event event) {
                b.secondstage.close();
            }
        });

        a.clearall.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (int i = 0; i < max; i++) {
                    b.root.getChildren().remove(figure[i].forma);
                    figure[i].x = 0;
                    figure[i].y = 0;
                }
                min = 0;
                max = 0;
            }
        });
        a.clearlast.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                b.root.getChildren().remove(figure[max - 1].forma);
                figure[max - 1].x = 0;
                figure[max - 1].y = 0;
                max--;
            }
        });
        a.clearfirst.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                b.root.getChildren().remove(figure[min].forma);
                figure[min].x = 0;
                figure[min].x = 0;
                min++;
            }
        });

        a.primarystage.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case C:
                        a.clearall.fireEvent(new ActionEvent());
                        break;
                    case F:
                        a.clearfirst.fireEvent(new ActionEvent());
                        break;
                    case L:
                        a.clearlast.fireEvent(new ActionEvent());
                        break;
                }

            }
        });

        b.secondstage.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case C:
                        a.clearall.fireEvent(new ActionEvent());
                        break;
                    case F:
                        a.clearfirst.fireEvent(new ActionEvent());
                        break;
                    case L:
                        a.clearlast.fireEvent(new ActionEvent());
                        break;
                }

            }

        });

        a.print.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stampa();
            }
        });

        a.colorpane.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                b.square.setFill(a.colorpane.getValue());
            }
        });

        b.square.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                creafigura(event.getX(), event.getY());
                max++;

            }
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void creafigura(Double paramx, Double paramy) {
        dim = Integer.parseInt(a.scale.getText());
        figure[max] = new Figura(paramx, paramy);
        switch (int_forma) {
            case 0:
                figure[max].forma = new Circle(paramx, paramy, dim / 2);
                set_color(paramx);
                b.root.getChildren().add(figure[max].forma);
                break;
            case 1:
                figure[max].forma = new Rectangle(paramx, paramy, dim, dim);
                set_color(paramx);
                b.root.getChildren().add(figure[max].forma);
                break;
            case 2:
                figure[max].forma = new Rectangle(paramx, paramy, dim, dim);
                set_color(paramx);
                figure[max].forma.setRotate(45);
                b.root.getChildren().add(figure[max].forma);
                break;
        }
        int_forma = (int_forma + 1) % 3;
    }

    public void set_color(Double posx) {
        if (max == 0) {
            figure[max].forma.setFill(Color.BLACK);
        } else if (posx < lastx) {
            figure[max].forma.setFill(a.c2.getValue());
        } else {
            figure[max].forma.setFill(a.c1.getValue());
        }
        lastx = posx;
    }

    public void stampa() {
        d = new Dati(min, max, figure);
    }
}
