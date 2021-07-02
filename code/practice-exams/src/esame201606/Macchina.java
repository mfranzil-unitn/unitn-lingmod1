/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201606;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * @author Matteo Franzil
 */
public class Macchina extends Circle {

    private static int macchinedisponibili = 3;
    private int relativeX, relativeY;

    public Macchina(int x, int y) throws UnsupportedOperationException {

        super((Terreno.SIZE) / 2.0, Color.RED);
        this.relativeX = x;
        this.relativeY = y;
        if (macchinedisponibili - 1 < 0) {
            throw new UnsupportedOperationException("No cars available");
        } else {
            macchinedisponibili--;
        }
    }

    public static int getMacchinedisponibili() {
        return macchinedisponibili;
    }

    public static void setMacchinedisponibili(int macchine) {
        macchinedisponibili = macchine;
    }

    public int getRelativeX() {
        return relativeX;
    }

    public void setRelativeX(int x) {
        this.relativeX = x;
    }

    public int getRelativeY() {
        return relativeY;
    }

    public void setRelativeY(int relativeY) {
        this.relativeY = relativeY;
    }
}
