/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luca_201606;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;



/**
 *
 * @author lucamartinelli
 */
public abstract class Terreno extends StackPane{
    boolean circ;
    Rectangle zona;
    Circle c;
    int posi,posj;
    
    Terreno(){
        circ = false;
        zona = new Rectangle(50,50);
        this.getChildren().add(zona);
        c = new Circle(25);
        c.setFill(Color.RED);
        this.getChildren().add(c);
        c.setVisible(circ);
        c.setMouseTransparent(true);
    }
    
}

    
