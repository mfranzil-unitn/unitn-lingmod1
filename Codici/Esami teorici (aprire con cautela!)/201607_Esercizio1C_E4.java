package Luglio2016_Esercizio1C;

// OUTPUT: 162

public class E4 {
    int x  = 4;					// Variabile di classe

    E4(int x) {					// LA VARIABILE PASSATA DIVENTA LOCALE ALLA FUNZIONE
	f(x);					// locale: x = 2, classe: 3
	f();					// locale: x = 2, classe: 4
	System.out.print(x);			// quello passato come parametro (2)
    }

    void f() {					// locale: x = 1, classe: x = 4
	x++;					// locale: x = 1 → 2
	System.out.print(x);			// locale: STAMPA(2)
    }

    void f(int x) {				// locale: x =, classe: x = 4
	this.x++;				// classe: x = 3→4
	x--;					// locale: x = 2→1
	System.out.print(x);			// locale: STAMPA(1)
    }
    
    public static void main (String arg[]) {
	int x = 2;				// NON influenza lo svoglimento dell'esercizio
	new E4(2);				// Chiama E4(int x)
    }
}

