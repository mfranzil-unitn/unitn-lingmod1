package carlo_esame201707;

/**
 * Classse Eccezzione causa valore dado non ammesso o illegale
 *
 * @author Carlo Corradini
 */
public class IllegalDadoValueException extends Exception {

    /**
     * Costruttore Eccezzione valore Dado non ammesso
     *
     * @param message Messaggio di errore
     */
    public IllegalDadoValueException(String message) {
        super(message);
    }
}
