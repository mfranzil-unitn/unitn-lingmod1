package Gennaio2016_Esercizio4;

public class C {

    public static int x;

    C(int s) {
	x = s;
    }

    void f() {
	System.out.print(x);
    }

    public static void main(String a[]) {
	C b = new C(3);
	C c = new C(5);
	b.f();		// stampa (5)
	c.f();		// stampa (5)
    }
}
