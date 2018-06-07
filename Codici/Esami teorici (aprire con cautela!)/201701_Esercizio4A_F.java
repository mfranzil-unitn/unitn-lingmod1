package Gennaio2017_Esercizio4A;

// OUTPUT: 546

public class F {
    int x  = 2;				// Variabile di classe

    F(int x) {				// LA VARIABILE PASSATA DIVENTA LOCALE ALLA FUNZIONE
	f(x);				// locale: x = 6, classe: 2	    *(a)
	f();				// locale: x = 5, classe: 3	    *(b)
	System.out.print(x);		// locale: STAMPA(6)
    }

    void f() {				// locale: x = 5, classe: x = 3	    *(b)
	x++;				// locale: x = 5→6
	System.out.print(x);		// locale: STAMPA(6)
    }

    void f(int x) {			// locale: x = 6, classe: x = 2	    *(a)
	this.x++;			// classe: x = 2→3
	x--;				// locale: x = 6→5
	System.out.print(x);		// locale: STAMPA(5)
    }

    public static void main (String arg[]) {
	F x = new F(6);			// Chiama F(int x)
    }
}
