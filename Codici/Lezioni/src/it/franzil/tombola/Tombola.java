package it.franzil.tombola;

import it.franzil.Common;
import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
/**
 *
 * @author matte
 */
public class Tombola extends Application {

    static final int MAXCARTELLE = 3;
    static final int NCELLS = 15;
    static final int MAXPLAYERS = 10;
    static final int MAXNUM = 90;
    
    static Random generatore = new Random(System.currentTimeMillis());
    private Banco banco;
    
    static TextArea txt;

    @Override
    public void start(Stage primaryStage) {
        Tombola a = new Tombola();
        banco = new Banco();
        allocaCartelleRandom(banco);

        txt = new TextArea();
        txt.setMaxHeight(150);
        txt.setMaxWidth(300);
        txt.relocate(0, 60);
        txt.setEditable(false);

        Text t = new Text();
        t.setTextAlignment(TextAlignment.CENTER);

        Button btn = new Button();
        btn.setText("Prossimo numero!");
        btn.relocate(100, 10);
        btn.setOnAction((ActionEvent nextnumber) -> {
            txt.clear();
            int num = banco.getNextNumber();
            t.setText("Il numero estratto é " + num);
            if (!(Banco.vincitori.isEmpty())) {
                btn.setDisable(true);
                banco.finalizzaVittoria();
                btn.setText("Finito!");
                //#TODO SLEEP
                btn.setDisable(false);
                btn.setOnAction((ActionEvent endprogram) -> {
                    Common.endProgram("vittoria di un partecipante");
                });
            }
            if (banco.numerifiniti) {
                btn.setText("Numeri finiti!");
                Common.endProgram("Numeri finiti");
            }
        });
        
        t.relocate(btn.getLayoutX(), btn.getLayoutY() + 30);
        
        //StackPane root2 = new StackPane();
        //root2.getChildren().add(btn);
        
        Group root = new Group();
        root.getChildren().add(t);
        root.getChildren().add(btn);
        root.getChildren().add(txt);
        
        Scene scene = new Scene(root, txt.getMaxWidth(), txt.getMaxHeight() + 60);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Tombola");
        primaryStage.show();
        
    }

    public static void main(String[] args) throws IllegalArgumentException {
        if (MAXCARTELLE <= 0 || NCELLS <= 0 || MAXPLAYERS <= 0 || MAXNUM <= 0 || NCELLS >= MAXNUM)
            throw new IllegalArgumentException("Valori di partenza non validi");
        else
            launch(args);
    }

    private void allocaCartelleRandom(Banco banco) {
        //LinkedList<Giocatore> set = new LinkedList();
        Giocatore p;
        for (int i = 0; i < MAXPLAYERS; i++) {
            p = new Giocatore();
            //set.add(p);
            for (int k = 0; k < p.getNumerocartelle(); k++) {
                banco.addListener(new Cartella(p));
            }
        }
    }  
 
}
