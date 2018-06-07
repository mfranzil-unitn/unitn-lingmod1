package it.franzil.tombola;

import it.franzil.Common;
import it.franzil.persone.Persona;

/**
 *
 * @author matte
 */
public class Giocatore extends Persona {

    private final int numerocartelle;
    /**
     *
     * @param nome Stringa del nome del giocatore
     * @param cognome Stringa del cognome del giocatore
     * @param numerocartelle Numero di cartelle da assegnare al giocatore
     */
    public Giocatore(String nome, String cognome, int numerocartelle) {
        super(nome, cognome);
        this.numerocartelle = numerocartelle;
    }

    /**
     *
     * @param persona E' possibile passare una Persona come parametro al costruttore.
     * @param numerocartelle Numero di cartelle da assegnare al giocatore
     */
    public Giocatore(Persona persona, int numerocartelle) {
        super(persona.getNome(), persona.getCognome());
        this.numerocartelle = numerocartelle;
    }

    /**
     *
     */
    public Giocatore() {
        super();
        this.numerocartelle = Common.randomInt(Tombola.MAXCARTELLE);
    }

    void annunciaNumero(int num, int cartellaId) {
        Tombola.txt.appendText(toString() + " ha il numero " + num + " in cartella " + cartellaId + "\n");
    }

    void annunciaVittoria(int cartellaId) {
        Tombola.txt.setText(toString() + " ha vinto con cartella " + cartellaId + "\n");
    }

    /**
     *
     * @return Ritorna il nome del giocatore.
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Metodo nativo per comparare due giocatori.
     * @param a Un Object qualsiasi
     * @return Un Boolean che conferma o meno l'equals
     */
    @Override
    public boolean equals(Object a) {
        boolean res = false;
        if (a == null)
            res = false;
        else if (!(a instanceof Giocatore))
            res = false;
        else if (super.equals(a) && numerocartelle == ((Giocatore) a).numerocartelle)
            res = true;
        return res;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.numerocartelle;
        return hash;
    }

    @Override
    public int compareTo(Persona a) {
        return super.compareTo(a); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getNumerocartelle() {
        return numerocartelle;
    }

}
