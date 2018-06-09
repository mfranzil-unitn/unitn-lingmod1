package luca_201408;

import static luca_201408.Agosto_2014.punt;
import javafx.event.Event;
import javafx.event.EventHandler;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

class Dado {

    Circle c[] = new Circle[7];
    int val;
    int num;
    static int max_count = 0;
    Rectangle faccia;

    Dado(double posx, double posy, BorderPane root) {
        if (max_count < 5) {
            Random gen = new Random();
            setCircle(posx, posy);
            val = gen.nextInt(6) + 1;
            Agosto_2014.tot += val;
            Agosto_2014.updateTextTotale(Agosto_2014.tot);
            punt = punt - 3;
            Agosto_2014.updateTextScore(punt);
            faccia = new Rectangle(50, 50, Color.WHITE);
            root.getChildren().add(faccia);
            faccia.setOnMouseClicked(new EventHandler() {
                @Override
                public void handle(Event event) {
                    if (Agosto_2014.vittoria != true) {
                        removeDot(root);
                        Agosto_2014.tot -= val;
                        val = gen.nextInt(6) + 1;
                        Agosto_2014.tot += val;
                        setDot(root);
                        Agosto_2014.punt--;
                        Agosto_2014.updateTextTotale(Agosto_2014.tot);
                        Agosto_2014.updateTextScore(Agosto_2014.punt);
                    }
                }
            });
            faccia.setX(posx);
            faccia.setY(posy);
            setDot(root);
            max_count++;
            num = max_count;
        }
    }

    /**
     * Funzione che restituisce il valore di stampa di un dado.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Dado n." + num + " -  Val:" + val;
    }

    /**
     * Funzione che inserisce i pallini in una faccia di un dado.
     *
     * @param val
     * @param c
     * @param root
     */
    void setDot(BorderPane root) {
        switch (val) {
            case 1:
                root.getChildren().addAll(c[3]);
                break;
            case 2:
                root.getChildren().addAll(c[1], c[5]);
                break;
            case 3:
                root.getChildren().addAll(c[1], c[3], c[5]);
                break;
            case 4:
                root.getChildren().addAll(c[0], c[1], c[5], c[6]);
                break;
            case 5:
                root.getChildren().addAll(c[0], c[1], c[3], c[5], c[6]);
                break;
            case 6:
                root.getChildren().addAll(c[0], c[1], c[2], c[4], c[5], c[6]);
                break;
        }
    }

    /**
     * Funzione che inizializza i cerchi e le loro dimensioni principali.
     *
     * @param posx: ascissa di partenza del quadrato.
     * @param posy: ordinata di partenza del quadrato.
     */
    void setCircle(double posx, double posy) {
        c[0] = new Circle(posx + 12.5, posy + 12.5, 4, Color.BLACK);
        c[1] = new Circle(posx + 12.5, posy + 37.5, 4, Color.BLACK);
        c[2] = new Circle(posx + 25, posy + 12.5, 4, Color.BLACK);
        c[3] = new Circle(posx + 25, posy + 25, 4, Color.BLACK);
        c[4] = new Circle(posx + 25, posy + 37.5, 4, Color.BLACK);
        c[5] = new Circle(posx + 37.5, posy + 12.5, 4, Color.BLACK);
        c[6] = new Circle(posx + 37.5, posy + 37.5, 4, Color.BLACK);
        c[0].setMouseTransparent(true);
        c[1].setMouseTransparent(true);
        c[2].setMouseTransparent(true);
        c[3].setMouseTransparent(true);
        c[4].setMouseTransparent(true);
        c[5].setMouseTransparent(true);
        c[6].setMouseTransparent(true);
    }

    /**
     * Funzione che rimuove i pallini da una faccia di un dado.
     *
     * @param val: indica il valore del dado, in modo da sapere quale pallini
     * togliere.
     * @param c: vettore contenente tutti i cerchi.
     * @param root: BorderPane di base da cui rimuovere i pallini.
     */
    void removeDot(BorderPane root) {
        switch (val) {
            case 1:
                root.getChildren().removeAll(c[3]);
                break;
            case 2:
                root.getChildren().removeAll(c[1], c[5]);
                break;
            case 3:
                root.getChildren().removeAll(c[1], c[3], c[5]);
                break;
            case 4:
                root.getChildren().removeAll(c[0], c[1], c[5], c[6]);
                break;
            case 5:
                root.getChildren().removeAll(c[0], c[1], c[3], c[5], c[6]);
                break;
            case 6:
                root.getChildren().removeAll(c[0], c[1], c[2], c[4], c[5], c[6]);
                break;
        }
    }

    void moveDot() {
        switch (val) {
            case 1:
                c[3].setLayoutX(c[3].getLayoutX() + 4);
                break;
            case 2:
                c[1].setLayoutX(c[1].getLayoutX() + 4);
                c[5].setLayoutX(c[5].getLayoutX() + 4);
                break;
            case 3:
                c[1].setLayoutX(c[1].getLayoutX() + 4);
                c[5].setLayoutX(c[5].getLayoutX() + 4);
                c[3].setLayoutX(c[3].getLayoutX() + 4);
                break;
            case 4:
                c[1].setLayoutX(c[1].getLayoutX() + 4);
                c[5].setLayoutX(c[5].getLayoutX() + 4);
                c[0].setLayoutX(c[0].getLayoutX() + 4);
                c[6].setLayoutX(c[6].getLayoutX() + 4);
                break;
            case 5:
                c[1].setLayoutX(c[1].getLayoutX() + 4);
                c[5].setLayoutX(c[5].getLayoutX() + 4);
                c[0].setLayoutX(c[0].getLayoutX() + 4);
                c[6].setLayoutX(c[6].getLayoutX() + 4);
                c[3].setLayoutX(c[3].getLayoutX() + 4);
                break;
            case 6:
                c[1].setLayoutX(c[1].getLayoutX() + 4);
                c[5].setLayoutX(c[5].getLayoutX() + 4);
                c[0].setLayoutX(c[0].getLayoutX() + 4);
                c[6].setLayoutX(c[6].getLayoutX() + 4);
                c[2].setLayoutX(c[2].getLayoutX() + 4);
                c[4].setLayoutX(c[4].getLayoutX() + 4);
                break;
        }
    }

    void cancelDot() {
        switch (val) {
            case 1:
                c[3].setOpacity(c[3].getOpacity() - 0.005);
                break;
            case 2:
                c[1].setOpacity(c[1].getOpacity() - 0.005);
                c[5].setOpacity(c[5].getOpacity() - 0.005);
                break;
            case 3:
                c[1].setOpacity(c[1].getOpacity() - 0.005);
                c[5].setOpacity(c[5].getOpacity() - 0.005);
                c[3].setOpacity(c[3].getOpacity() - 0.005);
                break;
            case 4:
                c[1].setOpacity(c[1].getOpacity() - 0.005);
                c[5].setOpacity(c[5].getOpacity() - 0.005);
                c[0].setOpacity(c[0].getOpacity() - 0.005);
                c[6].setOpacity(c[6].getOpacity() - 0.005);
                break;
            case 5:
                c[1].setOpacity(c[1].getOpacity() - 0.005);
                c[5].setOpacity(c[5].getOpacity() - 0.005);
                c[0].setOpacity(c[0].getOpacity() - 0.005);
                c[6].setOpacity(c[6].getOpacity() - 0.005);
                c[3].setOpacity(c[3].getOpacity() - 0.005);
                break;
            case 6:
                c[1].setOpacity(c[1].getOpacity() - 0.005);
                c[5].setOpacity(c[5].getOpacity() - 0.005);
                c[0].setOpacity(c[0].getOpacity() - 0.005);
                c[6].setOpacity(c[6].getOpacity() - 0.005);
                c[2].setOpacity(c[2].getOpacity() - 0.005);
                c[4].setOpacity(c[4].getOpacity() - 0.005);
                break;
        }
    }

    void movement(BorderPane root) {
        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(8), new EventHandler() {
            @Override
            public void handle(Event event) {
                faccia.setLayoutX(faccia.getLayoutX() + 4);
                moveDot();
            }
        }));
        loop.setCycleCount(100);
        loop.play();
        loop.setOnFinished(new EventHandler() {
            @Override
            public void handle(Event event) {
                root.getChildren().remove(faccia);
                removeDot(root);
            }
        });
    }

    void disappear(BorderPane root) {
        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(8), new EventHandler() {
            @Override
            public void handle(Event event) {
                faccia.setOpacity(faccia.getOpacity() - 0.005);
                cancelDot();
            }
        }));
        loop.setCycleCount(200);
        loop.play();
        loop.setOnFinished(new EventHandler() {
            @Override
            public void handle(Event event) {
                root.getChildren().remove(faccia);
                removeDot(root);
            }
        });

    }
}
