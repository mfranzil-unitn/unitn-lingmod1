package luca_esame201409;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Random;

public class SlotMachine extends Application {

    public static final int NUM_MONETE = 3; // numero di monete disponibili
    public static final int NUM_SPINNERS = 3; // numero di simboli che appaiono sulla slot machine
    public static final int NUM_TIPI = 6; // numero di diversi tipi di simbolo 
    public static final int NPOINTS_PER_MONETA = 100; // numero di punti per moneta 
    public static final int COSTO_PARTITA = 100; // numero di punti per partita 
    public static final int PUNTI_PER_PARTITA = 128; // numero di punti per partita 

    public static Random randomGenerator = new Random(System.currentTimeMillis());

    Stage mainWindow = null;
    ValueBox creditBox = null;
    ValueBox punteggioBox = null;
    Spinbar spinbar = null;
    Salvadanaio salvadanaio = null;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * paga i punti necessari per effettuare uno spin
     *
     * @return false se autorizzazione negata per mancanza di punti, true
     * altrimenti
     */
    public boolean payPoints() {
        int punti = punteggioBox.getValue();
        if (punti == 0) {
            return false;
        }
        punteggioBox.setValue(punti / 2);
        return true;
    }

    /**
     * Dichiara vittoria e accredita i punti vinti
     */
    public void declareVictory() {
        int points = punteggioBox.getValue();
        punteggioBox.setValue(0);
        showPopup("Hai vinto!");
        creditBox.incrementValue(points * 100);
    }

    /**
     * set up della parte grafica
     *
     * @return il pannello principale, preparato
     */
    BorderPane prepareSceneContent() {
        BorderPane border = new BorderPane();

        // =========== TOP: titolo
        Group g = new Title();
        border.setTop(g);
        BorderPane.setAlignment(g, Pos.CENTER);

        // ============ RIGHT: le monete
        salvadanaio = new Salvadanaio(this);
        border.setRight(salvadanaio);

        // ============= BOTTOM : i bottoni di controllo
        HBox buttonbar = new HBox();
        //
        MyButton spinButton = new MyButton("Spin", true, new ListenerSpinButton());
        MyButton payButton = new MyButton("Pay", true, new ListenerPayButton());
        MyButton nuovaPartitaButton = new MyButton("Nuova Partita", false, new ListenerNuovaPartitaButton());             //
        buttonbar.getChildren().addAll(nuovaPartitaButton, spinButton, payButton);
        buttonbar.setSpacing(40); // spazio orizzontale tra le componenti del HBox
        buttonbar.setAlignment(Pos.CENTER);
        border.setBottom(buttonbar);

        // ========= CENTER: Spinbar e contatori
        VBox centralBox = new VBox(); // componente che conterrà Spinner e Contatori
        centralBox.setAlignment(Pos.CENTER);
        centralBox.setSpacing(40); // spazio verticale tra le componenti del VBox
        // spazio verticale tra la componente al centro e quella soprastante:
        centralBox.setPadding(new Insets(0, 0, 0, 100));

        spinbar = new Spinbar(this);
        spinbar.setAlignment(Pos.CENTER);

        HBox boxContatori = new HBox(); // contenitore dei contatori
        creditBox = new ValueBox("Credito", payButton);
        punteggioBox = new ValueBox("Punteggio", spinButton);
        boxContatori.getChildren().addAll(creditBox, punteggioBox);
        boxContatori.setAlignment(Pos.CENTER);
        boxContatori.setSpacing(40);// spazio orizzontale tra le componenti del HBox

        centralBox.getChildren().addAll(spinbar, boxContatori);
        border.setCenter(centralBox);

        reset(); // inizializza tutte le componenti

        return border;
    }

    /**
     * resetta le varie componenti per tornare allo stato iniziale
     */
    void reset() {
        creditBox.reset();
        punteggioBox.reset();
        salvadanaio.initialize();
        spinbar.initialize();
    }
// ============= BOTTONI =======================================================

    /**
     * Creates a modal pop-up window, i.e. a window that blocks actions om the
     * window which generate it until the pop-up is closed
     *
     * @param message message to be shown in the popup
     */
    public void showPopup(String message) {
        Label label = new Label(message);
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        Scene sc = new Scene(label, 500, 200);
        Stage stage = new Stage();
        stage.setScene(sc);
        stage.setX(100);
        stage.setY(100);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(mainWindow);
        stage.show();
    }
// ============= LISTENERS DEI BOTTONI =========================================

    public void start(Stage primaryStage) {

        Scene scene = new Scene(this.prepareSceneContent(), 800, 500);
        mainWindow = primaryStage;
        primaryStage.setTitle("Slot Machine");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    class MyButton extends Button {

        MyButton(String label, boolean isDisabled, EventHandler listener) {
            super(label);
            setMinSize(50, 50);
            setDisable(isDisabled);
            addEventHandler(ActionEvent.ACTION, listener);
        }
    }

    class ListenerNuovaPartitaButton implements EventHandler {

        /**
         * Controlla se è possibile avviae una nuova partita, e se sì regola i
         * conti e inizializza
         *
         * @param t L'evento scatenante
         */
        public void handle(Event t) {
            if (creditBox.getValue() < COSTO_PARTITA) {
                showPopup("Non hai credito sufficente");
            } else {
                spinbar.initialize();
                creditBox.incrementValue(-COSTO_PARTITA);
                punteggioBox.setValue(PUNTI_PER_PARTITA);
            }
        }
    }
// =============================================================================

    class ListenerPayButton implements EventHandler {

        /**
         * Paga la vincita e resetta allo stato iniziale
         *
         * @param t L'evento scatenante
         */
        public void handle(Event t) {
            //System.out.println("PayButton pushed");
            int euro = creditBox.getValue() / 100;
            String message = "Hai vinto " + euro + " Euro";
            showPopup(message);
            reset();
        }
    }

    class ListenerSpinButton implements EventHandler {

        /**
         * Richiedi che sia effettuato uno spin
         *
         * @param t L'evento scatenante
         */
        public void handle(Event t) {
            //System.out.println("SpinButton pushed");
            spinbar.spinAll();
        }
    }

}
