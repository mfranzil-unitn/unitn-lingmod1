package Teorico2009_Esercizio5;

// OUTPUT: 44

public class A {
    public static int x;
    A (int s) {x = s;}
    void f() {System.out.print(x);}
    public static void main(String a[]) {
	A b = new A(3);
	A c = new A(4);
	b.f();
	c.f();
    }
}

/*
Infatti la variabile "x" è definita "static",
dunque è visibile da tutta la classe e viene modificata da ogni istanza,
che accedono sempre alla stessa variabile e non a copie di istanza.

L'ultima modifica effettuata con "A c = new A(4)",
modifica anche la "x" di "b".
*/