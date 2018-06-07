/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.franzil.dadi;

import java.util.LinkedList;
import java.util.Random;
import javafx.animation.ScaleTransition;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author Matteo Franzil
 */
public class Dado extends Rectangle {

    final static int SIZE = 30;
    int value;
    LinkedList<Circle> punti;

    public Dado(double x, double y, Group parent, Dadi main) {
        this.setX(x - SIZE / 2);
        this.setY(y - SIZE / 2);
        this.setWidth(SIZE);
        this.setHeight(SIZE);
        value = setRandValue();
        punti = drawNumber();
        parent.getChildren().add(this);
        parent.getChildren().addAll(punti);
        setStroke(Paint.valueOf("BLACK"));
        setFill(Paint.valueOf("WHITE"));

        addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            main.counter--;

            for (int i = 0; i < parent.getChildren().size(); i++) {
                Node temp = parent.getChildren().get(i);
                System.out.println(temp);
                if (temp == this) {
                    for (int j = 0; j < parent.getChildren().size(); j++) {
                        Node circletemp = parent.getChildren().get(j);
                        if (circletemp instanceof Circle && punti.contains(circletemp)) {
                            parent.getChildren().remove(j);
                        }
                    }
                    break;
                }
            }

            main.contatore.setText("Contatore: " + main.counter);
            value = setRandValue();
            System.out.println("New value: " + value);
            punti = drawNumber();

            this.toFront();
            parent.getChildren().addAll(punti);
        }
        );
    }

    public int setRandValue() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    public void moveAway() {
        ScaleTransition st = new ScaleTransition(Duration.millis(20000), this);
        st.setFromX(this.getX());
        st.setFromY(this.getY());

        st.setToX(10 * Math.random());
        st.setToY(10 * Math.random());
        st.play();

    }

    public void dissolve() {
        setOpacity(0.3);/*
        FadeTransition ft = new FadeTransition(Duration.millis(2000), this);
        ft.setFromValue(1.0f);
        ft.setToValue(0.3f);
        ft.setCycleCount(2);
        ft.setAutoReverse(true);

        ft.play();*/
    }

    private LinkedList<Circle> drawNumber() {
        LinkedList<Circle> list = new LinkedList<>();
        switch (value) {

            case 1:
                list.add(new Circle(this.getX() + SIZE / 2, this.getY() + SIZE / 2, SIZE / 7)); // punto centrale
                break;
            case 2:
                list.add(new Circle(this.getX() + SIZE / 6, this.getY() + SIZE / 6, SIZE / 7)); // alto a sinistra
                list.add(new Circle(this.getX() + (5 * SIZE / 6), this.getY() + (5 * SIZE / 6), SIZE / 7)); // basso a destra
                break;
            case 3:
                list.add(new Circle(this.getX() + SIZE / 6, this.getY() + SIZE / 6, SIZE / 7)); // alto a sinistra
                list.add(new Circle(this.getX() + (5 * SIZE / 6), this.getY() + (5 * SIZE / 6), SIZE / 7)); // basso a destra
                list.add(new Circle(this.getX() + SIZE / 2, this.getY() + SIZE / 2, SIZE / 7)); // punto centrale
                break;
            case 4:
                list.add(new Circle(this.getX() + SIZE / 6, this.getY() + (5 * SIZE / 6), SIZE / 7)); // alto a destra
                list.add(new Circle(this.getX() + (5 * SIZE / 6), this.getY() + SIZE / 6, SIZE / 7)); // basso a sinistra
                list.add(new Circle(this.getX() + SIZE / 6, this.getY() + SIZE / 6, SIZE / 7)); // alto a sinistra
                list.add(new Circle(this.getX() + (5 * SIZE / 6), this.getY() + (5 * SIZE / 6), SIZE / 7)); // basso a destra
                break;
            case 5:
                list.add(new Circle(this.getX() + SIZE / 6, this.getY() + (5 * SIZE / 6), SIZE / 7)); // alto a destra
                list.add(new Circle(this.getX() + (5 * SIZE / 6), this.getY() + SIZE / 6, SIZE / 7)); // basso a sinistra
                list.add(new Circle(this.getX() + SIZE / 6, this.getY() + SIZE / 6, SIZE / 7)); // alto a sinistra
                list.add(new Circle(this.getX() + (5 * SIZE / 6), this.getY() + (5 * SIZE / 6), SIZE / 7)); // basso a destra
                list.add(new Circle(this.getX() + SIZE / 2, this.getY() + SIZE / 2, SIZE / 7)); // punto centrale
                break;
            case 6:
                list.add(new Circle(this.getX() + 2 * SIZE / 10, this.getY() + SIZE / 4, SIZE / 7));
                list.add(new Circle(this.getX() + 2 * SIZE / 10, this.getY() + 3 * SIZE / 4, SIZE / 7));
                list.add(new Circle(this.getX() + 5 * SIZE / 10, this.getY() + SIZE / 4, SIZE / 7));
                list.add(new Circle(this.getX() + 5 * SIZE / 10, this.getY() + 3 * SIZE / 4, SIZE / 7));
                list.add(new Circle(this.getX() + 8 * SIZE / 10, this.getY() + SIZE / 4, SIZE / 7));
                list.add(new Circle(this.getX() + 8 * SIZE / 10, this.getY() + 3 * SIZE / 4, SIZE / 7));

                break;
            default:
                break;
        }
        return list;
    }

}
