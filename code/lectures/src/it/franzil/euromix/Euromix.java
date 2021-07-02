/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.franzil.euromix;

import it.franzil.persone.Persona;

public class Euromix {
    public static void main(String[] args) {
        Automobile a1 = new Automobile("Fiat", "Seicento", "bianco", 1600, new Targa("AA030AA"), new Persona("Matteo", "Franzil"));
        Automobile a2 = new Automobile("Fiat", "Tipo", "bianco", 1600, new Targa("AA030AA"), new Persona("Matteo", "Franzil"));
        System.out.println(a1.targa.toString());
        System.out.println(a1.equals(a2) + " " + a1.hashCode() + " " + a2.hashCode());

    }
}


/*Definire la classe "Automobile" con variabili di
istanza Marca (es. VW), Tipo (Es, Golf), Colore (es.
Bianco), Cilindrata (es. 1600), Targa, Proprietario.
Identificare diversi scenari di uso che abbiano
differenti scenari di "equals":
- es. uno scenario in cui una Tipo e una Golf siano
considerate "uguali", ed uno in cui due Golf di colore
diverso sono considerate "uguali"
- implementare la equals per i diversi scenari.*/