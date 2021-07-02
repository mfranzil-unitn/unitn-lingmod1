/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201606;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * @author Matteo Franzil
 */
public abstract class Terreno extends StackPane {

    public static final int SIZE = 40;

    public Terreno() {
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        setPrefHeight(SIZE);
        setMaxHeight(SIZE);
        setPrefWidth(SIZE);
        setMaxWidth(SIZE);
    }

}
