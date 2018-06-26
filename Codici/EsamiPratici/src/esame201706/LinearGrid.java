/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201706;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.LinkedList;

import static esame201706.Lineare.DIM;

/**
 * @author Matteo Franzil
 */
public class LinearGrid extends GridPane {

    LinkedList<Contenitore> units;

    public LinearGrid(BigGrid bigGrid, LinkedList<Button> modifiers) {
        units = new LinkedList<>();
        for (int i = 0; i < DIM; i++) {
            Contenitore temp = new Contenitore(i, 0, this, false, modifiers);
            units.add(temp);
            getChildren().add(temp.rect);
        }
    }

    public void clear() {
        for (int i = 0; i < DIM; i++) {
            units.get(i).removeCircle(this);

        }
    }

    /**
     * @param mode       Modalità di cambiamento griglia: 1 per random, 2 per tutto
     *                   on, 3 per tutto off
     * @param linearGrid La griglia da cambiare
     * @param bigGrid
     * @param modifiers
     */
    public void linearGridSwitcher(int mode, BigGrid bigGrid, LinkedList<Button> modifiers) {
        int i = 0;
        int j = 0;
        bigGrid.clear();
        this.clear();
        while (i < Lineare.DIM && j < Lineare.DIM) {
            Contenitore linearSquare = this.units.get(i);
            Contenitore bigSquare = bigGrid.units.get(i).get(j);
            switch (mode) {
                case 1:
                    if (Math.random() < 0.5) {
                        linearSquare.drawCircle(this);
                        bigSquare.circleOn = true;
                    } else {
                        linearSquare.removeCircle(this);
                        bigSquare.circleOn = false;
                    }
                    break;
                case 2:
                    linearSquare.drawCircle(this);
                    bigSquare.circleOn = true;
                    break;
                case 3:
                    linearSquare.removeCircle(this);
                    bigSquare.circleOn = false;
                    break;
                default:
                    break;
            }
            i++;
            j++;
        }
        if (Lineare.lastPressedButton != -1) {
            modifiers.get(Lineare.lastPressedButton).fire();
        }
    }
}
