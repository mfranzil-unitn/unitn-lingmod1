/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201806;

import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.LinkedList;

/**
 * Classe costruita da un Pane di sfondo grigio contenente un numero variabile
 * di pali e di dischi, dove il gioco va a svolgersi. Il numero di pali e dischi
 * è definito dalle variabili final NUMERO_DISCHI e NUMERO_PALI. La Area verrà
 * inizializzata con la quantità di dischi richiesta nel primo palo a sinistra,
 * mentre gli altri pali rimarranno vuoti. Due parametri di tipo PaloText
 * vengono utilizzati per i movimenti tra i dischi, mentre due parametri di tipo
 * alert e button vengono usati per la gestione dei popup.
 *
 * @author Matteo Franzil - 192198
 */
public class HanoiArea extends Pane {

    /**
     * Il numero di dischi totali utilizzati nel gioco
     */
    public static final int NUMERO_DISCHI = 4;

    /**
     * Il numero di pali presenti nel gioco.
     */
    public static final int NUMERO_PALI = 3;
    private LinkedList<Palo> pali;
    private CustomAlert alert;
    private Button close;
    private boolean animationOn;

    /**
     * Costruisce una nuova HanoiArea
     *
     * @param from  Un parametro di tipo PaloText che memorizzi il palo di
     *              partenza.
     * @param to    Un parametro di tipo PaloText che memorizzi il palo di arrivo.
     * @param close Un bottone per chiudere i popup generati.
     */
    public HanoiArea(PaloText from, PaloText to, Button close) {
        setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
        setWidth(300);
        setHeight(300);

        this.close = close;
        pali = new LinkedList<>();

        for (int i = 0; i < NUMERO_PALI; i++) {
            Palo palo = new Palo();

            palo.setX((getWidth() * (i + 1) / (NUMERO_PALI + 1)) - (palo.getWidth() / 2.0));
            palo.setY(getHeight() - palo.getHeight());
            pali.add(palo);
            getChildren().add(palo);
        }

        //Inizializzo la prima torre
        for (int i = NUMERO_DISCHI; i > 0; i--) {
            addDisco(pali.get(0), i);
        }

        // Aggiungo i listener ai click del mouse
        addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                    if (e.getTarget() instanceof Palo) {
                        // se non clicco un palo non faccio niente
                        Palo palo = (Palo) e.getTarget();
                        setPaloText(palo, from, to);
                    }
                }
        );

    }

    private void addDisco(Palo palo, int size) {
        Disco disco = new Disco(size);
        palo.getDischi().add(disco);
        getChildren().add(disco);
        disco.toFront();

        int position = palo.getDischi().size();
        disco.setX(palo.getX() + palo.getWidth() / 2.0 - disco.getWidth() / 2.0);
        disco.setY(getHeight() - position * disco.getHeight());
    }

    private Disco removeDisco(Palo palo) {
        Disco disco = palo.getDischi().removeLast();
        getChildren().remove(disco);
        return disco;
    }

    /**
     * Sposta un disco da un Palo all'altro, aprendo un popup in caso di errore
     * (pali non selezionati o disco da spostare più grande del primo disco
     * d'arrivo).
     *
     * @param from Un parametro di tipo PaloText che memorizzi il palo di
     *             partenza.
     * @param to   Un parametro di tipo PaloText che memorizzi il palo di arrivo.
     */
    public void moveDisco(PaloText from, PaloText to) {
        if (!from.isEmpty() && !to.isEmpty()) {
            // Sposto i dischi soltanto se permesso dalle regole
            if (to.getTarget().getLastDiscoSize() < from.getTarget().getLastDiscoSize()) {
                alert = new CustomAlert("Impossibile appoggiare un disco su uno più piccolo");
                close.setDisable(false);
                alert.showAndWait();
            } else {
                if (animationOn) {
                    Disco disco = from.getTarget().getDischi().getLast();
                    autoMove(from, to, disco);
                    from.getTarget().getDischi().removeLast();
                    to.getTarget().getDischi().add(disco);
                } else {
                    Disco disco = removeDisco(from.getTarget());
                    addDisco(to.getTarget(), disco.getSize());
                }
            }

            from.setEmpty();
            to.setEmpty();
        } else {
            // Caso in cui i pali non sono stati correttamente selezionati
            alert = new CustomAlert("Pali di partenza e arrivo non definiti");
            close.setDisable(false);
            alert.showAndWait();
        }
    }

    // Questo metodo si occupa di settare correttamente i PaloText
    private void setPaloText(Palo palo, PaloText from, PaloText to) {
        if (from.isEmpty() && to.isEmpty()) {
            // caso in cui entrambi sono vuoti
            if (palo.isEmpty()) {
                alert = new CustomAlert("Palo vuoto!");
                close.setDisable(false);
                alert.showAndWait();
            } else {
                from.setTarget(palo);
            }
        } else if (!from.isEmpty() && to.isEmpty()) {
            // caso in cui from è già stato settato
            if (from.getTarget().equals(palo)) {
                alert = new CustomAlert("Palo già scelto!");
                close.setDisable(false);
                alert.showAndWait();
            } else {
                to.setTarget(palo);
            }
        } else {
            // caso in cui entrambi sono già stati settati
            alert = new CustomAlert("Pali di partenza e arrivo già scelti!");
            close.setDisable(false);
            alert.showAndWait();
        }
    }

    /**
     * Ripristina la HanoiArea ai valori di partenza, spostando tutti i dischi
     * sul primo palo.
     */
    public void reset() {
        // Mantengo soltanto i pali
        getChildren().retainAll(pali);
        for (int i = 0; i < pali.size(); i++) {
            pali.get(i).clear();
        }

        for (int i = 4; i > 0; i--) {
            addDisco(pali.get(0), i);
        }
    }

    /**
     * Metodo che chiude (ove possibile) un popup generato dalla classe.
     */
    public void closeAlert() {
        try {
            alert.close();
            close.setDisable(true);
        } catch (NullPointerException e) {
            System.err.println("No dialog to close");
        }
    }

    private void autoMove(PaloText from, PaloText to, Disco disco) {
        Palo palo = to.getTarget();
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(2000));

        Path path = new Path();
        MoveTo moveTo = new MoveTo();
        // Setto i punti iniziali nelle coordinate CENTRALI del disco
        moveTo.setX(disco.getX() + disco.getWidth() / 2.0);
        moveTo.setY(disco.getY() - disco.getHeight() / 2.0);

        CubicCurveTo cubicTo = new CubicCurveTo();
        // Setto i punti di controllo sopra i due pali
        cubicTo.setControlX1(disco.getX() + disco.getWidth() / 2.0);
        cubicTo.setControlY1(0);

        cubicTo.setControlX2(palo.getX() + palo.getWidth() / 2.0);
        cubicTo.setControlY2(0);

        // L'animazione si riferiscono al punto centrale, ma devo riposizionare manualmente il disco
        // per futuri spostamenti
        cubicTo.setX(palo.getX() + palo.getWidth() / 2.0);
        cubicTo.setY(getHeight() - palo.getDischi().size() * disco.getHeight() - disco.getHeight() / 2.0);

        disco.setX(palo.getX() + palo.getWidth() / 2.0 - disco.getWidth() / 2.0);
        disco.setY(getHeight() - palo.getDischi().size() * disco.getHeight());

        path.getElements().addAll(moveTo, cubicTo);

        pathTransition.setPath(path);
        pathTransition.setNode(disco);
        pathTransition.play();
    }

    /**
     * Restituisce il metodo corrente di spostamento dischi.
     *
     * @return TRUE se vengono usate le animazioni, FALSE altrimenti.
     */
    public boolean isAnimationOn() {
        return animationOn;
    }

    /**
     * Imposta il metodo di animazione dei dischi desiderato.
     *
     * @param isAnimationOn Un booleano, settato su TRUE se si desidera
     *                      abilitare le animazioni.
     */
    public void setAnimationOn(boolean isAnimationOn) {
        this.animationOn = isAnimationOn;
    }

    public void manualPaloSet(int number, PaloText from, PaloText to) {
        setPaloText(pali.get(number), from, to);
    }

    public LinkedList<Palo> getPali() {
        return pali;
    }

    public void solve(int disk, Palo source, Palo dest, Palo aux, PaloText from, PaloText to) {
        if (disk == 0) {
            System.out.println(source + " -> " + dest);
        } else {
            solve(disk - 1, source, aux, dest, from, to);
            System.out.println(source + " -> " + dest);
            solve(disk - 1, aux, dest, source, from, to);
        }
    }
}
