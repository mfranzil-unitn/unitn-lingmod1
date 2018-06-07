package Giugno2016_Esercizio6C;

public class C {
    int s = 5;
    void f() {
	System.out.print("A" + (++s));
    }
    public static void main(String[] a) {
	C y = new C();
	C x = new C() {
	    void f() {
		System.out.println("B" + (--s));
	    }
	};
	
	x.f();
	y.f();
    }
    
    public static void main(String a) {
	C y = new C();
    }
}
