/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201606;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

/**
 *
 * @author Matteo Franzil
 */
public class ToolBar extends FlowPane {

    private Text autodisponibili;
    private Button inizia;
    private ToggleButton addauto;

    public ToolBar(Griglia griglia) {
        autodisponibili = new Text("Auto disponibili: " + Macchina.getMacchinedisponibili());
        addauto = new ToggleButton("Aggiungi auto");
        inizia = new Button("Inizia");

        addauto.setOnAction((ActionEvent e) -> {
            griglia.setAddCarMode(!griglia.isAddCarMode());
        });

        inizia.setOnAction((ActionEvent e) -> {
            ControlPanel pannello = new ControlPanel(griglia);
            inizia.setDisable(true);
            Node temp = griglia.standardGetElementAt(0, 0);
            System.out.println(temp);
        });

        getChildren().addAll(autodisponibili, addauto, inizia);
        setPadding(new Insets(10, 10, 10, 10));
        setMargin(addauto, new Insets(0, 5, 0, 5));
    }

    public void setAuto() {
        this.autodisponibili.setText("Auto disponibili " + Macchina.getMacchinedisponibili());
        if (Macchina.getMacchinedisponibili() == 0) {
            addauto.setDisable(true);
        }
    }

    public int getAuto() {
        return Macchina.getMacchinedisponibili();
    }

}
