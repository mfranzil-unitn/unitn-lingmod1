package Teorico2009_Esercizio2;

// ERRORE IN FASE DI ESECUZIONE - Casting

class B {
    B() {System.out.print("C");}
    void f() {System.out.print("D");}
}

public class A extends B {
    A() {System.out.print("A");}
    void f() {System.out.print("B");}

    public static void main(String k[]) {
	B b = new B();		// stampa C
	A a = (A) b;		// Errore in fase di esecuzione per principio di Liskov.
	a.f();
    }
}
