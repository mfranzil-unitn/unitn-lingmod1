package it.franzil.impiegati;

import it.franzil.Common;
import it.franzil.lab1.Data;
import it.franzil.persone.Persona;

public class Impiegato extends Persona {
    private int stipendio;
    private Data assunzione;
    private int età;

    public Impiegato(int stipendio, Data assunzione, int età) {
        super();
        this.stipendio = stipendio;
        this.assunzione = assunzione;
        this.età = età;
    }

    public Impiegato() {
        super();
        this.stipendio = Common.randomInt(60000);
        this.assunzione = new Data(1,1,1900);
        this.età = Common.randomInt(60);
    }

    public Impiegato(int stipendio, Data assunzione, int età, String nome, String cognome) {
        super(nome, cognome);
        this.stipendio = stipendio;
        this.assunzione = assunzione;
        this.età = età;
    }

    @Override
    public int compareTo(Persona a) {
        return super.compareTo(a); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object a) {
        boolean res;
        if (a != null && !(a instanceof Impiegato) && super.equals(a))
            res = (((Impiegato)a).stipendio == stipendio &&
                    ((Impiegato)a).assunzione.equals(assunzione) &&
                    ((Impiegato)a).età == età);
        else
            res = false;
        return res;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 17 * hash + stipendio;
        hash = 17 * hash + età;
        hash = 17 * hash + assunzione.hashCode();
        return hash;
    }


    @Override
    public String toString() {
        return super.toString();
    }
    
    public Data getAssunzione() {
        return assunzione;
    }

    @Override
    public String getCognome() {
        return super.getCognome(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getEtà() {
        return età;
    }

    @Override
    public String getNome() {
        return super.getNome(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getStipendio() {
        return stipendio;
    }

    public void setAssunzione(Data assunzione) {
        this.assunzione = assunzione;
    }

    @Override
    public void setCognome(String cognome) {
        super.setCognome(cognome); //To change body of generated methods, choose Tools | Templates.
    }

    public void setEtà(int età) {
        this.età = età;
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome); //To change body of generated methods, choose Tools | Templates.
    }

    public void setStipendio(int stipendio) {
        this.stipendio = stipendio;
    } 
}
