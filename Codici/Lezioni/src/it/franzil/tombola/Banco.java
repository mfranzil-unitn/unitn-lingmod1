package it.franzil.tombola;

import java.util.LinkedList;

/**
 *
 * @author matte
 */
public class Banco {

    static LinkedList<Cartella> vincitori;
    private final LinkedList<Integer> sacchetto;
    private final LinkedList<Cartella> cartelle;
    
    public boolean numerifiniti;

    public Banco() {
        cartelle = new LinkedList<>();
        sacchetto = new LinkedList<>();
        vincitori = new LinkedList<>();
        numerifiniti = false;
        for (int i = 1; i <= Tombola.MAXNUM; i++) {
            sacchetto.add(i);
        }
    }

    void addListener(Cartella c) {
        cartelle.add(c);
    }

    void removeListener(Cartella c) {
        cartelle.remove(c);
    }

    private void notifyAllListeners(int x) {
        for (Object tmp : cartelle) {
            ((Cartella) tmp).checkNumber(x);
        }
    }

    /**
     * Funzione che si occupa di estrarre il numero successivo dal sacchetto.
     * @return Il numero appena estratto.
     */
    int getNextNumber() {
        if (sacchetto.isEmpty())
            numerifiniti = true;
        int index = Tombola.generatore.nextInt(sacchetto.size());
        Integer num = sacchetto.get(index);
        sacchetto.remove(index);
        notifyAllListeners(num);
        return num;
    }

    void finalizzaVittoria() {
        for (Cartella t : vincitori) {
            t.getProprietario().annunciaVittoria(t.getId());
            t.printOriginale();
        }
    }
}
