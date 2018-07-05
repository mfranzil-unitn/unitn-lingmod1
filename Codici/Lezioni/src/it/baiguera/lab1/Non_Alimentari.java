/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.baiguera.lab1;

/**
 * @author paolo.baiguera
 */
public class Non_Alimentari extends Prodotti {
    public String materiale;
    Materiale m = new Materiale();

    Non_Alimentari(int codice, String descrizione, double prezzo, String materiale, Materiale mat) {
        super(codice, descrizione, prezzo);
        this.materiale = materiale;
        this.m = mat;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.materiale + ", " + this.m; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    double Applica_Sconto(double prezzo) {
        double scontato = 0;
        if (this.materiale == "vetro" || this.materiale == "carta" || this.materiale == "plastica") {
            scontato = prezzo - prezzo * 0.1;
        } else {
            scontato = super.Applica_Sconto(prezzo);
        }
        return scontato; //To change body of generated methods, choose Tools | Templates.
    }

    //If con la nuova classe materiale sarà: if(this.m= new Carta() || this.m == new.Vetro());


}
