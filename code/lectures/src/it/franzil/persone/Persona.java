package it.franzil.persone;

import it.franzil.Common;

public class Persona implements Comparable<Persona> {

    private String nome;
    private String cognome;

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public Persona() {
        this.nome = Common.randomName();
        this.cognome = Common.randomName();
    }

    @Override
    public String toString() {
        return nome + " " + cognome;
    }

    @Override
    public int compareTo(Persona a) {
        int res;
        if (cognome.compareTo(a.cognome) != 0)
            res = cognome.compareTo(a.cognome);
        else
            res = nome.compareTo(a.nome);
        return res;
    }

    @Override
    public boolean equals(Object a) {
        boolean res;
        if (a == null)
            res = false;
        else if (!(a instanceof Persona)) // else if (var.getClass() != this.getClass())
            res = false;
        else
            res = cognome.equals(((Persona) a).cognome) && nome.equals(((Persona) a).nome);
        return res;
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 31 * result + nome.hashCode();
        result = 31 * result + cognome.hashCode();
        return result;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
