/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.franzil.lab2;

import it.franzil.persone.Persona;

/**
 *
 * @author matteo.franzil
 */
public class Lab2 {
    
    public static final int CARTEPESCATE = 5;
    public static final int NUMEROMAZZI = 4;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mazzo mazzo = new Mazzo();
        Mano mano = new Mano(mazzo, new Persona("Nicolò", "Gottardello"));
        for(int i = 0; i < CARTEPESCATE; i++) {
            System.out.println(mano.toString());
            if (mano.dueUguali()) {
                System.out.println("Hai vinto!");
                System.exit(0);
            } else {
                System.out.println("Scartata ===> " + mano.scarta());
                System.out.println("Pescata <=== " +  mano.pesca(mazzo));
            }
        }
        System.out.println("Hai perso!");
    }
}
