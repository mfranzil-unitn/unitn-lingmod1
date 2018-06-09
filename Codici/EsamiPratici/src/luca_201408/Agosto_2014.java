/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luca_201408;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Cirogiu
 */
public class Agosto_2014 extends Application {

    Dado tutti_dadi[] = new Dado[5];
    double posx, posy;
    static int punt = 30;
    static int tot = 0;
    static Text totale = new Text("Totale: 0");
    static Text punteggio = new Text("Punteggio: 30");
    static boolean vittoria;

    // Label totale, punteggio;
    @Override
    public void start(Stage primaryStage) {
        vittoria = false;
        BorderPane primaryRoot = new BorderPane();
        Button nuovaPartita = new Button("Nuova partita");
        Button spos_diss = new Button("Spostamento");
        Button stampa = new Button("Stampa");
        HBox top = new HBox(nuovaPartita, stampa, spos_diss);
        HBox bottom = new HBox(totale, punteggio);

        //EVENTO DEL PULSANTE NUOVA PARTITA
        nuovaPartita.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (spos_diss.getText().equals("Spostamento")) {
                    spostamento(primaryRoot);
                } else {
                    cancellazione(primaryRoot);
                }
            }
        });

        //BOTTONE SPOSTAMENTO/DISSOLVIMENTO
        spos_diss.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (spos_diss.getText().equals("Spostamento")) {
                    spos_diss.setText("Dissolvimento");
                } else {
                    spos_diss.setText("Spostamento");
                }

            }
        });

        // AZIONE DA GESTIRE SE CLICCO IL CAMPO VERDE
        Rectangle campo = new Rectangle(400, 300, Color.GREEN);
        campo.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (vittoria != true) {
                    if (Dado.max_count < 5) {
                        posx = ((MouseEvent) event).getX();
                        posy = ((MouseEvent) event).getY();
                        Dado d = new Dado(posx, posy, primaryRoot);
                        tutti_dadi[Dado.max_count - 1] = d;
                    }
                }
            }
        });

        //EVENTO DEL BOTTONE STAMPA
        EventHandler printer = new EventHandler() {
            @Override
            public void handle(Event event) {
                Text testo_stampa = new Text("Elenco dei dadi:\n\n");
                for (int i = 0; i < Dado.max_count; i++) {
                    updateTextStampa(tutti_dadi[i], testo_stampa);
                }
                testo_stampa.setText(testo_stampa.getText() + "\n\nTotale: " + tot + "\nPunteggio: " + punt);
                StackPane root = new StackPane(testo_stampa);
                Scene scena = new Scene(root, 300, 250);
                Stage stage = new Stage();
                stage.setScene(scena);
                stage.setResizable(false);
                stage.show();
            }
        };

        //EVENTO DI VERIFICA DELLA VITTORIA!
        EventHandler<MouseEvent> vincita = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (tot == 15) {
                    vittoria();
                    vittoria = true;
                }
            }
        };

        stampa.addEventHandler(ActionEvent.ACTION, printer);

        top.setAlignment(Pos.TOP_CENTER);

        primaryRoot.setTop(top);
        primaryRoot.setCenter(campo);
        primaryRoot.setBottom(bottom);

        EventHandler<KeyEvent> press;
        press = new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                ActionEvent t;
                switch (event.getCode()) {
                    case S:
                        stampa.fireEvent(t = new ActionEvent());
                        break;
                    case N:
                        nuovaPartita.fireEvent(t = new ActionEvent());
                }
            }

        };

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, press);

        Scene scena = new Scene(primaryRoot);
        primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, vincita);
        primaryStage.setScene(scena);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    /**
     * Funzione che aggiorna il Testo del totale.
     *
     * @param d: il dado che, col suo valore, aggiorna il testo.
     * @param testo_stampa: il testo della classe Text da aggiornare.
     */
    void updateTextStampa(Dado d, Text testo_stampa) {
        String temp = testo_stampa.getText();
        testo_stampa.setText(temp + d + "\n");
    }

    /**
     * Funzione che aggiorna il Testo del punteggio.
     *
     * @param punt: variabile che tiene conto degli aggiornamenti del punteggio.
     * @param punteggio: il testo della classe Text da aggiornare.
     */
    static void updateTextScore(int punt) {
        punteggio.setText("Punteggio: " + punt);
    }

    static void updateTextTotale(int tot) {
        totale.setText("Totale: " + tot);
    }

    public static void main(String[] args) {
        launch(args);
    }

    void cancellazione(BorderPane root) {
        for (int i = 0; i < Dado.max_count; i++) {
            tutti_dadi[i].disappear(root);
        }
        reset();
    }

    void spostamento(BorderPane primaryRoot) {
        for (int i = 0; i < Dado.max_count; i++) {
            tutti_dadi[i].movement(primaryRoot);
        }
        reset();
    }

    void vittoria() {
        Text winner = new Text("Hai vinto!\nHai ottenuto " + punt + " punti");
        winner.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BLACK, 40));
        StackPane a = new StackPane(winner);
        Scene scena = new Scene(a);
        Stage stage = new Stage();
        stage.setScene(scena);
        stage.show();
    }

    void reset() {
        Dado.max_count = 0;
        tot = 0;
        punt = 30;
        updateTextTotale(tot);
        updateTextScore(punt);
        vittoria = false;
    }
}
