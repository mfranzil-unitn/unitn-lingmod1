package esame201806P.celle;

import esame201806P.Griglia;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public abstract class Cella extends StackPane {
    public static final int SIZE = 50;

    protected Pane cover;
    private Griglia griglia;

    public Cella(Griglia griglia) {
        this.griglia = griglia;

        setPrefSize(SIZE, SIZE);
        cover = new Pane() {{
            setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        }};
        getChildren().add(cover);

        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        addEventFilter(MouseEvent.MOUSE_CLICKED, this::scopri);
    }

    public final <T extends Event> void scopri(T event) {
        if (isCovered()) {
            fireAction(griglia);
            cover.setVisible(false);
        }
    }

    public final boolean isCovered() {
        return cover.isVisible();
    }

    protected abstract void fireAction(Griglia griglia);

    protected abstract void explode();

    public void changeCover(double delta) {
        cover.setOpacity(cover.getOpacity() + delta);
        if (cover.getOpacity() > 1.0) {
            cover.setOpacity(1.0);
        } else if (cover.getOpacity() < 0) {
            System.out.println("?");
            cover.setOpacity(0.0);
        }
    }
}
