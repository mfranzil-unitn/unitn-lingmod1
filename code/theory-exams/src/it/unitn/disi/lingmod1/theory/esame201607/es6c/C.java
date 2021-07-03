
// OUTPUT: B4|A6

public class C {
    int s = 5;
    
    void f() {
	System.out.print("A" + (++s));
    }
    
    public static void main(String []a) {   // ESEGUE QUESTO!
	C y = new C();
	C x = new C() {
	    void f() {
		System.out.print("B" + (--s));
	    }
	};
	x.f();	// STAMPA(B4)
	y.f();	// STAMPA(A6)
    }
    
    public static void main(String a) {	    // NON GUARDARLO!
	C y = new C();
    }
}
