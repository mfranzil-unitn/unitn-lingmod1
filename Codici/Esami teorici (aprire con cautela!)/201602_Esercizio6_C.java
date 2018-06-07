package Febbraio2016_Esercizio6;

// OUTPUT: B4|A6

public class C {

    int s = 5;

    void f() {
	System.out.print("A" + (++s));		// STAMPA(A6)
    }

    public static void main(String[] a) {
	C y = new C();
	C x = new C() {
	    void f() {
		System.out.print("B" + (--s));	// STAMPA(B4)
	    }
	};
	x.f();
	y.f();
    }

    public static void main(String a) {
	C y = new C();
    }
}
