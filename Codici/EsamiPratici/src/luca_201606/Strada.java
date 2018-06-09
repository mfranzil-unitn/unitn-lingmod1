/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luca_201606;

import javafx.scene.paint.Color;

/**
 *
 * @author lucamartinelli
 */
class Strada extends Terreno {

    Strada(int i, int j) {
        posi = i;
        posj = j;
        zona.setFill(Color.GREY);

    }
}
