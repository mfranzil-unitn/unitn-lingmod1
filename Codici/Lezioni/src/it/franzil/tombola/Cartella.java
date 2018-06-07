package it.franzil.tombola;

import java.util.TreeSet;

/**
 *
 * @author matte
 */
public class Cartella {

    private final TreeSet<Integer> numeri = new TreeSet<>();
    private final TreeSet<Integer> mancanti = new TreeSet<>();
    private Giocatore proprietario = null;
    private int id = 0;
    private static int nCartelle = 0;

    Cartella(Giocatore g) {
        id = ++nCartelle;
        proprietario = g;
        for (int i = 1; i <= Tombola.NCELLS; i++) {
            boolean creatoNuovoNumero = false;
            do {
                int x = 0;
                x = Tombola.generatore.nextInt(Tombola.MAXNUM) + 1;
                creatoNuovoNumero = numeri.add(x);
//                if (creatoNuovoNumero) {
//                    System.out.println("Aggiunto " + x );
//                }
            } while (!creatoNuovoNumero);
        }
        mancanti.addAll(numeri);
    }

    /**
     *
     * @param x Numero estratto dal Banco che verrà controllato dal metodo.
     * @return Un Boolean che segnalerà la presenza o meno nella cartella.
     */
    boolean checkNumber(int x) {
        boolean result = mancanti.remove(x);
        if (proprietario != null) {
            if (result) {
                proprietario.annunciaNumero(x, id);
            }
            if (mancanti.isEmpty()) {
                Banco.vincitori.add(this);
            }
        }
        return result;
    }

/*    private void print(TreeSet list) {
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }*/

    /**
     *
     */
    void printOriginale() {
        Tombola.txt.appendText(numeri.toString());
    }

/*    public void printCurrent() {
        System.out.println(mancanti.toString());
    }*/

    /**
     * Metodo utilizzato per ottnere il valore del field privato proprietario.
     * @return Il proprietario (tipo Giocatore estende Persona) della Cartella
     */
    Giocatore getProprietario() {
        return proprietario;
    }

    int getId() {
        return id;
    }
        
}
