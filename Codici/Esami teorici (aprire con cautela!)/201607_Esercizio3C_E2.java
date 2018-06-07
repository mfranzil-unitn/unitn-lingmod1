package Luglio2016_Esercizio3C;

import java.util.HashSet;

// CLASSI: E2 <- A2 <- A3
// OUTPUT: 10|10|00

public class E2 {
    static HashSet hs = new HashSet();	// Non contiene duplicati
    public int hashCode() {
	return 0;
    }
    public boolean equals(Object x) {	// sono uguali se fa parte di E2 o è una sua sottoclasse
	return (x.getClass().equals(this.getClass()));
    }
    public static void main(String s[]) {
	f(new E2()); f(new E2());	// "E2" added -> STAMPA(1); "E2" c'è già -> STAMPA(0);
	f(new A2()); f(new A2());	// "A2" added -> STAMPA(1); "A2" c'è già -> STAMPA(0); 
	f(new A3()); f(new A3());	// "A3" non è istanza di "A2" -> STAMPA(0); STAMPA(0);
    }
    static void f(E2 x) {
	int v = 0;
	if (hs.add(x)) {
	    v = 1;
	}
	System.out.print(v);
    }
}
    
    class A2 extends E2 {
	public boolean equals(Object x) {
	    return x instanceof A2;	// sono uguali se è ESATTAMENTE di questa classe
	}
    }

    class A3 extends A2 {}		// Prende il metodo equals() del padre
