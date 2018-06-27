package esame201607.views;

import esame201607.Squadra;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.List;

public class Giornata extends VBox {
    private Partita p1, p2;
    Giornata(int index, List<Squadra> squadre) {
        Text text = new Text("===" + index + "a Giornata ===");
        switch(index) {
            case 1: // 1-2 3-4
                p1 = new Partita(squadre.get(0), squadre.get(1));
                p2 = new Partita(squadre.get(2), squadre.get(3));
                break;
            case 2: // 1-3 2-4
                p1 = new Partita(squadre.get(0), squadre.get(2));
                p2 = new Partita(squadre.get(1), squadre.get(3));
                break;
            case 3: // 1-4 2-3
                p1 = new Partita(squadre.get(0), squadre.get(3));
                p2 = new Partita(squadre.get(1), squadre.get(2));
                break;
        }
        getChildren().addAll(text, p1, p2);
    }

    public void calcola() {
        Risultato<Integer, Integer> r1 = p1.calcola(true);
        handleRisultato(r1, p1);

        Risultato<Integer, Integer> r2 = p2.calcola(true);
        handleRisultato(r2, p2);
    }

    private void handleRisultato(Risultato<Integer, Integer> r, Partita p) {
        if (r.isPareggio()) {
            p.setPareggio();
        } else if (r.isVittoria()) {
            p.setVittoria();
        } else if (r.isSconfitta()) {
            p.setSconfitta();
        }
    }
}