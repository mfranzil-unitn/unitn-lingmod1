
package luca_201409;
import luca_201409.SlotMachine;
import java.awt.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;

public class Moneta extends javafx.scene.Group {
    public Moneta(){
    
        Circle circle = new Circle(40);
        circle.setFill(Color.LIGHTBLUE);
        circle.setStroke(Color.BLACK);
        Text s = new Text ("1 Euro");
        s.setLayoutX(-20);
        s.setLayoutY(5);
      
        this.getChildren().addAll(circle,s);
    }    
}
