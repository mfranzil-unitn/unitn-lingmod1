/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201706;

import javafx.scene.layout.GridPane;

import java.util.LinkedList;

import static esame201706.Lineare.DIM;

/**
 * @author Matteo Franzil
 */
public class BigGrid extends GridPane {

    LinkedList<LinkedList<Contenitore>> units;

    public BigGrid() {
        units = new LinkedList<>();
        for (int i = 0; i < DIM; i++) {
            LinkedList<Contenitore> jUnits = new LinkedList<>();
            units.add(jUnits);
            for (int j = 0; j < DIM; j++) {
                Contenitore temp = new Contenitore(i, j, this, true, null);
                jUnits.add(temp);
                getChildren().add(temp.rect);
            }
        }
    }

    public void setLinearBigGrid(LinearGrid linearGrid) {
        int i = 0, j = 0;
        clear();
        while (i < DIM && j < DIM) {
            if (linearGrid.units.get(i).circleOn) {
                units.get(i).get(DIM - j - 1).drawCircle(this);
            }
            i++;
            j++;
        }
    }

    public void setSin(LinearGrid linearGrid, double den) {
        clear();
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                if (linearGrid.units.get(i).circleOn) {
                    double y = Math.sin(i / den);
                    y = discretizza(y, -1, 1, DIM);
                    Contenitore temp = units.get(i).get((int) Math.round(y));
                    temp.removeCircle(this);
                    temp.drawCircle(this);
                }
            }
        }
    }

    public void setCos(LinearGrid linearGrid, double den) {
        clear();
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                units.get(i).get(j).removeCircle(this);
                if (linearGrid.units.get(i).circleOn) {
                    double y = Math.cos(i / den);
                    y = discretizza(y, -1, 1, DIM);
                    Contenitore temp = units.get(i).get((int) Math.round(y));
                    temp.removeCircle(this);
                    temp.drawCircle(this);
                }
            }
        }
    }

    public void setSqrt(LinearGrid linearGrid) {
        clear();
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                units.get(i).get(j).removeCircle(this);
                if (linearGrid.units.get(i).circleOn) {
                    double y = Math.sqrt(i);
                    y = Math.abs(discretizza(y, 0, Math.sqrt(DIM), DIM));
                    System.out.println(y);
                    Contenitore temp = units.get(i).get((int) Math.round(DIM - y - 1));
                    temp.removeCircle(this);
                    temp.drawCircle(this);
                }
            }
        }
    }

    public long discretizza(double y, double ymin, double ymax, int nmax) {
        return (long) ((nmax - 1) * (1 - (y - ymin) / (ymax - ymin)));
    }

    public void clear() {
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                units.get(i).get(j).removeCircle(this);
            }
        }
    }

}
