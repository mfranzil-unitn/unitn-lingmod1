package Febbraio2017_Esercizio4D;

public class B extends SuperB {
    B() {
	System.out.print("B");
    }
    
    void f() {
	System.out.print("C");
    }
    
    public static void main(String args) {
	System.exit(1);
    }
    public static void main(String[] args) {
	SuperB b = new SuperB();
	B a = (B)b;		// ERRORE
	a.f();
    }
}