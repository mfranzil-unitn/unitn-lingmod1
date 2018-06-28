package esame201607;

import esame201607.views.Girone;
import esame201607.views.Partita;
import esame201607.views.Risultato;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Controls extends Stage {

    private Circle ball;
    private List<Squadra> squadreAmmesse;

    Controls(List<Girone> gironi, List<Squadra> squadre) {
        GridPane root = new GridPane();

        root.setPadding(new Insets(20, 20, 20, 20));
        root.setVgap(10);
        root.setHgap(10);

        Pane ballSpace = new Pane();
        ballSpace.setPrefSize(300, 300);
        ball = new Circle(50, 260, 30, Color.LIGHTBLUE);
        ballSpace.getChildren().add(ball);

        Button giornata1 = new Button("1a giornata");
        Button giornata2 = new Button("2a giornata");
        Button giornata3 = new Button("3a giornata");

        Button quarti = new Button("Quarti");
        Button semifinali = new Button("Semifinale");
        Button finale = new Button("Finale");

        giornata2.setDisable(true);
        giornata3.setDisable(true);
        quarti.setDisable(true);
        semifinali.setDisable(true);
        finale.setDisable(true);

        giornata1.setOnAction(e -> gironi.forEach(g -> {
            PathTransition pt = animateBall();
            pt.setOnFinished(f -> {
                g.calcola(1);
                giornata1.setDisable(true);
                giornata2.setDisable(false);
            });
            pt.play();
        }));

        giornata2.setOnAction(e -> gironi.forEach(g -> {
            PathTransition pt = animateBall();
            pt.setOnFinished(f -> {
                g.calcola(2);
                giornata2.setDisable(true);
                giornata3.setDisable(false);
            });
            pt.play();
        }));

        giornata3.setOnAction(e -> gironi.forEach(g -> {
            PathTransition pt = animateBall();
            pt.setOnFinished(f -> {
                g.calcola(3);
                giornata3.setDisable(true);
                quarti.setDisable(false);
            });
            pt.play();
        }));

        quarti.setOnAction(e -> {
            PathTransition pt = animateBall();
            pt.setOnFinished(g -> {
                System.out.println("\nQUARTI");
                List<Partita> partite = svolgiQuarti(gironi);
                squadreAmmesse = new LinkedList<>();

                partite.forEach(f -> {
                    Risultato<Integer, Integer> ris = f.calcola(false);
                    squadreAmmesse.add(f.getVincente());
                    System.out.println(f);
                });

                quarti.setDisable(true);
                semifinali.setDisable(false);
            });
            pt.play();
        });

        semifinali.setOnAction(e -> {
            PathTransition pt = animateBall();
            pt.setOnFinished(g -> {
                System.out.println("\nSEMIFINALI");
                List<Partita> partite = svolgiSemifinali(squadreAmmesse);
                squadreAmmesse = new LinkedList<>();

                partite.forEach(f -> {
                    Risultato<Integer, Integer> ris = f.calcola(false);
                    squadreAmmesse.add(f.getVincente());
                    System.out.println(f);
                });

                semifinali.setDisable(true);
                finale.setDisable(false);
            });
            pt.play();
        });

        finale.setOnAction(e -> {
            semifinali.setDisable(true);
            Partita finalissima = new Partita(squadreAmmesse.get(0), squadreAmmesse.get(1));
            Risultato<Integer, Integer> ris = finalissima.calcola(false);
            PathTransition pt = animateBall();

            pt.setOnFinished(g -> {
                System.out.println("\nFINALE");
                System.out.println(finalissima);
                finale.setDisable(true);
            });
            pt.play();

            Alert alert = new Alert(Alert.AlertType.INFORMATION,
                    "VINCE L'EUROPEO: " + (finalissima.getVincente()),
                    ButtonType.OK);
            alert.showAndWait().ifPresent(h -> Platform.exit());
            Platform.exit();
        });

        root.add(ballSpace, 0, 0, 3, 1);
        root.add(giornata1, 0, 1);
        root.add(giornata2, 1, 1);
        root.add(giornata3, 2, 1);
        root.add(quarti, 0, 2);
        root.add(semifinali, 1, 2);
        root.add(finale, 2, 2);

        Scene scene = new Scene(root);
        setScene(scene);
        setTitle("Controlli");
        setOnCloseRequest(e -> Platform.exit());
    }

    public List<Partita> svolgiQuarti(List<Girone> g) {
        Partita q1 = new Partita(g.get(0).getQualificate().get(0),
                g.get(3).getQualificate().get(1));
        Partita q2 = new Partita(g.get(1).getQualificate().get(0),
                g.get(2).getQualificate().get(1));
        Partita q3 = new Partita(g.get(2).getQualificate().get(0),
                g.get(1).getQualificate().get(1));
        Partita q4 = new Partita(g.get(3).getQualificate().get(0),
                g.get(0).getQualificate().get(1));
        return Arrays.asList(q1, q2, q3, q4);

    }

    public List<Partita> svolgiSemifinali(List<Squadra> s) {
        Partita s1 = new Partita(s.get(0), s.get(3));
        Partita s2 = new Partita(s.get(1), s.get(2));
        return Arrays.asList(s1, s2);
    }

    public PathTransition animateBall() {
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(2000));

        Path path = new Path();
        MoveTo moveTo = new MoveTo();
        moveTo.setX(ball.getCenterX());
        moveTo.setY(ball.getCenterY());

        QuadCurveTo curve1 = new QuadCurveTo();
        // Setto i punti di controllo sopra i due pali
        curve1.setControlX(ball.getCenterX() * 3 / 2);
        curve1.setControlY(-10);

        curve1.setX(ball.getCenterX() * 2);
        curve1.setY(260);

        QuadCurveTo curve2 = new QuadCurveTo();
        // Setto i punti di controllo sopra i due pali
        curve2.setControlX(ball.getCenterX() * 5 / 2);
        curve2.setControlY(30);

        curve2.setX(ball.getCenterX() * 3);
        curve2.setY(260);

        QuadCurveTo curve3 = new QuadCurveTo();
        // Setto i punti di controllo sopra i due pali
        curve3.setControlX(ball.getCenterX() * 7 / 2);
        curve3.setControlY(70);

        curve3.setX(ball.getCenterX() * 4);
        curve3.setY(260);

        QuadCurveTo curve4 = new QuadCurveTo();
        // Setto i punti di controllo sopra i due pali
        curve4.setControlX(ball.getCenterX() * 9 / 2);
        curve4.setControlY(120);

        curve4.setX(ball.getCenterX() * 5);
        curve4.setY(260);

        path.getElements().addAll(moveTo, curve1, curve2, curve3, curve4);

        pathTransition.setPath(path);
        pathTransition.setNode(ball);
        return pathTransition;
    }
}
