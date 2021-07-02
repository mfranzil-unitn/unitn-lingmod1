/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201806;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Classe principale del programma. Al suo interno vi è un BorderPane contenente
 * una HanoiArea al centro (dove verranno disegnati i pali con i dischi),
 * quattro bottoni per rispettivamente chiudere i popup, resettare lo stato del
 * programma, muovere i dischi e cancellare la selezione dei pali, e due
 * PaloText che rappresentano i pali selezionati.
 *
 * @author Matteo Franzil - 192198
 */
public class Main extends Application {

    private Button close, reset, move, clear, animaz;
    private PaloText from, to;
    private HanoiArea area;
    private Thread thread;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        FlowPane up = new FlowPane();
        from = new PaloText(true);
        to = new PaloText(false);
        clear = new Button("Clear");
        animaz = new Button("Direct movement");
        up.setAlignment(Pos.CENTER);
        up.setHgap(40);
        up.getChildren().addAll(from, to, clear, animaz);

        close = new Button("Close");
        reset = new Button("Reset");
        move = new Button("Move");
        area = new HanoiArea(from, to, close);

        close.setDisable(true);

        root.setTop(up);
        root.setLeft(close);
        root.setRight(reset);
        root.setBottom(move);
        root.setCenter(area);

        BorderPane.setAlignment(up, Pos.TOP_CENTER);
        BorderPane.setAlignment(close, Pos.CENTER_LEFT);
        BorderPane.setAlignment(reset, Pos.CENTER_RIGHT);
        BorderPane.setAlignment(move, Pos.BOTTOM_CENTER);

        clear.setOnAction(e -> {
            from.setEmpty();
            to.setEmpty();
        });

        move.setOnAction(e -> area.moveDisco(from, to));
        animaz.setOnAction(e -> {
            if (!area.isAnimationOn()) {
                area.setAnimationOn(true);
                animaz.setText("Animation");
            } else {
                area.setAnimationOn(false);
                animaz.setText("Direct movement");
            }
        });

        reset.setOnAction(e -> {
            clear.fire();
            area.reset();
        });

        close.setOnAction(e -> area.closeAlert());

        Scene scene = new Scene(root);

        root.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            switch (e.getCode()) {
                case DIGIT1:
                    area.manualPaloSet(0, from, to);
                    break;
                case DIGIT2:
                    area.manualPaloSet(1, from, to);
                    break;
                case DIGIT3:
                    area.manualPaloSet(2, from, to);
                    break;
                case M:
                    move.fire();
                    break;
                case A:
                    animaz.fire();
                    break;
                case C:
                    clear.fire();
                    break;
                case R:
                    reset.fire();
                    break;
                case O:
                    area.solve(HanoiArea.NUMERO_DISCHI, area.getPali().get(0),
                            area.getPali().get(2), area.getPali().get(1), from, to);
                default:
                    break;
            }
        });

        // primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.setTitle("Torre di Hanoi");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
