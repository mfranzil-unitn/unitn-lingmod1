
// OUTPUT: 55

public class C {

    public static int x;    // N.B. è una variabile statica

    C(int s) {x = s;}
    void f() {System.out.print(x);}

    public static void main(String a[]) {
	C b = new C(3);
	C c = new C(5);
	b.f();
	c.f();
    }
}
