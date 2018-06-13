/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201806;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Classe che rappresenta un disco singolo che verrà poi inserito in un Palo. E'
 * necessario che un parent si occupi di disegnare correttamente il Disco
 * generato. Il parametro size rappresenta la larghezza relativa del disco, pari
 * a 1 per il disco più piccolo e HanoiArea.NUMERO_DISCHI per quello più grande.
 *
 * @author Matteo Franzil - 192198
 */
public class Disco extends Rectangle {

    private int size;

    /**
     * Costruisce un disco sulla base della grandezza (compresa tra 0 e il
     * numero di dischi massimo) data. I colori sono fissi e dipendono dalla
     * grandezza.
     *
     * @param size La grandezza del Disco da generare (positiva).
     */
    public Disco(int size) {
        if (size > 0 && size <= HanoiArea.NUMERO_DISCHI) {
            this.size = size;
            Color color;
            switch (size) {
                case 1:
                    color = Color.SKYBLUE;
                    break;
                case 2:
                    color = Color.CHARTREUSE;
                    break;
                case 3:
                    color = Color.PURPLE;
                    break;
                case 4:
                    color = Color.ORANGE;
                    break;
                default:
                    color = Color.WHITE;
            }
            setFill(color);
            setHeight(10);
            setWidth(15 * size);
        } else {
            throw new IllegalArgumentException("La dimensione del disco deve essere "
                    + "compresa tra 0 e il numero di dischi massimi");
        }
    }

    /**
     * Restituisce la grandezza del Disco.
     *
     * @return Un intero positivo che rappresenta la grandezza del Disco.
     */
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Disco di dimensioni " + size;
    }
}
