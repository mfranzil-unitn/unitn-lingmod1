package Giugno2016_Esercizio1C;

// OUTPUT: 16x

public class E4 {

    int x  = 4;

    E4(int x) {
	f(x);
	f();
	System.out.print("x");	    // STAMPA(x)
    }

    void f() {
	x++;			    // classe: 5->6
	System.out.print(x);	    // classe: STAMPA(6)
    }

    void f(int x) {
	this.x++;
	x--;
	System.out.println(x);	    // passata: STAMPA(1)
    }
    
    public static void main (String arg[]) {
	int x = 2;
	new E4(2);
    }
}
