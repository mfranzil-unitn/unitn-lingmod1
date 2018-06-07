/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201406;

import java.util.LinkedList;
import java.util.Random;
import javafx.concurrent.Task;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Matteo Franzil
 */
public class Griglia extends GridPane {

    public static int N;
    
    
    public static final int BASESIZE = 18;
    private LinkedList<Cella> celle;
    public int currentAlg;

    public Griglia() {
        celle = new LinkedList<>();
        currentAlg = 1;
        Cella cella;
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                cella = new Cella();
                GridPane.setConstraints(cella, i, j, 1, 1);
                celle.add(cella);
                getChildren().add(cella);
            }
        }
    }

    public LinkedList<Cella> getCelle() {
        return celle;
    }

    public void stepAll() {
        for (int i = 0; i < celle.size(); i++) {
            celle.get(i).setRecentlyMoved(false);
        }
        for (int i = 0; i < celle.size(); i++) {
            Cella temp = celle.get(i);
            if (temp.isCircVisible() && getAlg(i) >= 0 && getAlg(i) < 100
                    && getAlgConstraint(i) != 0 && !temp.isRecentlyMoved()) {
                Cella adjacent = celle.get(getAlg(i));
                if (!adjacent.isCircVisible()) {
                    temp.setCircleVisible(false);
                    adjacent.setCircleVisible(true);
                    adjacent.setRecentlyMoved(true);
                }
            }
        }
    }

    public void clearAll() {
        for (int i = 0; i < celle.size(); i++) {
            celle.get(i).setCircleVisible(false);
        }
    }
    
    public Thread startTransition() {
        Task<Integer> task = new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                while (true) {
                    stepAll();
                    Thread.sleep(1000);
                }
            }
        };
        Thread thread = new Thread(task);
        thread.start();
        return thread;
    }

    public int getAlg(int i) {
        int res = i;
        switch (currentAlg) {
            case 1:
                res = i - N + 1;
                break;
            case 2:
                res = i - 1;
                break;
            case 3:
                res = i + N;
                break;
            default:
                res = i;
                break;
        }
        return res;
    }
    
    public int getAlgConstraint(int i) {
        int res = i;
        switch (currentAlg) {
            case 1:
                res = (i + 1) % N;
                break;
            case 2:
                res = (i) % N;
                break;
            case 3:
                res = -1;
                break;
            default:
                res = -1;
                break;
        }
        return res;
    }
    
    public void setCurrentAlg(int Alg) {
        currentAlg = Alg;
    }

}
