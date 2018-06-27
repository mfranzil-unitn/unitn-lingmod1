package esame201806P.celle;

import esame201806P.Griglia;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Cella extends StackPane {
    public static final int SIZE = 50;

    protected Rectangle cover;
    private Griglia griglia;

    public Cella(Griglia griglia) {
        this.griglia = griglia;

        setPrefSize(SIZE, SIZE);
        cover = new Rectangle(0, 0, getPrefWidth() - 2, getPrefHeight() - 2);
        cover.setFill(Color.YELLOW);
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

}
