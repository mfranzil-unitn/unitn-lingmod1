package esame201607_carlo;

/**
 * Classe rappresentante un risultato
 *
 * @author Carlo Corradini
 */
public class Risultato {

    private final int ris1;
    private final int ris2;

    /**
     * Costruttore della classe che rappresenta un risultato
     *
     * @param ris1 Risultato squadra 1
     * @param ris2 Risultato squadra 2
     */
    public Risultato(int ris1, int ris2) {
        this.ris1 = ris1;
        this.ris2 = ris2;
    }

    /**
     * Ritorna il risultato della prima squadra
     *
     * @return Risultato squadra 1
     */
    public int getRis1() {
        return ris1;
    }

    /**
     * Ritorna il risultato della seconda squadra
     *
     * @return Risultato squadra 2
     */
    public int getRis2() {
        return ris2;
    }

    @Override
    public String toString() {
        return "{" + ris1 + ", " + ris2 + "}";
    }
}
