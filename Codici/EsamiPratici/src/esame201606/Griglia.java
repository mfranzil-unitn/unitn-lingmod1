/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame201606;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

/**
 *
 * @author Matteo Franzil
 */
public class Griglia extends GridPane {

    public static final int N = 8;
    private LinkedList<LinkedList<Terreno>> celle;
    boolean addCarMode;
    private LinkedList<Macchina> macchine;
    private Thread thr;

    public Griglia() {
        addCarMode = false;
        macchine = new LinkedList<>();
        celle = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            LinkedList<Terreno> temp = new LinkedList<>();
            // Riga di strada            
            for (int j = 0; j < N; j++) {
                Terreno prato;
                if (j == 0 || j == N - 1 || i == 0 || i == N - 1) {
                    prato = new Strada();
                } else {
                    prato = new Prato();
                }
                GridPane.setConstraints(prato, j, i, 1, 1);
                temp.add(prato);
                getChildren().add(prato);
            }
            celle.add(temp);
        }
        addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            Terreno temp;
            try {
                temp = (Terreno) e.getTarget();
                int[] coord = findCoordinates(temp);
                int x = coord[0];
                int y = coord[1];

                if (addCarMode) {
                    if (temp instanceof Strada) {
                        Macchina macchina = new Macchina(y, x);
                        GridPane.setConstraints(macchina, y, x);
                        System.out.println(x + "     " + y);
                        getChildren().add(macchina);
                        macchine.add(macchina);
                    }
                } else {
                    System.out.println("Replacing: " + celle.get(y).get(x) + " with " + y + " " + x);
                    if (temp instanceof Strada) {
                        Prato prato = new Prato();
                        GridPane.setConstraints(prato, y, x);
                        celle.get(x).set(y, prato);
                        getChildren().remove(temp);
                        getChildren().add(prato);
                    } else if (temp instanceof Prato) {
                        Strada strada = new Strada();
                        GridPane.setConstraints(strada, y, x);
                        celle.get(x).set(y, strada);
                        getChildren().remove(temp);
                        getChildren().add(strada);
                    }
                    //Debug
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            System.out.print(celle.get(i).get(j) + "\t");
                        }
                        System.out.println("");
                    }

                }
            } catch (NullPointerException ex) {
                System.out.println("Coordinates not found");
            } catch (ClassCastException ex) {
                System.out.println("Wrong target clicked");
            } catch (UnsupportedOperationException ex) {
                System.out.println("No cars permitted here.");
            }

        });
    }

    public int[] findCoordinates(Terreno target) {
        int[] coordinates = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Terreno temp = celle.get(i).get(j);
                if (target == temp) {
                    coordinates = new int[]{i, j};
                    break;
                }
            }
        }
        return coordinates;
    }

    public void setAddCarMode(boolean addCarMode) {
        this.addCarMode = addCarMode;
    }

    public boolean isAddCarMode() {
        return addCarMode;
    }

    public LinkedList<Macchina> getMacchine() {
        return macchine;
    }

    public void moveAllCars(String direction) {
        for (int i = 0; i < macchine.size(); i++) {
            moveCar(macchine.get(i), direction);
        }
    }

    public void moveCar(Macchina macchina, String direction) {
//        macchina.toFront();
        Macchina adjacent;

        int targetX, targetY;
        switch (direction) {
            case "Destra":
                targetX = macchina.getRelativeX() + 1;
                targetY = macchina.getRelativeY();
                break;
            case "Su":
                targetX = macchina.getRelativeX();
                targetY = macchina.getRelativeY() - 1;
                break;
            case "Giu":
                targetX = macchina.getRelativeX();
                targetY = macchina.getRelativeY() + 1;
                break;
            case "Sinistra":
                targetX = macchina.getRelativeX() - 1;
                targetY = macchina.getRelativeY();
                break;
            default:
                targetX = macchina.getRelativeX();
                targetY = macchina.getRelativeY();
                break;
        }

        adjacent = findCarCoordinates(targetX, targetY);
        boolean target = false;
        try {
            target = celle.get(targetY).get(targetX) instanceof Strada;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Out of bounds");
        }

        if (adjacent == null && target
                && (targetX >= 0) && (targetX < N) && (targetY >= 0) && (targetY < N)) {

            macchina.setRelativeX(targetX);
            macchina.setRelativeY(targetY);

            TranslateTransition tt = new TranslateTransition(Duration.millis(200), macchina);
            tt.setCycleCount(1);
            tt.setAutoReverse(true);

            switch (direction) {
                case "Destra":
                    tt.setByX(Terreno.SIZE);
                    //macchina.setTranslateX(macchina.getTranslateX() + Terreno.SIZE);
                    break;
                case "Su":
                    tt.setByY(-Terreno.SIZE);
                    //macchina.setTranslateY(macchina.getTranslateY() - Terreno.SIZE);
                    break;
                case "Giu":
                    tt.setByY(Terreno.SIZE);
                    //macchina.setTranslateY(macchina.getTranslateY() + Terreno.SIZE);
                    break;
                case "Sinistra":
                    tt.setByX(-Terreno.SIZE);
                    //macchina.setTranslateX(macchina.getTranslateX() - Terreno.SIZE);
                    break;
                default:
                    break;
            }
            tt.play();
            System.out.println("Car successfully moved.");

        } else if (adjacent != null) {
            stopThread();
            Platform.runLater(
                    () -> {
                        System.out.println("Crash in progress...");
                        Alert alert = new Alert(Alert.AlertType.ERROR, "CRASH", ButtonType.OK);
                        Optional result = alert.showAndWait();
                        if (result.get() == ButtonType.OK || result.isPresent()) {
                            Platform.exit();
                        }
                    });
        } else {
            System.out.println("Movement failed: illegal position");
        }
    }

    public Macchina findCarCoordinates(int possibleX, int possibleY) {
        for (int i = 0; i < macchine.size(); i++) {
            Macchina macchina = macchine.get(i);
            if (macchina.getRelativeX() == possibleX && macchina.getRelativeY() == possibleY) {
                return macchina;
            }
        }
        return null;
    }

    public void startAutoMovement() {
        thr = new Thread() {
            @Override
            public void run() {
                for (int i = 0; true; i++) {
                    Macchina macchina = macchine.get(i % macchine.size());
                    moveCar(macchina, randomDirection());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Griglia.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    i++;
                }
            }
        };
        thr.start();
    }

    public void randomSingleMovement() {
        for (int i = 0; i < macchine.size(); i++) {
            Macchina temp = macchine.get(i);
            moveCar(temp, randomDirection());
        }
    }

    public String randomDirection() {
        String res = null;
        switch (new Random().nextInt(4)) {
            case 0:
                res = "Su";
                break;
            case 1:
                res = "Giu";
                break;
            case 2:
                res = "Destra";
                break;
            case 3:
                res = "Sinistra";
                break;
            default:
                break;
        }
        return res;
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

    public void stopThread() {
        try {
            thr.interrupt();
        } catch (NullPointerException e) {
            System.out.println("No thread to interrupt");
        }
    }
}
