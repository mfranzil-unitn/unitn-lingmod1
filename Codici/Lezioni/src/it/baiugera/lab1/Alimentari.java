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
public class Alimentari extends Prodotti{
    public Data data;
    
    Alimentari(int codice, String descrizione, double prezzo,Data data ){
    super(codice,descrizione,prezzo);
    this.data= data;
    }


    /*public String toString() {
        String s= "";
        s+= this.descrizione + ", " + codice_barre + ","+ prezzo_unit +", " + this.data;;
        return s;  //To change body of generated methods, choose Tools | Templates.
    }*/

    
    @Override
     double Applica_Sconto(double prezzo) {
       double scontato=0;
       Data oggi= new Data();
       int diff= this.data.getDifference(oggi);
       if (diff>=0){
       scontato = prezzo- prezzo*0.2;
       } 
       else{
         scontato= super.Applica_Sconto(prezzo);
       }
       return scontato; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.data; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
