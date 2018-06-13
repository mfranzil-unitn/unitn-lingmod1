/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201806;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Classe che rappresenta un palo del gioco delle Torri di Hanoi. Viene
 * rappresentato come un rettangolo di colore nero, e al suo interno contiene
 * una LinkedList di dischi (che necessitano tuttavia di essere disegnati da un
 * Parent) e un id, univoco per ogni Palo generato.
 *
 * @author Matteo Franzil - 192198
 */
public class Palo extends Rectangle {

    private LinkedList<Disco> dischi;
    private int id;

    private static int idCount = 0;

    /**
     * Costruisce un nuovo Palo assegnandogli un ID univoco.
     */
    public Palo() {
        id = ++idCount;
        dischi = new LinkedList<>();
        setFill(Color.BLACK);
        setHeight(100);
        setWidth(10);
    }

    /**
     * Restituisce la lista dei Dischi associati al Palo.
     *
     * @return Una LinkedList di dischi, ordinata dal disco più basso al disco
     * più alto.
     */
    public LinkedList<Disco> getDischi() {
        return dischi;
    }

    @Override
    public String toString() {
        return "p" + id;
    }

    /**
     * Restituisce lo stato corrente del Palo.
     *
     * @return TRUE se il Palo è vuoto, FALSE altrimenti.
     */
    public boolean isEmpty() {
        return dischi.isEmpty();
    }

    /**
     * Restituisce la dimensione del disco in cima al Palo.
     *
     * @return Un intero positivo che rappresenta la grandezza relativa del
     * Disco.
     */
    public int getLastDiscoSize() {
        int lastDiscoSize;
        try {
            lastDiscoSize = getDischi().getLast().getSize();
        } catch (NoSuchElementException ex) {
            lastDiscoSize = 5;
        }
        return lastDiscoSize;
    }

    /**
     * Svuota completamente il Palo dai suoi dischi. Spetta al Parent la
     * rimozione dall'area grafica.
     */
    public void clear() {
        dischi.clear();
    }

}
