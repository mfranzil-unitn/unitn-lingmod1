package Giugno2017_Esercizio2A;

// OUTPUT: 152

public class E4 {
    int x  = 3;				// Variabile di classe

    E4(int x) {				// LA VARIABILE PASSATA DIVENTA LOCALE ALLA FUNZIONE
	f(x);				// locale: x = 2, classe: x = 3	    *(a)
	f();				// locale: x = 1, classe: x = 4	    *(b)
	System.out.print(x);		// locale: STAMPA(2)
    }

    void f() {				// locale: x = 1, classe: x = 4	    *(b)
	x++;				// classe: x = 4→5
	System.out.print(x);		// classe: STAMPA(5)
    }

    void f(int x) {			// locale: x = 2, classe: x = 3	    *(a)
	this.x++;			// classe: x = 3→4
	x--;				// locale: x = 2→1
	System.out.print(x);		// locale: STAMPA(1)
    }

    public static void main (String arg[]) {
	int x = 2;			// NON influenza lo svoglimento dell'esercizio
	new E4(2);			// Chiama E4(int x)
    }
}
