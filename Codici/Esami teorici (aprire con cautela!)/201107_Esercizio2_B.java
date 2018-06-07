package Luglio2011_Esercizio2;

import java.util.*;

// ERRORE IN FASE DI COMPILAZIONE - Collection è astratta, non può essere istanziata

public class B {

    B() {
	Collection b = new Collection();    // Collection is abstract; cannot be istantiated
	for (int k = 0; k < 10; k++) {
	    String s = "A" + (k & 4);
	    b.add(s);
	}
	int count = 0;
	Iterator i = b.iterator();
	while (i.hasNext()) {
	    Object s = i.next();
	    count++;
	}
	System.out.println(count);
    }

    public static void main(String[] a) {
	new B();
	new B();
    }

    public static void main(String a) {
	new B();
    }
}
