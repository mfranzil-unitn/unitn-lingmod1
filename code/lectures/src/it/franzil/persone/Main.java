package it.franzil.persone;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Collection set = new TreeSet();

        Persona p1 = new Studente("Matteo", "Franzil", 192198);
        Persona p2 = new Studente("Paolo", "Baiguera", 193188);
        Persona p3 = new Studente("Claudio", "Facchinetti", 196177);
        Persona p4 = new Studente("Francesco", "Arrighi", 194124);
        Persona p5 = new Studente("Nicolò", "Gottardello", 181238);
        Persona p6 = new Studente("Carlo", "Corradini", 191914);
        Persona p7 = new Studente("Miraxh", "Tereziu", 191111);
        Persona p8 = new Studente("Luca", "Santoro", 191000);
        Persona p9 = new Docente("Marco", "Ronchetti", "Programmazione 2");
        Persona p10 = new Docente("Claudio", "Agostinelli", "Probabilità e Statistica");
        Persona p11 = new Docente("Riccardo", "Ghiloni", "Fondamenti Matematici per l'Informatica");

        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        set.add(p5);
        set.add(p6);
        set.add(p7);
        set.add(p8);
        set.add(p9);
        set.add(p10);
        set.add(p11);

        // Richiesta 1: Nomi di studenti che iniziano con M
        Iterator i = set.iterator();
        Persona p;
        while (i.hasNext()) {
            p = (Persona) i.next();
            if (p instanceof Studente && p.getNome().charAt(0) == 'M') {
                System.out.println(p);
            }
        }

        i = set.iterator();
        Studente d;
        while (i.hasNext()) {
            p = (Persona) i.next();
            if (p instanceof Studente) {
                d = (Studente) p;
                if (d.matricola > 189999) {
                    System.out.println(d);
                }
            }
        }

        System.out.println("--------------");

        i = set.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }


        Persona p20 = new Studente("Matteo", "Franzil", 192198);
        Persona p21 = new Studente("Matteo", "Franzl", 192198);
        System.out.println(p20.equals(p21) + ", " + p20.hashCode() + ", " + p21.hashCode());
    }

}
