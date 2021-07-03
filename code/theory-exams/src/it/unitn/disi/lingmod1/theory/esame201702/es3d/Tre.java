
// ERRORE IN FASE DI COMPILAZIONE

public class Tre {
    public class A {
	// A() {}
	public A(int k) {
	    System.out.print(k);
	}
	public void finalize() {
	    System.out.print("C");
	}
    }

    class B extends A {
	public B(int k) {
	    System.out.print(k);
	}
	public void finalize() {
	    System.out.print("B");
	}
    }
    
    public static void main(String[] args) {
	new Tre();
    }

    Tre() {
	A a = new B(3);
	B b = (B)a;
	a = null;
	a = new B(3);
	System.gc();	System.runFinalization();
    }
}