/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201601;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.LinkedList;

/**
 * @author Matteo Franzil
 */
public class Main extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        GridPane root = new GridPane();
        Scene scene = new Scene(root);

        PannelloGrafico graphicRoot = new PannelloGrafico();

        Text backgroundTxt = new Text("Sfondo: ");
        Text c1Txt = new Text("C1: ");
        Text c2Txt = new Text("C2: ");
        Text size = new Text("Grandezza: ");
        GridPane.setConstraints(backgroundTxt, 0, 0);
        GridPane.setConstraints(c1Txt, 0, 1);
        GridPane.setConstraints(c2Txt, 0, 2);
        GridPane.setConstraints(size, 0, 3);

        ColorPicker background = new ColorPicker();
        background.setOnAction((ActionEvent t) -> {
            Color c = background.getValue();
            graphicRoot.setBackground(new Background(new BackgroundFill(c, CornerRadii.EMPTY, Insets.EMPTY)));
        });
        GridPane.setConstraints(background, 1, 0);

        ColorPicker setC1 = new ColorPicker();
        setC1.setOnAction((ActionEvent t) -> {
            Color c = setC1.getValue();
            graphicRoot.setC1(c);
        });
        GridPane.setConstraints(setC1, 1, 1);

        ColorPicker setC2 = new ColorPicker();
        setC2.setOnAction((ActionEvent t) -> {
            Color c = setC2.getValue();
            graphicRoot.setC2(c);
        });
        GridPane.setConstraints(setC2, 1, 2);

        Slider setSize = new Slider(4, 100, 20);
        setSize.setShowTickMarks(true);
        setSize.setShowTickLabels(true);
        setSize.addEventHandler(MouseEvent.ANY, (MouseEvent e) -> {
            graphicRoot.setSize(setSize.getValue());
        });
        GridPane.setConstraints(setSize, 1, 3, 1, 2);

        Button clear = new Button("Cancella");
        Button clearLast = new Button("Cancella ultimo");
        Button clearFirst = new Button("Cancella primo");
        Button print = new Button("Stampa");

        GridPane.setConstraints(clear, 2, 0);
        GridPane.setConstraints(clearLast, 2, 1);
        GridPane.setConstraints(clearFirst, 2, 2);
        GridPane.setConstraints(print, 2, 3);

        clear.setOnAction((ActionEvent e) -> {
            graphicRoot.clear();
        });

        clearLast.setOnAction((ActionEvent e) -> {
            graphicRoot.clearLast();
        });

        clearFirst.setOnAction((ActionEvent e) -> {
            graphicRoot.clearFirst();
        });

        print.setOnAction((ActionEvent e) -> {
            Stage printStage = new Stage();
            StackPane printPane = new StackPane();
            Scene printScene = new Scene(printPane);
            TextArea txt = new TextArea();
            LinkedList<Shape> figure = graphicRoot.getFigure();
            for (Shape a : figure) {
                if (a instanceof Cerchio) {
                    txt.appendText("Cerchio con coordinate " + ((Cerchio) a).getCenterX() + ", " + ((Cerchio) a).getCenterY());
                } else if (a instanceof Rombo) {
                    txt.appendText("Rombo con coordinate " + ((Rombo) a).getX() + ", " + ((Rombo) a).getY());
                } else {
                    txt.appendText("Quadrato con coordinate " + ((Quadrato) a).getX() + ", " + ((Quadrato) a).getY());
                }
                txt.appendText("\n");
            }
            txt.setEditable(false);
            printPane.getChildren().add(txt);
            printStage.setTitle("Stampa");
            printStage.setScene(printScene);
            printStage.show();
        });

        scene.setOnKeyPressed((KeyEvent e) -> {
            switch (e.getCode()) {
                case C:
                    clear.fire();
                    break;
                case L:
                    clearLast.fire();
                    break;
                case F:
                    clearFirst.fire();
                    break;
                default:
                    break;
            }
        });

        root.getChildren().addAll(setC1, setC2, background, setSize,
                c1Txt, c2Txt, backgroundTxt, size, clear, clearLast, clearFirst, print);

        root.setPadding(new Insets(12, 15, 15, 12));
        root.setHgap(10);
        root.setVgap(10);
        primaryStage.setTitle("Comandi");
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest((WindowEvent e) -> {
            Platform.exit();
        });
        primaryStage.show();
    }

}
