package it.franzil.persone;

public class Studente extends Persona {

    public int matricola;

    public Studente(String nome, String cognome, int matricola) {
        super(nome, cognome);
        try {
            if (matricola >= 0 && matricola <= 200000) {
                this.matricola = matricola;
            } else {
                throw new IllegalArgumentException("Numero di matricola non valido!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Numero di matricola invalido! Imposto su 0");
            this.matricola = 0;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " - mat. " + this.matricola;
    }

    @Override
    public boolean equals(Object a) {
        boolean res;
        if (super.equals(a) == true) {
            if (a instanceof Studente) {
                res = (this.matricola == ((Studente) a).matricola);
            } else {
                res = false;
            }
        } else
            res = false;
        return res;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + matricola;
        return result;
    }

}
