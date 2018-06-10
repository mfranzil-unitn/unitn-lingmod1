package luca_esame201409;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Questa classe ha la responsabilità di mantenere il valore di una entità e di
 * mostrarla nella GUI. Sulla base del proprio valore controlla l'abilitazione
 * di un bottone associato.
 *
 * @author ronchet
 */
public class ValueBox extends VBox {

    TextField txt = null;
    private int value = 0;
    Button associatedButton = null;

    public ValueBox(String label, Button associatedButton) {
        this.associatedButton = associatedButton;
        txt = new TextField("--");
        txt.setEditable(false);
        txt.setAlignment(Pos.CENTER_RIGHT);
        Label space = new Label(" ");
        Label lbl = new Label(label);

        this.getChildren().addAll(txt, space, lbl);
        this.setAlignment(Pos.CENTER);
    }

    public void reset() {
        setValue(0);
    }

    public void setValue(int value) {
        this.value = value;
        txt.setText(String.valueOf(value));
        associatedButton.setDisable(value == 0);
    }

    public int getValue() {
        return value;
    }

    public void incrementValue(int delta) {
        setValue(value + delta);
    }
}
