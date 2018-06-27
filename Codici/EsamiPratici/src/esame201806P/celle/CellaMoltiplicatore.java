package esame201806P.celle;

import esame201806P.ExplodeTransition;
import esame201806P.Griglia;
import javafx.animation.ParallelTransition;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class CellaMoltiplicatore extends Cella {

    public CellaMoltiplicatore(Griglia griglia) {
        super(griglia);
        Text punteggioText = new Text("*2");
        getChildren().add(punteggioText);
        punteggioText.toBack();

        setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @Override
    protected synchronized void fireAction(Griglia griglia) {
        griglia.setPunteggio(griglia.getPunteggio() * 2);
        explode();
    }

    @Override
    protected void explode() {
        Text txt = new Text("*2");
        txt.setFill(Color.GREEN);
        this.toFront();
        getChildren().add(txt);

        ParallelTransition pt = ExplodeTransition.getExplodeTransition(txt, 20);
        pt.play();
        pt.setOnFinished(e -> {
            getChildren().remove(txt);
        });
    }
}
