package Gennaio2016_Esercizio6;

import java.util.*;

public class A {

    A(int m) {
	Collection<String> b = new TreeSet<String>();
	for (int k = 0; k < 10; k++) {
	    String s = "A" + (k % m);	// scrive (A0)
					// scrive (A1)
					// scrive (A2)
	    b.add(s);
	}
	int count = 0;
	Iterator<String> i = b.iterator();
	while (i.hasNext()) {
	    String s = i.next();
	    System.out.print(s);	// stampa (A0)
					// stampa (A1)
					// stampa (A2)
	}
    }

    public static void main(String[] a) {
	new A(3);
    }
}
