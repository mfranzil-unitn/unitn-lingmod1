/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.franzil.lab2;

import it.franzil.persone.Persona;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author matteo.franzil
 */
public class Mano {

    List<CartaDaGioco> carte;
    Persona giocatore;

    public Mano(Mazzo mazzo, Persona giocatore) {
        carte = new LinkedList();
        this.giocatore = giocatore;
        mazzo.iter = mazzo.carte.iterator();
        for (int i = 0; i < Lab2.CARTEPESCATE; i++) {
            CartaDaGioco temp = (CartaDaGioco) mazzo.iter.next();
            this.carte.add(temp);
        }

    }

    @Override
    public String toString() {
        Iterator i = carte.iterator();
        String ret = "Giocatore: " + giocatore + " con carte: ";
        while (i.hasNext()) {
            ret += i.next().toString() + ", ";
        }
        return ret;
    }

    public CartaDaGioco pesca(Mazzo mazzo) {
        CartaDaGioco temp = (CartaDaGioco) mazzo.iter.next();
        this.carte.add(temp);
        return temp;
    }
    
    public CartaDaGioco scarta() {
        int rnd = new Random().nextInt(Lab2.CARTEPESCATE);
        CartaDaGioco res = carte.get(rnd);
        carte.remove(rnd);
        return res;
    }
    
    public boolean dueUguali() {
        boolean res;
        Set temp = new HashSet();
        Iterator iterCheck = carte.iterator();
        while(iterCheck.hasNext())
            temp.add(iterCheck.next());
        
        res = temp.size() != Lab2.CARTEPESCATE;
        return res;
    }

}
