
// OUTPUT: 859

public class F {
    int x  = 3;				// Variabile di classe

    F(int x) {				// LA VARIABILE PASSATA DIVENTA LOCALE ALLA FUNZIONE
	f(x);				// locale: x = 9, classe: x = 3	    *(a)
	f();				// locale: x = 9, classe: x = 4	    *(b)
	System.out.print(x);		// locale: STAMPA(9)
    }

    void f() {				// locale: x = 9, classe: x = 4	    *(b)
	x++;				// classe: x = 4→5
	System.out.print(x);		// classe: STAMPA(5)
    }

    void f(int x) {			// locale: x = 9, classe: x = 3	    *(a)
	this.x++;			// classe: x = 3→4
	x--;				// locale: x = 9→8
	System.out.print(x);		// locale: STAMPA(8)
    }

    public static void main (String arg[]) {
	F x = new F(9);			// Richiama la F(int x)
    }
}
