
// OUTPUT: 11

public class C {

    public static int x;    // N.B. STATIC

    C(int s) {x = s;}
    void f() {System.out.print(x);}

    public static void main(String a[]) {
	C b = new C(4);
	C c = new C(1);
	b.f();
	c.f();
    }
}
