
// OUTPUT: 445

public class F {
    int x  = 2;					// Variabile di classe

    F(int x) {					// LA VARIABILE PASSATA DIVENTA LOCALE ALLA FUNZIONE
	f(x);					// locale: x = 2, classe: 3
	f();					// locale: x = 5, classe: 3
	System.out.print(x);			// quello passato come parametro (5)
    }

    void f() {					// locale(classe): x = 3
	x++;					// locale: x = 3→4
	System.out.print(x);			// locale: STAMPA(4)
    }

    void f(int x) {				// locale(passata): x = 5, classe: x = 4
	this.x++;				// classe: x = 2→3
	x--;					// locale: x = 5→4
	System.out.print(x);			// locale: STAMPA(4)
    }
    
    public static void main (String arg[]) {
	F x = new F(5);				// Chiama F(int x)
    }
}
