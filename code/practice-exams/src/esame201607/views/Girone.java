package esame201607.views;

import esame201607.Squadra;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Girone extends GridPane {

    public static final int MAX_GOALS = 10;
    private List<Squadra> squadre;
    private Giornata g1, g2, g3;
    private Classifica cl;

    public Girone(Color bg, List<Squadra> squadre) {
        if (squadre.size() != 4) {
            throw new IllegalArgumentException("Richieste 4 squadre!");
        }
        this.squadre = squadre;

        setPrefSize(400, 400);
        setBackground(new Background(new BackgroundFill(bg, new CornerRadii(20), Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID,
                new CornerRadii(20), new BorderWidths(3))));
        setPadding(new Insets(10, 10, 10, 10));

        g1 = new Giornata(1, squadre);
        g2 = new Giornata(2, squadre);
        g3 = new Giornata(3, squadre);

        cl = new Classifica(squadre);

        add(g1, 0, 0);
        add(g2, 0, 1);
        add(g3, 0, 2);
        add(cl, 0, 3);
    }

    public void calcola(int giornata) {
        switch (giornata) {
            case 1:
                g1.calcola();
                break;
            case 2:
                g2.calcola();
                break;
            case 3:
                g3.calcola();
                break;
        }
        getChildren().remove(cl);
        cl = new Classifica(squadre);
        add(cl, 0, 3);
        System.gc();
        System.runFinalization();
    }

    public List<Squadra> getQualificate() {
        Collections.sort(squadre);
        return Arrays.asList(squadre.get(0), squadre.get(1));
    }

}
