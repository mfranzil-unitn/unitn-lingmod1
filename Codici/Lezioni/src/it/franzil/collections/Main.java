/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.franzil.collections;

public class Main {

    Main() {

    }

    public static void main(String[] args) {
        Stack s = new Coda(); // Stack s=new Pila();
        s.inserisci(1);
        s.inserisci(2);
        s.inserisci(3);
        for (int k = 0; k <= 4; k++) {
            int v = s.estrai();
            System.out.println(v);
        }
    }
}
