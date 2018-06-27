package esame201409;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * @author Matteo Franzil
 */
public class Pannello extends GridPane {

    Button spin;
    private Button newgame;
    private Button pay;
    private int punteggio;
    private int credito;
    private Text punteggiotxt;
    private Text creditotxt;

    public Pannello(Main main) {
        punteggio = 0;
        credito = 0;
        newgame = new Button("Nuova partita");
        spin = new Button("Spin");
        pay = new Button("Pay");

        newgame.setOnAction((ActionEvent e) -> {
            if (credito < 100) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Credito insufficiente!", ButtonType.OK);
                alert.showAndWait();
            } else {
                setCredito(getCredito() - 100);
                setPunteggio(128);
                pay.setDisable(false);
                spin.setDisable(false);
            }
        });

        pay.setOnAction((ActionEvent e) -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Hai vinto " + getCredito() / 100 + " Euro", ButtonType.OK);
            alert.showAndWait();
            reset(main);
        });

        spin.setDisable(true);
        pay.setDisable(true);

        punteggiotxt = new Text("Punteggio: " + punteggio);
        creditotxt = new Text("Credito " + credito);

        GridPane.setConstraints(newgame, 0, 2);
        GridPane.setConstraints(spin, 1, 2);
        GridPane.setConstraints(pay, 2, 2);
        GridPane.setConstraints(punteggiotxt, 0, 0);
        GridPane.setConstraints(creditotxt, 0, 1);

        setAlignment(Pos.CENTER);
        setPadding(new Insets(0, 20, 60, 20));

        getChildren().addAll(newgame, spin, pay, punteggiotxt, creditotxt);
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
        punteggiotxt.setText("Punteggio: " + this.punteggio);
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
        creditotxt.setText("Credito " + this.credito);
        if (credito <= 0) {
            spin.setDisable(false);
            pay.setDisable(false);
        }
    }

    /**
     * @return the punteggiotxt
     */
    public Text getPunteggiotxt() {
        return punteggiotxt;
    }

    /**
     * @param punteggiotxt the punteggiotxt to set
     */
    public void setPunteggiotxt(Text punteggiotxt) {
        this.punteggiotxt = punteggiotxt;
    }

    public void reset(Main main) {
        setPunteggio(0);
        setCredito(0);
        main.reset();
    }

}
