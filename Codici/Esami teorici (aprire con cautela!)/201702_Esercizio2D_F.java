package Febbraio2017_Esercizio2D;

// OUTPUT: 445

public class F {
    int x  = 2;					// Variabile di classe

    F(int x) {					// LA VARIABILE PASSATA DIVENTA LOCALE ALLA FUNZIONE
	f(x);					// locale: x = 5, classe: 2	    *(a)
	f();					// locale: x = 4, classe: 3	    *(b)
	System.out.print(x);			// quello passato come parametro (2)
    }

    void f() {					// locale: x = 4, classe: x = 3	    *(b)
	x++;					// locale: x = 4→5
	System.out.print(x);			// locale: STAMPA(5)
    }

    void f(int x) {				// locale: x =5, classe: x = 2	    *(a)
	this.x++;				// classe: x = 2→3
	x--;					// locale: x = 5→4
	System.out.print(x);			// locale: STAMPA(4)
    }

    public static void main (String arg[]) {
	F x = new F(5);				// Chiama E4(int x)
    }
}
