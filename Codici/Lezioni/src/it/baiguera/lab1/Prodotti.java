/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.baiguera.lab1;

/**
 * @author paolo.baiguera
 */
public class Prodotti extends Main {
    public int codice_barre;
    public String descrizione;
    public double prezzo_unit;


    Prodotti(int codice, String description, double prezzo_unit) {
        this.codice_barre = codice;
        this.descrizione = description;
        this.prezzo_unit = prezzo_unit;
    }


    public int getCodice_barre() {
        return this.codice_barre;
    }


    /*public void setCodice_barre(int codice_barre) {
        this.codice_barre = codice_barre;
    }

    /**
     * @return the descrizione
     */
    public String getDescrizione() {
        return this.descrizione;
    }

    /*
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }*/

    public void setPrezzo_unit(int prezzo_unit) {
        this.prezzo_unit = prezzo_unit;
    }

    @Override
    public String toString() {
        String s = "";
        s += this.descrizione + ", " + codice_barre + ", " + prezzo_unit;
        return s;
    }


    double Applica_Sconto(double prezzo) {
        double prezzo_scontato;
        prezzo_scontato = prezzo - prezzo * 0.05;
        return prezzo_scontato;
    }
}
