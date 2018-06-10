package carlo_201607;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * Classe rappresentante un girone calcistica
 *
 * @author Carlo Corradini
 */
public class Girone {

    private final Giornata[] giornate;
    private final Squadra[] squadre;
    private final Classifica classifica;
    private int giornataGiocata;

    /**
     * Costruttore della classe che rappresenta un girone calcistico
     *
     * @param sq1 Squadra 1
     * @param sq2 Squadra 2
     * @param sq3 Squadra 3
     * @param sq4 Squadra 4
     */
    public Girone(Squadra sq1, Squadra sq2, Squadra sq3, Squadra sq4) {
        giornate = new Giornata[3];
        giornate[0] = new Giornata(sq1, sq2, sq3, sq4);
        giornate[1] = new Giornata(sq1, sq2, sq3, sq4);
        giornate[2] = new Giornata(sq1, sq2, sq3, sq4);
        squadre = new Squadra[4];
        squadre[0] = sq1;
        squadre[1] = sq2;
        squadre[2] = sq3;
        squadre[3] = sq4;
        classifica = new Classifica(this);
        giornataGiocata = 0;
    }

    /**
     * Ritorna il pannello grafico del girone
     *
     * @param backgroundColor Colore di sfondo
     * @return Girone Graphics
     */
    public VBox getRiassunto(Color backgroundColor) {
        VBox paneGirone = new VBox();
        paneGirone.getChildren().add(new TextFlow(new Text(this.toString())));
        paneGirone.getChildren().add(new TextFlow(new Text("CLASSIFICA")));
        paneGirone.getChildren().add(classifica.getPaneClassifica());
        paneGirone.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
        return paneGirone;
    }

    /**
     * Ritorna le giornate del girone
     *
     * @return Giornate girone
     */
    public Giornata[] getGiornate() {
        return giornate;
    }

    /**
     * Ritorna le squadre del girone
     *
     * @return Squadre girone
     */
    public Squadra[] getSquadre() {
        return squadre;
    }

    /**
     * Ritorna la classifica del girone
     *
     * @return Classifica girone
     */
    public Classifica getClassifica() {
        return classifica;
    }

    /**
     * Ritorna la giornata giocata, se 0 girone non ancora iniziato
     *
     * @return Giornata giocata
     */
    public int getGiornataGiocata() {
        return giornataGiocata;
    }

    /**
     * Gioca la giornata in base alla giornata passata per parametro
     *
     * @param n Giornata da giocare
     */
    public void giocaGiornata(int n) {
        if (giornataGiocata == n - 1) {
            giornate[giornataGiocata].giocaGiornata();
            giornataGiocata = n;
        }
    }

    @Override
    public String toString() {
        String toRtn = "";
        for (int i = 0; i < giornate.length; i++) {
            toRtn += "=== " + (i + 1) + "a GIORNATA ===\n";
            toRtn += giornate[i].toString();
        }
        return toRtn;
    }
}
