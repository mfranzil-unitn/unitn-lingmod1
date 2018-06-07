package it.unitn.disi.prog2.javaFXAnimationDemos;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BallAnimation3 extends Application {

    int dx = 1;
    int dy = 1;
    double frameDuration = 0.05;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle("Animation");
        Group root = new Group();
        Scene scene = new Scene(root, 400, 300, Color.WHITE);

        primaryStage.setScene(scene);
        addBall(scene);
        primaryStage.show();
    }

    private void addBall(final Scene scene) {
        final Circle ball = new Circle(50, 50, 20);

        final Group root = (Group) scene.getRoot();
        root.getChildren().add(ball);

        Timeline tl = new Timeline();

        tl.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, // set start position at 0
                        new KeyValue(ball.translateXProperty(), 0),
                        new KeyValue(ball.translateYProperty(), 0)),
                new KeyFrame(new Duration(1000), // set end position at 4s
                        new KeyValue(ball.translateXProperty(), 200),
                        new KeyValue(ball.translateYProperty(), 100)),
                new KeyFrame(new Duration(4000), // set end position at 4s
                        new KeyValue(ball.translateXProperty(), 200),
                        new KeyValue(ball.translateYProperty(), 0))
        );

        tl.play();
    }
}
