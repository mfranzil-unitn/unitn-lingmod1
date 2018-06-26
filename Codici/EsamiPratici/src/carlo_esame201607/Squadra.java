package carlo_esame201607;

/**
 * Classe rappresentante una squadra calcistica
 *
 * @author Carlo Corradini
 */
public class Squadra implements Comparable<Squadra> {

    private final String nome;
    private final Bandiera bandiera;
    private int punti;

    /**
     * Costruttore della classe che rappresenta una squadra calcistica
     *
     * @param nome     Nome della squadra
     * @param bandiera Bandiera della squadra
     */
    public Squadra(String nome, Bandiera bandiera) {
        this.nome = nome;
        this.bandiera = bandiera;
        this.punti = 0;
    }

    /**
     * Ritorna il nome della squadra
     *
     * @return Nome squadra
     */
    public String getNome() {
        return nome;
    }

    /**
     * Ritorna la bandiera della squadra
     *
     * @return Bandiera squadra
     */
    public Bandiera getBandiera() {
        return bandiera;
    }

    /**
     * Ritorna i punti della squadra
     *
     * @return Punti squadra
     */
    public int getPunti() {
        return punti;
    }

    /**
     * Aggiunge i punti attuali(this.punti) a quelli passati per parametro
     *
     * @param punti Punti da aggiungere a quelli attuali
     */
    public void aggiungiPunti(int punti) {
        if (punti != 0 && punti != 1 && punti != 3) {
            System.err.println("[ERRORE]: Tentativo di aggiunta punti illegale con " + punti + " -> " + this.toString());
        } else {
            this.punti += punti;
        }
    }

    @Override
    public int compareTo(Squadra o) {
        if (punti == o.punti) {
            return o.getNome().compareTo(nome);
        } else {
            return punti - o.punti;
        }
    }

    @Override
    public String toString() {
        return "{Nome: " + nome + ", Punti: " + punti + "}";
    }
}
