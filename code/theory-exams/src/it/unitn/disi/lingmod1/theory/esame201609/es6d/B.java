
public class B extends SuperB {
    B() {System.out.print("E");}
    void f() {System.out.print("O");}
    
    public static void main(String pippo) {System.exit(1);} // NON ESEGUE
    public static void main(String[] args) {
	B b = new B();		// STAMPA ("ME")
	SuperB a = (SuperB)b;	// Upcast anche implicito è permesso
	a.f();			// Richiama f() di "B" e non di "SuperB", STAMPA ("O")
    }
}
