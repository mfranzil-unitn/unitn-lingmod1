
// OUTPUT: 3122-13

public class D {

    static int x = 1;
    S5 a = null;

    class S5 {		    // b) VIENE ISTANZIATA LA SOTTOCLASSE

	int k;

	S5() {
	    k = x;	    // 1°: k = 2 // 2°: k = 3 // 3°: k = 3 // 4°: k = 3
	}

	public void finalize() {
	    System.out.print(k);
	}
    }

    D() {		    // a) VIENE ESEGUITO IL COSTRUTTORE DELLA CLASSE D
	x++;		    // 1°: x = 1, x -> 2		// 2°: x = 2, x -> 3
	a = new S5();	    // 1°: k = x, quindi k = 2		// 2°: k = x, quindi k = 3
    }

    void f() {
	S5 a = new S5();
    }

    public void finalize() {
	System.out.print("1");
    }

    public static void main(String[] args) {
	D a5 = new D(); a5.f();
	a5 = new D(); a5.f();

	System.gc();
	System.runFinalization();

	System.out.print("-");
	a5 = null;			    // rende a5 visibile al GC
	
	System.gc();
	System.runFinalization();
    }
}
