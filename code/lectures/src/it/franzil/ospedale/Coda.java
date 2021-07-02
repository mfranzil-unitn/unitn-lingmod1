package it.franzil.ospedale;

public class Coda extends Pila {

    Coda(int initialSize) {
        super(initialSize);
    }

    @Override
    public Paziente estrai() {
        if (isEmpty())
            System.out.println("Coda vuota!");
        Paziente retval = contenuto[0];
        for (int k = 1; k < marker; k++)
            contenuto[k - 1] = contenuto[k];
        marker--;
        return retval;
    }

    @Override
    public void stampa() {
        for (int i = 0; i < marker; i++)
            System.out.println(contenuto[i].toString());
    }

}
