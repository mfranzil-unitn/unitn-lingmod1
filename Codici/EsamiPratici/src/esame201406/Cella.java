/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201406;

import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Matteo Franzil
 */
public class Cella extends StackPane {
    Circle circ;
    private boolean recentlyMoved;
    public Cella() {
        circ = new Circle(Griglia.BASESIZE, Color.CORNFLOWERBLUE);
        recentlyMoved = false;
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        circ.setVisible(false);
        getChildren().add(circ);
        
        addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            switchCirc();
        });
    }
    
    public boolean isCircVisible() {
        return circ.isVisible();
    }
    
    public void switchCirc() {
        if (circ.isVisible()) {
                circ.setVisible(false);
            } else {
                circ.setVisible(true);
            }
    }
    
    public void setCircleVisible(boolean isVisible) {
        if (isVisible) {
            circ.setVisible(true);
        } else {
            circ.setVisible(false);
        }
    }

    /**
     * @return the recentlyMoved
     */
    public boolean isRecentlyMoved() {
        return recentlyMoved;
    }

    /**
     * @param recentlyMoved the recentlyMoved to set
     */
    public void setRecentlyMoved(boolean recentlyMoved) {
        this.recentlyMoved = recentlyMoved;
    }
    
}
