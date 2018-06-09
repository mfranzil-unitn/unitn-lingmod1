/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luca_campominato;

import java.util.Random;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

/**
 *
 * @author lucamartinelli
 */
class Griglia extends GridPane {

    int tmp;
    int i, j, valrandom;
    static int conta = 0;
    Random random = new Random();

    Griglia(int dim, Cella celle[][]) {
        for (i = 0; i < dim; i++) {
            for (j = 0; j < dim; j++) {
                valrandom = random.nextInt(2);
                if (valrandom == 1) {
                    if (conta < 10) {
                        conta++;
                    } else {
                        valrandom = 0;
                    }
                }
                System.out.print(valrandom + " ");
                celle[i][j] = new Cella(valrandom);
                this.add(celle[i][j], j, i);
            }
            System.out.println("");
        }
        System.out.println("");

        for (i = 0; i < dim; i++) {
            for (j = 0; j < dim; j++) {
                if (j + 1 < dim) {
                    if (celle[i][j].val == 1 && celle[i][j + 1].val != 1) {
                        tmp = celle[i][j + 1].nearbomb;
                        this.getChildren().remove(celle[i][j + 1]);
                        celle[i][j + 1] = new Cella(2);
                        this.add(celle[i][j + 1], j + 1, i);
                        celle[i][j + 1].nearbomb = celle[i][j + 1].nearbomb + tmp + 1;
                    }
                }
                if (i + 1 < dim) {
                    if (celle[i][j].val == 1 && celle[i + 1][j].val != 1) {
                        tmp = celle[i + 1][j].nearbomb;
                        this.getChildren().remove(celle[i + 1][j]);
                        celle[i + 1][j] = new Cella(2);
                        this.add(celle[i + 1][j], j, i + 1);
                        celle[i + 1][j].nearbomb = celle[i + 1][j].nearbomb + tmp + 1;
                    }
                }
                if (j - 1 >= 0) {
                    if (celle[i][j].val == 1 && celle[i][j - 1].val != 1) {
                        tmp = celle[i][j - 1].nearbomb;
                        this.getChildren().remove(celle[i][j - 1]);
                        celle[i][j - 1] = new Cella(2);
                        this.add(celle[i][j - 1], j - 1, i);
                        celle[i][j - 1].nearbomb = celle[i][j - 1].nearbomb + tmp + 1;
                    }
                }
                if (i - 1 >= 0) {
                    if (celle[i][j].val == 1 && celle[i - 1][j].val != 1) {
                        tmp = celle[i - 1][j].nearbomb;
                        this.getChildren().remove(celle[i - 1][j]);
                        celle[i - 1][j] = new Cella(2);
                        this.add(celle[i - 1][j], j, i - 1);
                        celle[i - 1][j].nearbomb = celle[i - 1][j].nearbomb + tmp + 1;
                    }
                }
            }
        }

        for (i = 0; i < dim; i++) {
            for (j = 0; j < dim; j++) {
                System.out.print(celle[i][j].val + " ");
            }
            System.out.println("");
        }

        System.out.println("");
        this.setAlignment(Pos.CENTER);

    }
}
