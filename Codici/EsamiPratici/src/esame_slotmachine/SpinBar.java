/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame_slotmachine;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 *
 * @author Matteo Franzil
 */
public class SpinBar extends HBox {

    private SpinItem roulette1, roulette2, roulette3;

    SpinBar(Pannello panel, Main main) {
        roulette1 = new SpinItem(panel);
        roulette2 = new SpinItem(panel);
        roulette3 = new SpinItem(panel);

        setPadding(new Insets(100, 20, 100, 20));
        setAlignment(Pos.CENTER);
        getChildren().addAll(roulette1, roulette2, roulette3);

        addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            spin(false, panel);
        });
    }

    public boolean checkSymbols() {
        boolean res = false;
        System.out.println(roulette1.getCurrentshape() + "  " + roulette2.getCurrentshape() + "  " + roulette3.getCurrentshape());
        if (roulette1.getCurrentshape() == roulette2.getCurrentshape()
                && roulette2.getCurrentshape() == roulette3.getCurrentshape()) {
            res = true;
        }
        return res;
    }

    public void switchAll() {
        for (int i = 0; i < 3; i++) {
            ((SpinItem) getChildren().get(i)).switchShape();
        }
    }

    public void spin(boolean switchAll, Pannello pannello) {
        if (pannello.getPunteggio() >= 1) {
            if (pannello.getPunteggio() == 1) {
                pannello.setPunteggio(0);
            } else {
                pannello.setPunteggio(pannello.getPunteggio() * 1 / 2);
            }
            if (switchAll) {
                this.switchAll();
            }
            if (this.checkSymbols()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Hai vinto!", ButtonType.OK);
                alert.showAndWait();
                pannello.setCredito(pannello.getCredito() + pannello.getPunteggio() * 100);
                pannello.setPunteggio(0);
            }
        }
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            ((SpinItem) getChildren().get(i)).switchShape(-1);
        }
    }

}
