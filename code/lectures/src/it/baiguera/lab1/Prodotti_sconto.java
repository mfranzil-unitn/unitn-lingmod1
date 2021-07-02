/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.baiguera.lab1;

/**
 * @author paolo.baiguera
 */
public class Prodotti_sconto extends Prodotti {


    Prodotti_sconto(int codice_barre, String description, double prezzo_unit) {
        super(codice_barre, description, prezzo_unit);
    }

    double Applica_Sconto(double prezzo) {
        double prezzo_scontato;
        prezzo_scontato = prezzo - prezzo * 0.05;
        return prezzo_scontato;
    }


}
