package it.franzil.collections;

import java.util.Iterator;

class Pila extends Stack {

    public int estrai() {
        Number x = null;
        Iterator iter = this.iterator();
        while (iter.hasNext()) {
            x = (Number) iter.next();
        }
        if (x == null) {
            System.out.println("Tentativo diestrarre da una Pila vuota");
            System.exit(1);
        }
        iter.remove();
        return x.getInt();
    }
}
