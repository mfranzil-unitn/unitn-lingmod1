
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

// OUTPUT: SW3S

public class Uno {
    static Collection c = new HashSet();
    public static void main(String a[]) {
	Collection c = new LinkedList();	// La sovrascive SOLO localmente (dentro il main)
	Uno u = new Uno();
	c.add(u); c.add(u); c.add(u);
	u.f();					// ESEGUE PER PRIMA
	System.out.print(c.size());		// STAMPA(3)
	System.gc(); System.runFinalization();	// STAMPA(S)
    }
    void f() {
	A a = new A("S");			// STAMPA(S)
	A b = new A("W");			// STAMPA(W)
	c.add(b);				// L'oggetto b viene aggiunto all'HashSet non alla LinkedList
    }
    class A {
	String s = "";
	A(String s) {
	    this.s = s;
	    System.out.print(this);
	}
	public String toString() {return s;}
	public void finalize() {System.out.print(this);}
    }
}
