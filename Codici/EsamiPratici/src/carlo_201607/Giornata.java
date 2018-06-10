package carlo_201607;

/**
 * Classe rappresentante un giornata in un girone calcistico
 *
 * @author Carlo Corradini
 */
public class Giornata {

    private static final int PARTITE_A_GIORNATA = 2;
    private final Partita[] partite;
    private boolean giocate;

    /**
     * Costruttore della classe che rappresenta una Giornata calcistica
     *
     * @param sq1 Squadra 1
     * @param sq2 Squadra 2
     * @param sq3 Squadra 3
     * @param sq4 Squadra 4
     */
    public Giornata(Squadra sq1, Squadra sq2, Squadra sq3, Squadra sq4) {
        partite = new Partita[PARTITE_A_GIORNATA];
        partite[0] = new Partita(sq1, sq2);
        partite[1] = new Partita(sq3, sq4);
        giocate = false;
    }

    /**
     * Gioca le partite fra le 4 squadre
     */
    public void giocaGiornata() {
        if (!giocate) {
            for (Partita partita : partite) {
                partita.giocaPartita();
            }
            giocate = true;
        }
    }

    @Override
    public String toString() {
        String toRtn = "";
        for (Partita partita : partite) {
            toRtn += partita.toString() + "\n";
        }
        return toRtn;
    }
}
