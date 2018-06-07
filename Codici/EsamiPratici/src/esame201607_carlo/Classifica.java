package esame201607_carlo;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * * Classe rappresentante una classifica calcistica
 *
 * @author Carlo Corradini
 */
public class Classifica {

    private final Girone girone;

    /**
     * Costruttore della classe che rappresenta la classifica calcistica
     *
     * @param girone Girone della classifica
     */
    public Classifica(Girone girone) {
        this.girone = girone;
    }

    /**
     * Ritorna la classifica delle squadre in forma grafica
     *
     * @return Pannello grafico della classifica
     */
    public GridPane getPaneClassifica() {
        GridPane pane = new GridPane();
        Squadra[] squadre = girone.getSquadre().clone();

        for (int i = 0; i < squadre.length; i++) {
            for (int j = i + 1; j < squadre.length; j++) {
                if (squadre[i].compareTo(squadre[j]) < 0) {
                    Squadra sqTmp = squadre[i];
                    squadre[i] = squadre[j];
                    squadre[j] = sqTmp;
                }
            }
        }
        for (int i = 0; i < squadre.length; i++) {
            Text punti = new Text(Integer.toString(squadre[i].getPunti()));
            Text nome = new Text(squadre[i].getNome());
            Bandiera bandiera = squadre[i].getBandiera();
            pane.add(punti, 0, i);
            pane.add(nome, 1, i);
            pane.add(bandiera, 2, i);
        }
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setMinWidth(300);
        return pane;
    }
}
