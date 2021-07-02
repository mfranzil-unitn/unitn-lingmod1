package it.franzil.animations;

import javafx.animation.Animation;
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

public class BallAnimation2 extends Application {

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

        final Timeline tl = new Timeline();
        tl.setCycleCount(Animation.INDEFINITE);
        KeyFrame moveBall = new KeyFrame(Duration.seconds(frameDuration), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                double scale = ball.getScaleX();
                if (scale > 1.5) {
                    ball.setFill(Color.RED);
                    ball.setOpacity(ball.getOpacity() - 0.005);
                }
                if (scale > 2) {
                    ball.setVisible(!ball.isVisible());
                }
                if (scale > 2.5) {
                    ball.setVisible(false);
                    tl.stop();
                }
                ball.setScaleX(scale + 0.01);
                //ball.setCenterX(ball.getCenterX() + 2*dx);
                ball.setLayoutX(ball.getLayoutX() + 1 * dx);
                //ball.setTranslateX(ball.getTranslateX() + 1*dx);
                ball.setTranslateY(ball.getTranslateY() + 1 * dy);
            }
        });

        tl.getKeyFrames().add(moveBall);
        tl.play();
    }

}
