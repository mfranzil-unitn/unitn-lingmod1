package esame201806P;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class ExplodeTransition {
    public static ParallelTransition getExplodeTransition(Node node, double size) {
        ScaleTransition st = new ScaleTransition(Duration.millis(2000), node);
        st.setByX(size);
        st.setByY(size);
        FadeTransition ft = new FadeTransition(Duration.millis(2000), node);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        return new ParallelTransition(st, ft);
    }
}
