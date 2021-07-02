/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.franzil.pila;

import javax.swing.*;

/**
 * @author matte
 */
public class PolimorfismoMain {

    public PolimorfismoMain() {
        String size_t = JOptionPane.showInputDialog("Numero di valori?");
        System.out.println(size_t);
        int size = Integer.parseInt(size_t);
        PilaPolimorfa s;
        if (Math.random() < 0.5)
            s = new PilaPolimorfa(10);
        else
            s = new CodaPolimorfa(10);
        Object o;
        for (int i = 0; i < size; i++) {
            if (Math.random() < 0.5) {
                o = new Integer(i);
            } else {
                o = new Float(i * Math.PI);
            }
            s.inserisci(o);
        }
        try {
            for (int i = 0; i < size + 2; i++) {
                System.out.println(s.estrai());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int k = 0; k < size; k++) {
            o = s.estrai();

            if (o instanceof Integer) {
                Integer i = (Integer) o;
                int w = i.intValue();
                System.out.println("an int:" + w);
            } else if (o instanceof Float) {
                Float i = (Float) o;
                float w = i.floatValue();
                System.out.println("a float:" + w);
            } else {
                System.out.println("Unknown class!");
            }
        }

        //System.exit(322);
    }

    public static void main(String[] args) {
        PolimorfismoMain pm = new PolimorfismoMain();
    }
}
