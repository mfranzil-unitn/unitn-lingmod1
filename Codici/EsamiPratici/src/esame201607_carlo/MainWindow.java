package esame201607_carlo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * Classe rappresentante una la grafica della classifica
 *
 * @author Carlo Corradini
 */
public class MainWindow extends GridPane {

    private final Girone g1;
    private final Girone g2;
    private final Girone g3;
    private final Girone g4;

    /**
     * Costruttore della classe che rappresenta la grafica della schemata
     * principale
     */
    public MainWindow() {
        super.setHgap(15);
        super.setVgap(15);
        super.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        super.setAlignment(Pos.CENTER);
        Squadra italia = new Squadra("Italia", new BandieraTreFasceVerticali(Color.rgb(0, 146, 70), Color.rgb(241, 242, 241), Color.rgb(206, 43, 55)));
        Squadra austria = new Squadra("Austria", new BandieraTreFasceOrizzontali(Color.rgb(237, 41, 57), Color.rgb(255, 255, 255), Color.rgb(237, 41, 57)));
        Squadra francia = new Squadra("Francia", new BandieraTreFasceVerticali(Color.rgb(0, 85, 164), Color.rgb(255, 255, 255), Color.rgb(239, 65, 53)));
        Squadra germania = new Squadra("Germania", new BandieraTreFasceOrizzontali(Color.rgb(0, 0, 0), Color.rgb(221, 0, 0), Color.rgb(255, 206, 0)));
        g1 = new Girone(italia, austria, francia, germania);

        Squadra olanda = new Squadra("Olanda", new BandieraTreFasceOrizzontali(Color.rgb(174, 28, 40), Color.rgb(255, 255, 255), Color.rgb(33, 70, 139)));
        Squadra bulgaria = new Squadra("Bulgaria", new BandieraTreFasceOrizzontali(Color.rgb(255, 255, 255), Color.rgb(0, 150, 110), Color.rgb(214, 38, 18)));
        Squadra russia = new Squadra("Russia", new BandieraTreFasceOrizzontali(Color.rgb(255, 255, 255), Color.rgb(0, 57, 166), Color.rgb(213, 43, 30)));
        Squadra spagna = new Squadra("Spagna", new BandieraTreFasceOrizzontali(Color.rgb(170, 21, 27), Color.rgb(241, 191, 0), Color.rgb(170, 21, 27)));
        g2 = new Girone(olanda, bulgaria, russia, spagna);

        Squadra svezia = new Squadra("Svezia", new BandieraCroce(Color.rgb(254, 204, 0), Color.rgb(0, 106, 167)));
        Squadra belgio = new Squadra("Belgio", new BandieraTreFasceVerticali(Color.rgb(0, 0, 0), Color.rgb(255, 233, 54), Color.rgb(255, 15, 33)));
        Squadra irlanda = new Squadra("Irlanda", new BandieraTreFasceVerticali(Color.rgb(0, 154, 73), Color.rgb(255, 255, 255), Color.rgb(255, 121, 0)));
        Squadra ungheria = new Squadra("Ungheria", new BandieraTreFasceOrizzontali(Color.rgb(205, 42, 62), Color.rgb(255, 255, 255), Color.rgb(67, 111, 77)));
        g3 = new Girone(svezia, belgio, irlanda, ungheria);

        Squadra finlandia = new Squadra("Finlandia", new BandieraCroce(Color.rgb(0, 53, 128), Color.rgb(255, 255, 255)));
        Squadra danimarca = new Squadra("Danimarca", new BandieraCroce(Color.rgb(255, 255, 255), Color.rgb(208, 12, 51)));
        Squadra polonia = new Squadra("Polonia", new BandieraDueFasceOrizzontali(Color.rgb(255, 255, 255), Color.rgb(220, 20, 60)));
        Squadra ucraina = new Squadra("Ucraina", new BandieraDueFasceOrizzontali(Color.rgb(0, 91, 187), Color.rgb(255, 213, 0)));
        g4 = new Girone(finlandia, danimarca, polonia, ucraina);

        super.add(g1.getRiassunto(Color.WHITE), 0, 0);
        super.add(g2.getRiassunto(Color.YELLOW), 1, 0);
        super.add(g3.getRiassunto(Color.YELLOW), 0, 1);
        super.add(g4.getRiassunto(Color.WHITE), 1, 1);
    }

    /**
     * Funzione che permette il gioco delle partite all'interno dei vari gironi
     *
     * @param n Giornata da giocare
     */
    public void toStep(int n) {
        g1.giocaGiornata(n);
        g2.giocaGiornata(n);
        g3.giocaGiornata(n);
        g4.giocaGiornata(n);
        super.getChildren().clear();
        super.add(g1.getRiassunto(Color.WHITE), 0, 0);
        super.add(g2.getRiassunto(Color.YELLOW), 1, 0);
        super.add(g3.getRiassunto(Color.YELLOW), 0, 1);
        super.add(g4.getRiassunto(Color.WHITE), 1, 1);
    }
}
