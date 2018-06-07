package luca_201409;

import javafx.animation.FadeTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 * Questa classe gestisce il set di spinner nella slot machine. Ha la
 * responsabilità di istanziare i singoli spinner,rappresentarli graficamente e
 * di verificare se sono uguali o meno
 *
 */
public class Spinbar extends HBox {

    Simbolo simbolo[] = new Simbolo[SlotMachine.NUM_SPINNERS];
    EventHandler symbolHandler = new SymbolListener();

    SlotMachine sm = null;

    public Spinbar(SlotMachine sm) {
        setAlignment(Pos.CENTER);
        setSpacing(10); // spazio orizzontale tra le componenti
        this.sm = sm;
        initialize();
    }

    public void initialize() {
        getChildren().clear();
        for (int i = 0; i < SlotMachine.NUM_SPINNERS; i++) {
            int tipo = SlotMachine.randomGenerator.nextInt(SlotMachine.NUM_TIPI);
            simbolo[i] = new Simbolo(symbolHandler, tipo);
        }
        getChildren().addAll(simbolo);
        // evita di iniziare con tutti i simboli già uguali!
        if (areSymbolsEqual()) {
            initialize();
        }
    }

    /**
     * Metodo per verificare se tutti i simboli presenti sono uguali
     * @return true se tutti i simboli sono uguali, false altrimenti
     */
    public boolean areSymbolsEqual() {
        for (int i = 1; i < SlotMachine.NUM_SPINNERS; i++) {
            if (!simbolo[0].getId().equals(simbolo[i].getId())) {
                return false;
            }
        }
        return true;
    }
    /**
     * Cambia l'i-esimo simbolo della spinbar - senza animazioni
     * @param i indice dell'elemento da modificare
     */
    public void spinElementWithoutAnimation(int i) {
        int tipo = SlotMachine.randomGenerator.nextInt(SlotMachine.NUM_TIPI);
        simbolo[i] = new Simbolo(symbolHandler, tipo);
        System.out.println("replace simbolo " + i);
        this.getChildren().remove(i);
        this.getChildren().add(i, simbolo[i]);
    }
    /**
     * Cambia l'i-esimo simbolo della spinbar - con animazioni
     * @param i indice dell'elemento da modificare
     */
    public void spinElement(final int i) {
        int tipo = SlotMachine.randomGenerator.nextInt(SlotMachine.NUM_TIPI);
        simbolo[i] = new Simbolo(symbolHandler, tipo);
        System.out.println("replace simbolo " + i);
        Simbolo vecchioSimbolo = (Simbolo) this.getChildren().get(i);
        final Duration SEC_1 = Duration.millis(500);
        FadeTransition disappear = new FadeTransition(SEC_1, vecchioSimbolo);
        disappear.setFromValue(1.0);
        disappear.setToValue(0.0);
        final FadeTransition appear = new FadeTransition(SEC_1, simbolo[i]);
        appear.setFromValue(0.0);
        appear.setToValue(1.0);
        disappear.setOnFinished(new EventHandler() {
            public void handle(Event t) {
                getChildren().remove(i);
                simbolo[i].setOpacity(0.0);
                getChildren().add(i, simbolo[i]);
                appear.play();
            }
        });
        disappear.play();
    }

    public void spinAll() {
        if (!sm.payPoints()) {
            return;
        }
        for (int i = 0; i < SlotMachine.NUM_SPINNERS; i++) {
            spinElement(i);
        }
        if (areSymbolsEqual()) {
            sm.declareVictory();
        }
    }

// ================ LISTENER Simboli ===========================================
    class SymbolListener implements EventHandler {

        public void handle(Event t) {
            System.out.println("Symbol event " + t);
            if (!sm.payPoints()) {
                return;
            }
            Simbolo s = (Simbolo) (t.getSource());
            for (int i = 0; i < SlotMachine.NUM_SPINNERS; i++) {
                if (s == simbolo[i]) {
                    spinElement(i);
                }
            }
            t.consume();
            if (areSymbolsEqual()) {
                sm.declareVictory();
            }
        }
    }

}
