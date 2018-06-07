/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.franzil.lab2;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author matteo.franzil
 */
public class MazzoBase {

    protected List<CartaDaGioco> carte;

    public MazzoBase() {
        carte = new LinkedList();
        for (int i = 1; i <= 13; i++) {
            carte.add(new CartaDaGioco("Cuori", i));
        }
        for (int i = 1; i <= 13; i++) {
            carte.add(new CartaDaGioco("Quadri", i));
        }
        for (int i = 1; i <= 13; i++) {
            carte.add(new CartaDaGioco("Picche", i));
        }
        for (int i = 1; i <= 13; i++) {
            carte.add(new CartaDaGioco("Fiori", i));
        }
        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(carte);
    }

    @Override
    public String toString() {
        Iterator i = carte.iterator();
        String ret = "";
        while (i.hasNext()) {
            ret += i.next().toString() + ", ";
        }
        return ret;
    }
}
