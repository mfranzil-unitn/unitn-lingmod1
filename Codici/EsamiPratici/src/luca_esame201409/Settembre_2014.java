package luca_esame201409;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Settembre_2014 extends Application {

    BorderPane root;
    Button nuovaPartita, spin, pay;
    Text credit, credit_text, punt, punt_text;
    Label title;
    Slot slot[] = new Slot[3];
    Money money[] = new Money[3];

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();
        nuovaPartita = new Button("Nuova Partita");
        spin = new Button("Spin");
        pay = new Button("Pay");
        credit = new Text("" + 0);
        credit.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BLACK, 30));
        credit_text = new Text("Credito");
        punt = new Text("" + 0);
        punt.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BLACK, 30));
        punt_text = new Text("Punteggio");
        title = new Label("SLOT MACHINE");
        root.setTop(title);
        BorderPane.setAlignment(title, Pos.TOP_CENTER);
        HBox bottoni = new HBox(nuovaPartita, spin, pay);
        bottoni.setSpacing(20);
        bottoni.setAlignment(Pos.CENTER);
        root.setBottom(bottoni);
        VBox cred = new VBox(credit_text, credit);
        VBox score = new VBox(punt_text, punt);
        HBox temp = new HBox(cred, score);
        temp.setAlignment(Pos.CENTER);
        temp.setSpacing(40);
        for (int i = 0; i < 3; i++) {
            slot[i] = new Slot();
            money[i] = new Money();
        }
        VBox monete = new VBox(money[0].c, money[1].c, money[2].c);
        HBox macchinario = new HBox(slot[0].r, slot[1].r, slot[2].r);
        macchinario.setSpacing(30);
        VBox screen = new VBox(macchinario, temp);
        monete.setSpacing(5);
        monete.setAlignment(Pos.CENTER);
        monete.setPrefWidth(150);
        root.setRight(monete);
        root.setCenter(screen);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
