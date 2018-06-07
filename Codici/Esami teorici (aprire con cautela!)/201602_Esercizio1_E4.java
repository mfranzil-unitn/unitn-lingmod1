package Febbraio2016_Esercizio1;

// OUTPUT: 162

public class E4 {
    int x  = 4;				// Variabile di classe

    E4(int x) {				// LA VARIABILE PASSATA DIVENTA LOCALE ALLA FUNZIONE
	f(x);				// locale: x = 2, classe: x = 4	    *(a)
	f();				// locale: x = 1, classe: x = 5	    *(b)
	System.out.print(x);		// locale: STAMPA(2)
    }

    void f() {				// locale: x = 1, classe: x = 5	    *(b)
	x++;				// locale: x = 5→6
	System.out.print(x);		// locale: STAMPA(6)
    }

    void f(int x) {			// locale: x = 2, classe: x = 4	    *(a)
	this.x++;			// classe: x = 4→5
	x--;				// locale: x = 2→1
	System.out.print(x);		// locale: STAMPA(1)
    }

    public static void main (String arg[]) {
	int x = 2;			// NON influenza lo svoglimento dell'esercizio
	new E4(2);			// Chiama E4(int x)
    }
}
