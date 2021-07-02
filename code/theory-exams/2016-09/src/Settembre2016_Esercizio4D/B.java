package Settembre2016_Esercizio4D;

// ERRORE IN FASE DI ESECUZIONE - Downcasting non permesso

public class B extends SuperB {
    B() {System.out.print("B");}
    void f() {System.out.print("C");}
    
    public static void main(String args) {System.exit(1);}
    public static void main(String[] args) {
	SuperB b = new SuperB();    // STAMPA(S)
	B a = (B)b;		    // ERRORE
	a.f();
    }
}
