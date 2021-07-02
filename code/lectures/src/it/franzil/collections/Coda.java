/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.franzil.collections;

import java.util.Iterator;

class Coda extends Stack {

    public int estrai() {
        Number x = null;
        Iterator iter = this.iterator();
        if (iter.hasNext()) {
            x = (Number) iter.next();
            iter.remove();
        } else {
            System.out.println(
                    "Tentativo di estrarre da una Coda vuota ");
            System.exit(1);
        }
        return x.getInt();
    }
}
