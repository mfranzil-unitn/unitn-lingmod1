package it.franzil.persone;

public class Docente extends Persona {

    public String materia;

    public Docente(String nome, String cognome, String materia) {
        super(nome, cognome);
        this.materia = materia;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + this.materia;
    }

    @Override
    public boolean equals(Object a) {
        boolean res;
        if (super.equals(a) == true) {
            if (a instanceof Docente)
                res = this.materia.equals(((Docente) a).materia);
            else
                res = false;
        } else
            res = false;
        return res;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + materia.hashCode();
        return result;
    }
}
