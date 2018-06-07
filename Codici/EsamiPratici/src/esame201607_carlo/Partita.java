package esame201607_carlo;

import java.util.Random;

/**
 * Classe rappresentante una partita calcistica
 *
 * @author Carlo Corradini
 */
public class Partita {

    private static final int PAREGGIO = 0;
    private static final int PUNTI_PAREGGIO = 1;
    private static final int PUNTI_VITTORIA = 3;
    private final Squadra sq1;
    private final Squadra sq2;
    private Risultato risultato;

    /**
     * Costruttore della classe che rappresenta una partita calcistica
     *
     * @param sq1
     * @param sq2
     */
    public Partita(Squadra sq1, Squadra sq2) {
        this.sq1 = sq1;
        this.sq2 = sq2;
        risultato = null;
    }

    /**
     * Ritorna il risultato della partita
     *
     * @return Risultato partita
     */
    public Risultato getRisultato() {
        return risultato;
    }

    /**
     * Simula una partita calcistica
     */
    public void giocaPartita() {
        if (risultato == null) {
            Random random = new Random(System.currentTimeMillis());
            switch (random.nextInt(3)) {
                case PAREGGIO: {
                    int res = random.nextInt(3);
                    sq1.aggiungiPunti(PUNTI_PAREGGIO);
                    sq2.aggiungiPunti(PUNTI_PAREGGIO);
                    risultato = new Risultato(res, res);
                    break;
                }
                default: {
                    int sq1Goal = random.nextInt(3);
                    int sq2Goal = sq1Goal;
                    do {
                        sq2Goal = random.nextInt(3);
                    } while (sq1Goal == sq2Goal);
                    if (sq1Goal > sq2Goal) {
                        sq1.aggiungiPunti(PUNTI_VITTORIA);
                    } else {
                        sq2.aggiungiPunti(PUNTI_VITTORIA);
                    }
                    risultato = new Risultato(sq1Goal, sq2Goal);
                    break;
                }
            }
        }
    }

    @Override
    public String toString() {
        return sq1.getNome() + " | " + sq2.getNome() + "\t\t" + (risultato != null ? (risultato.getRis1() + " : " + risultato.getRis2()) : "- : -");
    }
}
