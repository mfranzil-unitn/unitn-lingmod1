package Luglio2011_Esercizio7;

// OUTPUT: 243

public class F {
    int x  = 2;				// Variabile di classe

    F(int x) {				// LA VARIABILE PASSATA DIVENTA LOCALE ALLA FUNZIONE
	f(x);				// locale: x = 3, classe: x = 2	    *(a)
	f();				// locale: x = 3, classe: x = 3	    *(b)
	System.out.print(x);		// locale: STAMPA(3)
    }

    void f() {				// locale: x = 3, classe: x = 3	    *(b)
	x++;				// locale: x = 3→4
	System.out.print(x);		// locale: STAMPA(4)
    }

    void f(int x) {			// locale: x = 3, classe: x = 2	    *(a)
	this.x++;			// classe: x = 2→3
	x--;				// locale: x = 3→2
	System.out.print(x);		// locale: STAMPA(2)
    }

    public static void main (String arg[]) {
	F x = new F(3);			// Richiama la F(int x)
    }
}