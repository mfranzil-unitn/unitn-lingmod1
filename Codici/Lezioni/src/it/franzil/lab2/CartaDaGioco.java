/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.franzil.lab2;

import java.util.Objects;

/**
 * @author matteo.franzil
 */
public class CartaDaGioco {

    public String seme;
    public int valore;

    public CartaDaGioco(String seme, int valore) {
        this.seme = seme;
        this.valore = valore; //Inserire un controllo sull'imput
    }

    @Override
    public String toString() {
        return valore + " di " + seme;
    }

    @Override
    public boolean equals(Object o) {
        boolean ret = false;
        if (o == null)
            ret = false;
        else if (!(o instanceof CartaDaGioco))
            ret = false;
        else if (((CartaDaGioco) o).valore == valore && ((CartaDaGioco) o).seme.equals(seme))
            ret = true;
        return ret;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.seme);
        hash = 17 * hash + this.valore;
        return hash;
    }

}
