/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luca_201606;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author lucamartinelli
 */
public class Controlli extends VBox {
    
    Button dx,sx,up,down,random,start,stop;
    int copia[][] = new int[8][8];
    Stage secondStage;
    
    Controlli(Terreno celle[][],Griglia grid){
        
        crea_Copia(celle);
            
        dx = new Button();
        dx.setText("Destra");
        dx.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                for(int i = 0; i < 8;i++){
                    for(int j = 7; j > -1;j--){
                        if(copia[i][j]==2){
                            if(j+1<8){
                                if(copia[i][j+1]==1){
                                    celle[i][j].circ = false;
                                    celle[i][j+1].circ = true;
                                    celle[i][j].c.setVisible(false);
                                    celle[i][j+1].c.setVisible(true);
                                    copia[i][j]=1;
                                    copia[i][j+1]=2;
                                }
                            }
                        }    
                    }
                }    
            }
        });

        sx = new Button();
        sx.setText("Sinistra");
        sx.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                for(int i = 0; i < 8;i++){
                    for(int j = 0; j < 8;j++){
                        if(copia[i][j]==2){
                            if(j-1>=0){
                                if(copia[i][j-1]==1){
                                    celle[i][j].circ = false;
                                    celle[i][j-1].circ = true;
                                    celle[i][j].c.setVisible(false);
                                    celle[i][j-1].c.setVisible(true);
                                    copia[i][j]=1;
                                    copia[i][j-1]=2;                
                                }
                            }
                        }    
                    }
                }    
                
            }
        });
        
        up = new Button();
        up.setText("Su");
        up.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                for(int i = 0; i < 8;i++){
                    for(int j = 0; j < 8;j++){
                        if(copia[i][j]==2){
                            if(i-1>=0){
                                if(copia[i-1][j]==1){
                                    celle[i][j].circ = false;
                                    celle[i-1][j].circ = true;
                                    celle[i][j].c.setVisible(false);
                                    celle[i-1][j].c.setVisible(true);
                                    copia[i][j]=1;
                                    copia[i-1][j]=2;
                                }
                            }
                        }    
                    }
                }    
                
            }
        });
        
        down = new Button();
        down.setText("Giù");
        down.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                for(int i = 7; i > -1;i--){
                    for(int j = 0; j < 8;j++){
                        if(copia[i][j]==2){
                            if(i+1<8){
                                if(copia[i+1][j]==1){
                                    celle[i][j].circ = false;
                                    celle[i+1][j].circ = true;
                                    celle[i][j].c.setVisible(false);
                                    celle[i+1][j].c.setVisible(true);
                                    copia[i][j]=1;
                                    copia[i+1][j]=2;
                                }
                            }
                        }    
                    }
                }    
                
            }
        });
        
        random = new Button();
        random.setText("Random");
        random.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
            }
        });

        start = new Button();
        start.setText("Start");
        start.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
            }
        });
        
        stop = new Button();
        stop.setText("Stop");
        stop.setDisable(true);
        stop.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
            }
        });
        
        secondStage = new Stage();
        this.getChildren().addAll(dx,sx,up,down,random,start,stop);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(15);
        Scene scene = new Scene(this);
        secondStage.setX(100);
        secondStage.setTitle("Comandi");
        secondStage.setScene(scene);
        secondStage.show();
    }
    
    public void crea_Copia(Terreno celle[][]){
        for(int i = 0; i < 8;i++){
            for(int j = 0; j < 8;j++){
                if(celle[i][j] instanceof Strada) {
                    if(celle[i][j].circ == true){copia[i][j]=2;}
                        else {copia[i][j]=1;}
                } 
                if(celle[i][j] instanceof Prato) copia[i][j]=0;
                
                System.out.print(copia[i][j]+" ");        
            }
            System.out.println(); 
        }        
    }

}


            