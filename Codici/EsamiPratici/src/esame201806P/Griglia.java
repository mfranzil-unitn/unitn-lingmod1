package esame201806P;

import esame201806P.celle.*;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

import java.util.Collections;
import java.util.LinkedList;

public class Griglia extends GridPane {

    public static final int N = 10;
    public static final int N_CELLEBASE = N * N * 3 / 4;
    public static final int N_CELLEMOLT = N * N / 10;
    public static final int N_CELLEDIV = N * N / 10;
    public static final int N_CELLEBOMB = N * N / 20;

    private Integer punteggio, tentativi;
    private TextContainer<Integer> punteggioTxt;
    private TextContainer<Integer> tentativiTxt;

    public Griglia(TextContainer<Integer> punteggioTxt, TextContainer<Integer> tentativiTxt) {
        this.punteggioTxt = punteggioTxt;
        this.tentativiTxt = tentativiTxt;
        this.punteggio = 0;
        this.tentativi = 10;

        var celle = new LinkedList<Cella>();

        for (int i = 0; i < N_CELLEBASE; i++) {
            celle.add(new CellaBase(this));
        }

        for (int i = 0; i < N_CELLEMOLT; i++) {
            celle.add(new CellaMoltiplicatore(this));
        }

        for (int i = 0; i < N_CELLEDIV; i++) {
            celle.add(new CellaDivisore(this));
        }

        for (int i = 0; i < N_CELLEBOMB; i++) {
            celle.add(new CellaBomba(this));
        }

        Collections.shuffle(celle);

        for (int i = 0; i < N; i++) {
            RowConstraints r = new RowConstraints();
            r.setPercentHeight(100 / N);
            ColumnConstraints c = new ColumnConstraints();
            c.setPercentWidth(100 / N);
            getRowConstraints().addAll(r);
            getColumnConstraints().add(c);
            for (int j = 0; j < N; j++) {
                try {
                    add(celle.get(i * N + j), j, i);
                } catch (IndexOutOfBoundsException ex) {
                    add(new CellaBase(this), j, i);
                }
            }
        }

        addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            if (getTentativi() > 0) {
                if (((Node) e.getTarget()).getParent() instanceof Cella &&
                        !(e.getTarget() instanceof Text)) {
                    setTentativi(getTentativi() - 1);
                }
            } else {
                e.consume();
            }
        });

        punteggioTxt.update(punteggio);
        tentativiTxt.update(tentativi);


        addEventHandler(ScrollEvent.SCROLL, e -> {
            if (e.isControlDown()) {
                for (Cella a : celle) {
                    a.changeCover(e.getDeltaY() / 1000);
                }
            }
        });
    }

    public Integer getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(Integer punteggio) {
        this.punteggio = punteggio;
        punteggioTxt.update(punteggio);
    }

    public Integer getTentativi() {
        return tentativi;
    }

    public void setTentativi(Integer tentativi) {
        this.tentativi = tentativi;
        tentativiTxt.update(tentativi);
    }

    public void blowItUp(Cella cella) {
        int j = GridPane.getColumnIndex(cella);
        int i = GridPane.getRowIndex(cella);


        for (int k = 0; k < N; k++) {
            Cella temp = ((Cella) standardGetElementAt(k, j));
            if (temp != cella && k != i) {
                temp.scopri(new Event(this, cella, MouseEvent.MOUSE_CLICKED));
            }
        }

        for (int k = 0; k < N; k++) {
            Cella temp = ((Cella) standardGetElementAt(i, k));
            if (temp != cella && k != j) {
                temp.scopri(new Event(this, cella, MouseEvent.MOUSE_CLICKED));
            }
        }
    }

    public Node standardGetElementAt(int i, int j) {
        Node res = null;
        for (Node x : getChildren()) {
            if (GridPane.getRowIndex(x) == i && GridPane.getColumnIndex(x) == j) {
                res = x;
                break;
            }
        }
        return res;
    }
}
