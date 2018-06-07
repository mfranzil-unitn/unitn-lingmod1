/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.baiugera.lab1;

/**
 *
 * @author paolo.baiguera
 */
public class Main {
     
    
    
    public static void main(String[] args) {
        Prodotti p = new Prodotti(588888,"Cappello",10.0);
        System.out.println(p);
        Prodotti_sconto ps= new Prodotti_sconto(5454677, "Maglietta", 10.0);
        System.out.println("Prima dello sconto: " + ps);
        ps.prezzo_unit= ps.Applica_Sconto(ps.prezzo_unit);
        System.out.println("Dopo: " + ps);
        Data d= new Data(2,4,2018);
        Alimentari pa= new Alimentari(58888, "Ombrello", 10.0, d);
        System.out.println("Prima dello sconto: " + pa);
        pa.prezzo_unit= pa.Applica_Sconto(pa.prezzo_unit);
        System.out.println("Dopo: " + pa);
        Non_Alimentari pna= new Non_Alimentari(56666, "Libro", 10.0, "plastica", new Carta());
        System.out.println("Prima dello sconto: " + pna);
        pna.prezzo_unit= pna.Applica_Sconto(pna.prezzo_unit);
         System.out.println("Dopo: " + pna);
    }
    
}
