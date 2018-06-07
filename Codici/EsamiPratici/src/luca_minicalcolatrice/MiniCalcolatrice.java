package luca_minicalcolatrice;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author lucamartinelli
 * 
 */
public class MiniCalcolatrice extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Text title = new Text("MiniCalcolatrice");
        title.setFont(Font.font(30));
        Text left = new Text("left");
        Text right = new Text("right");
        Text signature = new Text("@lucamartinelli");
 
        TextField member1 = new TextField();
        TextField member2 = new TextField();
        TextField member3 = new TextField();
        
        Button piu = new Button("Più");
        Button meno = new Button("Meno");
        Button per = new Button("Per");
        Button diviso = new Button("Diviso");
 
        piu.setOnMouseClicked(new EventHandler(){
           @Override
           public void handle(Event event) {
               try{
               float a1=Float.parseFloat(member1.getText());
               float a2=Float.parseFloat(member2.getText());
               float res=a1+a2;
               member3.setText(res+"");
               }
               catch(Exception a){
                   member3.setText("* ERRORE *");
               }
           }    
        });
       
        meno.setOnMouseClicked(new EventHandler(){
           @Override
           public void handle(Event event) {
               try{
                float a1=Float.parseFloat(member1.getText());
                float a2=Float.parseFloat(member2.getText());
                float res=a1-a2;
                member3.setText(res+"");
               }
               catch(Exception a){
                   member3.setText("* ERRORE *");
               }
           }    
        });
       
        per.setOnMouseClicked(new EventHandler(){
           @Override
           public void handle(Event event) {
               try{
               float a1=Float.parseFloat(member1.getText());
               float a2=Float.parseFloat(member2.getText());
               float res=a1*a2;
               member3.setText(res+"");
               }
               catch(Exception a){
                   member3.setText("* ERRORE *");
               }
           }    
        });
       
        diviso.setOnMouseClicked(new EventHandler(){
           @Override
           public void handle(Event event) {
               try{
               float a1=Float.parseFloat(member1.getText());
               float a2=Float.parseFloat(member2.getText());
               double res=(a1/(a2*1.0));
               member3.setText(res+"");
               }
               catch(Exception a){
                   member3.setText("* ERRORE *");
               }
           }    
        });
        
        HBox pulsanti = new HBox();
        pulsanti.getChildren().addAll(piu, meno ,per, diviso);
        
        VBox campo = new VBox();
        campo.getChildren().addAll(member1, member2, pulsanti, member3);
        
        StackPane corpoleft = new StackPane(left);
        corpoleft.setPrefWidth(100);
        StackPane corporight = new StackPane(right);
        corporight.setPrefWidth(100);
        
        BorderPane primaryroot = new BorderPane();
        primaryroot.setTop(title);
        primaryroot.setLeft(corpoleft);
        primaryroot.setRight(corporight);
        primaryroot.setBottom(signature);
        primaryroot.setCenter(campo);
        
        BorderPane.setAlignment(title, Pos.TOP_CENTER);
        BorderPane.setAlignment(signature, Pos.BOTTOM_RIGHT);
        
        Scene scene = new Scene(primaryroot);
        primaryStage.setScene(scene);
        primaryStage.show();
       
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}