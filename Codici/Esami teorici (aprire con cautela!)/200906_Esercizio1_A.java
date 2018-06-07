package Teorico2009_Esercizio1;

// OUTPUT: CAB

class B {
    B() {System.out.print("C");}
    void f() {System.out.print("D");}
}

public class A extends B {
    A() {System.out.print("A");}
    void f() {System.out.print("B");}

    public static void main(String[] args) {
	A b = new A();	    // A -> B, STAMPA (CA)
	B a = (B) b;	    // a punta all'indirizzo di b, NON chiama il costruttore
	a.f();		    // Richiama f() di A, STAMPA (B)
    }
}

/*
A b = new A();	// Crea un oggetto di nome 'b' e di tipo 'A'.
B a = (B) b;	// Upcast di 'b' (che è di tipo 'A') a tipo B (superclasse di A), crea un alias che punta alla stessa locazione di memoria di 'b'.
a.f();		// Accede al metodo di 'A', in quanto 'a' è alias di 'b'.
*/