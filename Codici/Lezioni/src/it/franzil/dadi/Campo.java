/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.franzil.dadi;

import java.util.Collections;
import java.util.LinkedList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Matteo Franzil
 */
public class Campo extends Group {

    int numClick;
    Rectangle sfondo;

    public Campo(LinkedList<Dado> dadi, Dadi main) {
        numClick = 0;
        sfondo = new Rectangle(5000, 5000, Paint.valueOf("GREEN"));
        getChildren().add(sfondo);

        addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            if (numClick < 3) {
                main.counter--;
                main.contatore.setText("Contatore: " + main.counter);
                Dado dado = new Dado(e.getX(), e.getY(), this, main);
                dadi.add(dado);
                numClick++;
            } else {
            }
        });
    }

    public void moveDadi() {
        for (Node a : getChildren()) {
            if (a instanceof Dado) {
                ((Dado) a).moveAway();
            }
        }
    }

    public void dissolveDadi() {
        for (Node a : getChildren()) {
            if (a instanceof Dado) {
                ((Dado) a).dissolve();
            }
        }
    }

    public void reset(Parent root) {
        getChildren().retainAll(sfondo, root);
        numClick = 0;
    }

    public boolean checkVictory(LinkedList<Dado> dadi) {
        LinkedList<Integer> values = new LinkedList<>();
        boolean victory = false;
        int i = 0;

        dadi.forEach((a) -> {
            values.add(a.value);
        });

        Collections.sort(values);
        System.out.println(values);
        if (values.size() >= 3) {
            i = 0;
            
            if ((values.get(i) == (values.get(i + 1) - 1)) && (values.get(i + 1) == (values.get(i + 2) - 1))) {
                victory = true;
            }
        }
        return victory;

    }
}
