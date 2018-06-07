package esame201707_carlo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Classe rappresentante il Campo
 *
 * @author Carlo Corradini
 */
public class Campo extends Pane {

    /**
     * Numero massimo di dadi ammessi sul Campo
     */
    public static final int MAX_DADI_ON_CAMPO = 3;
    private int ctrDadiOnCampo;
    private int contatore;
    private final ArrayList<Dado> dadi;
    private final Label lblContatore;

    /**
     * Costruttore Campo
     *
     * @param size Grandezza in pixel del campo
     * @param lblContatore Riferimento alla Label per il contatore
     */
    public Campo(int size, Label lblContatore) {
        super.setPrefSize(size, size);
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        super.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        ctrDadiOnCampo = 0;
        contatore = 10;
        dadi = new ArrayList<>(MAX_DADI_ON_CAMPO);
        this.lblContatore = lblContatore;
        updateLblContatore();
        handleClick();
    }

    /**
     * Ritorna il contatore
     *
     * @return contatore
     */
    public int getContatore() {
        return contatore;
    }

    private void handleClick() {
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            if (ctrDadiOnCampo < MAX_DADI_ON_CAMPO) {
                try {
                    Dado dado = new Dado(event.getX(), event.getY(), new Random(System.currentTimeMillis()).nextInt(Dado.MAX_VALUE) + 1, this);
                    this.getChildren().add(dado);
                    ctrDadiOnCampo++;
                    dadi.add(dado);
                } catch (IllegalDadoValueException ex) {
                    System.err.println("[ERRORE]: " + ex.getMessage());
                }
            }
            checkVictory();
        });
    }

    /**
     * Verifica la vittoria sul campo
     */
    public void checkVictory() {
        if (ctrDadiOnCampo >= MAX_DADI_ON_CAMPO) {
            Collections.sort(dadi);
            boolean inOrdine = true;
            for (int i = 0; i < (dadi.size() - 1) && inOrdine; i++) {
                if (dadi.get(i).getValue() != dadi.get(i + 1).getValue() - 1) {
                    inOrdine = false;
                }
            }
            if (inOrdine) {
                showAlert("HAI VINTO");
            }
        }
    }

    /**
     * Diminuisce il contatore
     */
    public void decrementaContatore() {
        contatore--;
        updateLblContatore();
        if (contatore <= 0) {
            showAlert("HAI PERSO");
        }
    }

    private void showAlert(String headerText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informazione");
        alert.setHeaderText(headerText);
        alert.setContentText("Tentativi rimanenti: " + contatore);
        alert.setOnCloseRequest((DialogEvent event) -> {
            Platform.exit();
            System.exit(0);
        });
        alert.show();
    }

    /**
     * Resetta il campo, ovvero il gioco
     *
     * @param isDissolve Selettore animazione
     */
    public void reset(boolean isDissolve) {
        for (int i = 0; i < dadi.size(); i++) {
            if (isDissolve) {
                dadi.get(i).dissolve();
            } else {
                dadi.get(i).moveAway();
            }
        }
        contatore = 10;
        updateLblContatore();
    }

    /**
     * Rimuove il dadp dal Campo e dalla lista dei dadi
     *
     * @param dado Il dado da eliminare
     */
    public void remove(Dado dado) {
        dadi.remove(dado);
        super.getChildren().remove(dado);
        if (dadi.isEmpty()) {
            ctrDadiOnCampo = 0;
        }
    }

    /**
     * Apre una nuova finestra con un riassunto dei Dadi presenti sul campo e il
     * loro relativo valore
     */
    public void printDadi() {
        int i, ctrValues;
        GridPane root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);
        root.add(new Label("FIGURA DADO"), 0, 0);
        root.add(new Label("VALORE"), 1, 0);
        for (i = 0, ctrValues = 0; i < dadi.size(); i++) {
            try {
                Dado dado = dadi.get(i).copy();
                dado.setDisable(true);
                root.add(dado, 0, i + 1);
                root.add(new Label(Integer.toString(dado.getValue())), 1, i + 1);
                ctrValues += dado.getValue();
            } catch (IllegalDadoValueException ex) {
                System.err.println("[ERRORE]: " + ex.getMessage());
            }
        }
        Label label = new Label("TOTALE");
        label.setTextFill(Color.RED);
        label.setFont(new Font("Century Gothic", 18));
        root.add(label, 0, ++i);
        root.add(new Label(Integer.toString(ctrValues)), 1, i);
        label = new Label("PUNTEGGIO");
        label.setTextFill(Color.RED);
        label.setFont(new Font("Century Gothic", 18));
        root.add(label, 0, ++i);
        root.add(new Label(Integer.toString(contatore)), 1, i);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Resoconto");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();
    }

    private void updateLblContatore() {
        lblContatore.setText("CONTATORE: " + contatore + " tentativi rimanenti");
    }

    @Override
    public String toString() {
        String toRtn = "[";
        for (Dado dado : dadi) {
            toRtn += "{" + dado.getValue() + "}";
        }
        toRtn += "]";
        return toRtn;
    }
}
