package it.franzil.pila;

public class PilaPolimorfa {

    protected static final int DEFAULTGROWTHSIZE = 5;
    protected int size;
    protected int marker;
    protected Object contenuto[];

    public PilaPolimorfa(int initialSize) {
        size = initialSize;
        marker = 0;
        contenuto = new Object[initialSize];
    }

    private void cresci(int inc) {
        size += inc;
        Object temp[] = new Object[size];
        System.arraycopy(contenuto, 0, temp, 0, marker - 1);
        contenuto = temp;
    }

    public void inserisci(Object k) {
        if (marker == size)
            cresci(DEFAULTGROWTHSIZE);
        contenuto[marker] = k;
        marker++;
    }

    public Object estrai() {
        if (isEmpty())
            System.out.println("Pila vuota!");
        return contenuto[--marker];
    }

    public boolean isEmpty() {
        return (marker == 0);
    }

    public void stampa() {
        for (int i = marker; i > 0; i--)
            System.out.println(contenuto[i].toString());
    }
}
