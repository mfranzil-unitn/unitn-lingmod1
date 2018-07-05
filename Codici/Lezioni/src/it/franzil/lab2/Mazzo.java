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
 * @author matteo.franzil
 */
public class Mazzo {

    List<CartaDaGioco> carte;
    Iterator iter; //Nel caso di puiù giocatori spostare iteratore nel mazzo

    public Mazzo() {
        carte = new LinkedList();
        for (int i = 0; i < Lab2.NUMEROMAZZI; i++) {
            MazzoBase temp = new MazzoBase();
            Iterator it = temp.carte.iterator();
            while (it.hasNext()) {
                carte.add((CartaDaGioco) it.next());
            }
        }
        shuffle();
        iter = carte.iterator();
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

    private void shuffle() {
        Collections.shuffle(carte);
    }
}
