/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luca_campominato;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author lucamartinelli
 */
public class CampoMinato {
    
    static Button perso;
    static Stage loseStage;
    static StackPane loseRoot;
    static Scene loseScene;
    
    static Button vinto;
    static Stage winStage;
    static StackPane winRoot;   
    static Scene winScene;
    
    static BorderPane border;
    static Scene scene;
    static Stage stage;
    static Griglia g;
    static Cella celle[][];
    static Bottoni btn;
    
    static int tot = 15;

    CampoMinato() {

        border = new BorderPane();
        celle = new Cella[5][5];
        g = new Griglia(5, celle);
        btn = new Bottoni();
        stage = new Stage();

        border.setCenter(g);
        border.setBottom(btn);

        scene = new Scene(border);

        stage.setTitle(" Campo Minato ");
        stage.setScene(scene);
        stage.show();
        stage.setMinHeight(300);
        stage.setMinWidth(450);

    }

    public static void controlla() {
        if (tot < 0) { 
            lose();
        } 
        if(tot == 0){
            win();
          
        }
       
    }

    public static void lose() {
        perso = new Button("Hai Perso!");
        loseStage = new Stage();
        loseRoot = new StackPane();

        perso.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                nuovaPartita();
                loseStage.close();
            }
        });
        loseStage.setOnCloseRequest(new EventHandler() {
            @Override
            public void handle(Event event) {
                stage.close();
            }
        });
        loseRoot.getChildren().add(perso);

        loseScene = new Scene(loseRoot, 250, 150);
        loseStage.setY(stage.getY());
        loseStage.setX(stage.getX() + stage.getWidth());
        loseStage.setTitle("Hai Perso!");
        loseStage.setScene(loseScene);
        loseStage.show();

    }

    public static void win() {
        vinto = new Button("Hai Vinto!");
        winStage = new Stage();
        winRoot = new StackPane();

        vinto.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                nuovaPartita();
                winStage.close();
            }
        });
        
        winStage.setOnCloseRequest(new EventHandler() {
            @Override
            public void handle(Event event) {
                stage.close();
            }
        });

        winRoot.getChildren().add(vinto);
        
        winScene = new Scene(winRoot, 250, 150);
        winStage.setY(stage.getY());
        winStage.setX(stage.getX() + stage.getWidth());
        winStage.setTitle("Hai Vinto!");
        winStage.setScene(winScene);
        winStage.show();
    }
    
    public static void nuovaPartita(){
        border.getChildren().remove(g);
        Griglia.conta = 0;
        tot = 15;
        g = new Griglia(5,celle);
        btn = new Bottoni();
        border.setCenter(g);
        border.setBottom(btn);
        
    }

}
