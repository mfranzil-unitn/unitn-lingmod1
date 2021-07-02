package Settembre2016_Esercizio3D;

// ERRORE IN FASE DI COMPILAZIONE
// (se l'avesse l')OUTPUT(sarebbe): 33B

public class Tre {
    class A {
	// A(){} // Corregge l'errore.
	public A(int k) {System.out.print(k);}
	public void finalize() {System.out.print("C");}
    }
    
    class B extends A {
	public B(int k) {System.out.print(k);}
	public void finalize() {System.out.print("B");}	// STAMPA(B)
    }
    
    public static void main(String z[]) {
	new Tre();
    }
    
    Tre() {
	A a = new B(3);	// STAMPA(3)
	B b = (B)a;	// non stampa nulla.
	a = null;	// perde il riferimento
	b = new B(3);	// STAMPA(3)
	
	System.gc(); System.runFinalization();
    }
}