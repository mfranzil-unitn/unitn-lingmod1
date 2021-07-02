package esame201607.views;

import esame201607.Squadra;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Random;

public class Partita extends HBox {
    Text text1, text2, risultato;
    Squadra s1, s2;
    Risultato<Integer, Integer> ris;

    public Partita(Squadra s1, Squadra s2) {
        this.s1 = s1;
        this.s2 = s2;

        this.text1 = new Text(s1.toString() + "\t\t");
        this.text1.setFont(Font.font("Google Sans", FontWeight.NORMAL, 12));
        this.text2 = new Text(s2.toString() + "\t\t");
        this.text2.setFont(Font.font("Google Sans", FontWeight.NORMAL, 12));
        this.risultato = new Text("");

        setSpacing(20);

        getChildren().addAll(this.text1, this.text2, risultato);
    }

    public static int getPoisson(double lambda) {
        double L = Math.exp(-lambda);
        double p = 1.0;
        int k = 0;

        do {
            k++;
            p *= new Random().nextFloat();
        } while (p > L);

        return k - 1;
    }

    public Risultato<Integer, Integer> calcola(boolean pareggioAmmesso) {
        double pareggio = new Random().nextDouble();
        Risultato<Integer, Integer> risultato;
        if (pareggio < 0.3 && pareggioAmmesso) {
            int gol = getPoisson(Girone.MAX_GOALS / 4);
            risultato = new Risultato<>(gol, gol);
        } else {
            int gol1 = getPoisson(Girone.MAX_GOALS / 4);
            int gol2 = getPoisson(Girone.MAX_GOALS / 4);
            if (gol1 == gol2) {
                if (new Random().nextDouble() < 0.5)
                    gol1++;
                else
                    gol2++;
            }
            risultato = new Risultato<>(gol1, gol2);
        }
        this.risultato.setText(risultato.toString());
        if (!pareggioAmmesso) {
            this.ris = risultato;
        }
        return risultato;
    }

    public void setPareggio() {
        s1.aggiungiPunti(1);
        s2.aggiungiPunti(1);
    }

    public void setVittoria() {
        s1.aggiungiPunti(3);
    }

    public void setSconfitta() {
        s2.aggiungiPunti(3);
    }

    @Override
    public String toString() {
        return s1 + ":" + s2 + "\t\t" + risultato.getText();
    }

    public Squadra getVincente() {
        Squadra res = null;
        if (ris != null && ris.isVittoria()) {
            res = s1;
        } else if (ris != null && ris.isSconfitta()) {
            res = s2;
        }
        return res;
    }
}