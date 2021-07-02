/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201109;

import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * @author Matteo Franzil
 */
public class Cella extends Pane {

    public static final int SIZE = 20;
    private boolean whiteOnly;

    public Cella(boolean whiteOnly) {
        this.whiteOnly = whiteOnly;
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        setPrefHeight(SIZE);
        setMaxHeight(SIZE);
        setPrefWidth(SIZE);
        setMaxWidth(SIZE);

        addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            try {
                switchBackground();
            } catch (ClassCastException ex) {
                System.out.println("Cannot click on something else than a Cella");
            }
        });
    }

    public void switchBackground() {
        if (isCurrentlyWhite() && whiteOnly) {
            setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        } else if (!isCurrentlyWhite() && !whiteOnly) {
            setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

    public boolean isWhiteOnly() {
        return whiteOnly;
    }

    public boolean isCurrentlyWhite() {
        boolean res;
        if (getBackground().getFills().get(0).getFill().equals(Color.WHITE)) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

    public void forceSwitchBackground() {
        setBackground(new Background(new BackgroundFill(isCurrentlyWhite() ? Color.BLACK : Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

}
