/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.franzil.euromix;

import it.franzil.persone.Persona;
import java.util.Objects;

public class Automobile {
    public String marca;
    public String tipo;
    public String colore;
    public int cilindrata;
    public Targa targa;
    public Persona proprietario;
    
    Automobile(String marca, String tipo, String colore, int cilindrata, Targa targa, Persona proprietario) {
        this.marca = marca;
        this.tipo = tipo;
        this.colore = colore;
        this.cilindrata = cilindrata;
        this.targa = targa;
        this.proprietario = proprietario;
    }

    @Override
    public boolean equals(Object o) {
        boolean res;
        if (o == null)
            res = false;
        else if (!(o instanceof Automobile))
            res = false;
        else 
            res = (marca.equals(((Automobile)o).marca) &&
                   tipo.equals(((Automobile)o).tipo) &&
                   colore.equals(((Automobile)o).colore) &&
                   cilindrata == ((Automobile)o).cilindrata &&
                   targa.equals(((Automobile)o).targa) &&
                   proprietario.equals(((Automobile)o).proprietario));
        return res;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.marca);
        hash = 17 * hash + Objects.hashCode(this.tipo);
        hash = 17 * hash + Objects.hashCode(this.colore);
        hash = 17 * hash + this.cilindrata;
        hash = 17 * hash + Objects.hashCode(this.targa);
        hash = 17 * hash + Objects.hashCode(this.proprietario);
        return hash;
    }
    
    
    
}
