package it.franzil.animations;

import javafx.animation.KeyFrame;
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


public class BallAnimation1 extends Application {

    int dx = 4;
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
        primaryStage.show();
        addBall(scene);
    }

    private void addBall(final Scene scene) {
        final Circle ball = new Circle(50, 50, 20);

        final Group root = (Group) scene.getRoot();
        root.getChildren().add(ball);

        Timeline tl = new Timeline();
        tl.setCycleCount(10);//Animation.INDEFINITE);//100);
        KeyFrame moveBall = new KeyFrame(Duration.seconds(frameDuration),
                new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent event) {

                        ball.setTranslateX(ball.getTranslateX() + 2 * dx);
                        ball.setTranslateY(ball.getTranslateY() + 0 * dy);

                    }
                });

        tl.getKeyFrames().add(moveBall);
        tl.play();
    }
}