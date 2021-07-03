
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class Uno {
    static Collection c = new HashSet();
    
    public static void main(String a[]) {
	Collection c = new LinkedList();
	Uno u = new Uno();
	c.add(u); c.add(u); c.add(u);
	
	u.f();
	
	System.out.print(c.size());	// -> 3
	System.gc(); System.runFinalization();
    }
    
    void f() {
	A a = new A("S");   // -> S (costruttore A)
	A b = new A("W");   // -> W (costruttore A)
	c.add(b);
    }
    
    class A {
	String s = "";
	A(String s) {
	    this.s = s;
	    System.out.print(this);
	}
	public String toString() {
	    return s;
	}
	public void finalize() {
	    System.out.print(this); // -> S (a unica istanza della classe A)
	}
    }
}
