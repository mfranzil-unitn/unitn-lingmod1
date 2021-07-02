package esame201806P.celle;

import esame201806P.Griglia;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Random;

public class CellaBase extends Cella {

    private int punteggio;
    private Text punteggioText;

    public CellaBase(Griglia griglia) {
        super(griglia);
        punteggio = new Random().nextInt(10) * 100 + 100;
        punteggioText = new Text("" + punteggio);
        getChildren().add(punteggioText);
        punteggioText.toBack();

    }

    @Override
    protected synchronized void fireAction(Griglia griglia) {
        griglia.setPunteggio(griglia.getPunteggio() + getPunteggio());
        this.toFront();
        explode();
    }

    public int getPunteggio() {
        return punteggio;
    }

    @Override
    protected void explode() {
        TranslateTransition st = new TranslateTransition(Duration.millis(1000), punteggioText);
        st.setByY(-100f);
        FadeTransition ft = new FadeTransition(Duration.millis(1000), punteggioText);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ParallelTransition pt = new ParallelTransition(st, ft);
        pt.play();
        pt.setOnFinished(e -> {
            Text oldPunteggioText = punteggioText;
            punteggioText = new Text("" + punteggio);
            punteggioText.setOpacity(0.0);
            getChildren().add(punteggioText);

            FadeTransition ft2 = new FadeTransition(Duration.millis(4000), punteggioText);
            ft2.setFromValue(0.0);
            ft2.setToValue(1.0);
            ft2.play();

            ft2.setOnFinished(f -> getChildren().remove(oldPunteggioText));
        });
    }
}
