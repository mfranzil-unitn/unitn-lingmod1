package esame201607.views;

import esame201607.Squadra;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.Collections;
import java.util.List;

public class Classifica extends GridPane {
    public Classifica(List<Squadra> squadre) {
        Collections.sort(squadre);
        add(new Text("CLASSIFICA"), 0, 0);
        for (int i = 0; i < squadre.size(); i++) {
            add(new Text(String.valueOf(squadre.get(i).getPunti())), 0, i + 1);
            add(new Text(squadre.get(i).toString()), 1, i + 1);
            add(squadre.get(i).getBandiera(), 2, i + 1);
        }
        setPadding(new Insets(20, 20, 20, 20));
        setVgap(20);
        setHgap(20);
    }
}
