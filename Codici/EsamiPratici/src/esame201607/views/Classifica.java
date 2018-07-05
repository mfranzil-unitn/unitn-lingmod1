package esame201607.views;

import esame201607.Squadra;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Collections;
import java.util.List;

public class Classifica extends GridPane {
    public Classifica(List<Squadra> squadre) {
        Collections.sort(squadre);
        add(new Text("CLASSIFICA") {{
                setFont(Font.font("Google Sans", FontWeight.NORMAL, 18));
            }},
                0, 0, 3, 1);
        for (int i = 0; i < squadre.size(); i++) {
            add(squadre.get(i).getBandiera(), 0, i + 1);
            add(new Text(String.valueOf(squadre.get(i).getPunti())), 1, i + 1);
            add(new Text(squadre.get(i).toString()), 2, i + 1);
        }
        setPadding(new Insets(15));
        setVgap(10);
        setHgap(10);
    }
}
