package Febbraio2016_Esercizio8;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

// OUTPUT: 672

public class E6 {
    static Collection ll = new LinkedList();	// Contiene duplicati
    int x = 6;					// N.B. NON è statico

    E6() {}

    E6(int x) {
	ll.add(this);		    // aggiunge un'istanza di E6 alla LinkedList, ha x = 6 appresso
	ll.add(new E5A());	    // aggiunge un'istanza di E5A alla LinkedList, ha x = 6 appresso
    }

    public static void main(String z[]) {
	new E6(3);
	Iterator iter = ll.iterator();
	while (iter.hasNext()) {
	    ((E6) iter.next()).f(); // STAMPA(6)
	}
    }

    // E6.f()
    public void f() {System.out.print(x);}

    class E5A extends E6 {
	public void f() {
	    x++;		    // aumenta la x dell'istanza di E5A, x = 6->7
	    super.f();		    // STAMPA(7)
	    System.out.print(2);    // STAMPA(2)
	}
    }
}
