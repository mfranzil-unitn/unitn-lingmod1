package esame201806P.celle;

import esame201806P.ExplodeTransition;
import esame201806P.Griglia;
import javafx.animation.ParallelTransition;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class CellaBomba extends Cella {

    boolean exploded;

    public CellaBomba(Griglia griglia) {
        super(griglia);

        exploded = false;

        Text punteggioText = new Text("BOOM");
        getChildren().add(punteggioText);
        punteggioText.toBack();

        setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @Override
    protected synchronized void fireAction(Griglia griglia) {
        if (!exploded) {
            exploded = true;
            griglia.blowItUp(this);
            explode();
        }
    }

    @Override
    protected void explode() {
        Circle circ = new Circle(10, Color.BLUE);
        this.toFront();
        getChildren().add(circ);

        ParallelTransition pt = ExplodeTransition.getExplodeTransition(circ, 20);
        pt.play();
        pt.setOnFinished(e -> {
            getChildren().remove(circ);
        });
    }
}
