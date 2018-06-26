/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esamepressanumeri;

import javafx.scene.control.Button;

/**
 * @author Matteo Franzil
 */
public class BottoneMovimentato extends Button {

    int i;
    int j;

    public BottoneMovimentato(int i, int j) {
        super(String.valueOf(3 * j + i));
        setPrefHeight(1000);
        setPrefWidth(1000);
        this.i = i;
        this.j = j;
    }

    public int getNumero() {
        return Integer.parseInt(getText());
    }

}
