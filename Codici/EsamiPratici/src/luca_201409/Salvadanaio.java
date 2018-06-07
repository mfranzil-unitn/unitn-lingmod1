package luca_201409;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * Questa classe è il contenitore grafico del set di monete.
 * 
 */
public class Salvadanaio extends VBox{
    SlotMachine sm=null;
    ListenerMonete monetaListener = null;
    
    public Salvadanaio(SlotMachine sm){
        this.sm=sm;
        setAlignment(Pos.CENTER);
        setSpacing(30);
        setPadding(new Insets(10, 50, 10, 10));
        monetaListener=new ListenerMonete();
        initialize();
    }
    
    public void initialize() {
        getChildren().clear();
        for (int i = 0; i < SlotMachine.NUM_MONETE; i++) {
            Moneta m= new Moneta();
            m.addEventFilter(MouseEvent.MOUSE_CLICKED,monetaListener);
            addMoneta(m);
        }
    }
    
    public void addMoneta(Moneta m){
        getChildren().add(m);
    }

// ============= LISTENER Moneta  ==============================================
    
    public class ListenerMoneteWithoutAnimation implements EventHandler {

        public void handle(Event t) {
            Moneta m = (Moneta) (t.getSource());
            m.setVisible(false);
            sm.creditBox.incrementValue(SlotMachine.NPOINTS_PER_MONETA);
            t.consume();
        }
    }

    public class ListenerMonete implements EventHandler {

        // isHandlerActive serve ad evitare che si possa cliccare più volte
        // sulla moneta durante l'animazione
        boolean isHandlerActive = false; 

        void setHandlerInactive() {
            isHandlerActive = false;
        }

        public void handle(Event t) {
            if (isHandlerActive) {
                return; // avods the double clicks
            }
            isHandlerActive = true;
            Moneta m = (Moneta) (t.getSource());
            t.consume();
            //System.out.println("acting on moneta " + m);
            final Duration SEC_1 = Duration.millis(1000);
            TranslateTransition tt = new TranslateTransition(SEC_1);
            tt.setFromY(0f);
            tt.setToY(500f);
            FadeTransition ft = new FadeTransition(SEC_1);
            ft.setFromValue(1.0);
            ft.setToValue(0.0);
            ParallelTransition pt = new ParallelTransition(m, tt, ft);
            pt.setOnFinished(new EventHandler() {
                public void handle(Event t) {
                    sm.creditBox.incrementValue(SlotMachine.NPOINTS_PER_MONETA);
                    setHandlerInactive();
                }
            });
            pt.play();
        }
    }
}
