/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201806;

import javafx.scene.text.Text;

/**
 * Classe wrapper di un Text che inoltre mantiene, a seconda del parametro
 * isFrom, un Palo che rappresenta rispettivamente il Palo di partenza di un
 * HanoiArea se isFrom è TRUE, oppure il Palo di arrivo di un HanoiArea se
 * isFrom è FALSE. Tutti i metodi modificano sia le variabili d'istanza che il
 * valore del Text. Per ogni HanoiArea sono necessari esattamente due PaloText.
 *
 * @author Matteo Franzil - 192198
 */
public class PaloText extends Text {

    private boolean isFrom;
    private Palo target;

    /**
     * Costruisce un nuovo PaloText.
     *
     * @param isFrom Se TRUE, verrà costruito un PaloText di tipo partenza,
     *               altrimenti di tipo arrivo
     */
    public PaloText(boolean isFrom) {
        this.isFrom = isFrom;
        if (isFrom) {
            setText("From");
        } else {
            setText("To");
        }
    }

    /**
     * Restituisce lo stato corrente del PaloText
     *
     * @return TRUE se non vi sono Pali memorizzati al momento, FALSE altrimenti
     */
    public boolean isEmpty() {
        return (getText().equals(isFrom ? "From" : "To"));
    }

    /**
     * Svuota il PaloText, reimpostando il Text associato.
     */
    public void setEmpty() {
        target = null;
        setText(isFrom ? "From" : "To");
    }

    /**
     * Restituisce il Palo memorizzato come target.
     *
     * @return Un oggetto di tipo Palo, target del PaloText.
     */
    public Palo getTarget() {
        return target;
    }

    /**
     * Imposta il target del PaloText.
     *
     * @param palo Un Palo che verrà memorizzato come target.
     */
    public void setTarget(Palo palo) {
        target = palo;
        setText((isFrom ? "From" : "To") + " " + palo.toString());
    }
}
