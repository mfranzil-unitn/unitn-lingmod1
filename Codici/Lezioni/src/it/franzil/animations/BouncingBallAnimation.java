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

/**
 * @author ronchet
 */
public class BouncingBallAnimation extends Application {

    static int dx = 1;
    static int dy = 1;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle("Animation");
        Group root = new Group();
        Scene scene = new Scene(root, 400, 300, Color.WHITE);

        primaryStage.setScene(scene);
        addBouncyBall(scene);
        primaryStage.show();
    }

    private void addBouncyBall(final Scene scene) {
        final Circle ball = new Circle(100, 100, 20);

        final Group root = (Group) scene.getRoot();
        root.getChildren().add(ball);

        Timeline tl = new Timeline();
        tl.setCycleCount(Animation.INDEFINITE);
        KeyFrame moveBall = new KeyFrame(Duration.seconds(.0200),
                new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent event) {

                        double xMin = ball.getBoundsInParent().getMinX();
                        double yMin = ball.getBoundsInParent().getMinY();
                        double xMax = ball.getBoundsInParent().getMaxX();
                        double yMax = ball.getBoundsInParent().getMaxY();

                        if (xMin < 0 || xMax > scene.getWidth()) {
                            dx = dx * -1;
                        }
                        if (yMin < 0 || yMax > scene.getHeight()) {
                            dy = dy * -1;
                        }

                        ball.setTranslateX(ball.getTranslateX() + dx);
                        ball.setTranslateY(ball.getTranslateY() + dy);

                    }
                });

        tl.getKeyFrames().add(moveBall);
        tl.play();
    }
}