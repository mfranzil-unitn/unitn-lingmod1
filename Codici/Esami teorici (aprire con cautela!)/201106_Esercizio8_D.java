package Giugno2011_Esercizio8;

// OUTPUT: COMBINAZIONI DI "A235"

public class D {

    static int x = 1;	    // N.B. STATIC
    
    class String5 {
	String s;

	String5() {this.s = "" + (++x);}
	
	public void finalize() {System.out.print(s);}
    }
    
    String5 a = new String5();	// FA ATTENZIONE

    void f() {String5 a = new String5();}
    public void finalize() {System.out.print("A");}

    public static void main(String[] args) {
	D a5 = new D();	    // x = 1->2, s = "2", perde il riferimento, gustoso per il gc() -> STAMPA("A")
	a5.f();
	// Il String5 creato all'interno di f() perde il riferimento, gustoso per il gc() -> STAMPA("3")
	a5 = new D();	    // x = 3->4, Il String5 creato con la prima new D() perde il riferimento, gustoso per il gc() -> STAMPA("2")
	a5.f();		    // x = 4->5, s = "5", perde il riferimento, gustoso per il gc() -> STAMPA("5")
	
	System.gc();	    // STAMPA LE COMBINAZIONI DI(A235)
	System.runFinalization(); //
    }
}
