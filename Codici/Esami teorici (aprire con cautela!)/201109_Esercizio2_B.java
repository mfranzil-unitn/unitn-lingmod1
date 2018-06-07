package Settembre2011_Esercizio2;

// OUTPUT: COMBINAZIONI DI "STP"

class A {
    A(int x) {System.out.println("A");}
    A() {System.out.println("S");}
    
    public void finalize() {
	System.out.println("U");
    }
}

public class B extends A {

    B(int x) {System.out.println("T");}
    B() {System.out.println("H");}
    
    public void finalize() {
	System.out.println("P");
    }

    public static void main(String args[]) {
	A a = new B(3);		    // B->A, STAMPA(S|T)
	a = null;
	System.gc();
	System.runFinalization();   // Esegue gc() di B, STAMPA (P)
    }
}
