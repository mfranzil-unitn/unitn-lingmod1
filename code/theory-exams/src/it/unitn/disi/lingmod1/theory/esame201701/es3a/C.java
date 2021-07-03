
// OUTPUT: 1111

public class C {
    public static int x;
    
    C(int s) {
	x = s;
    }
    
    void f() {
	System.out.print(x);
    }
    
    public static void main(String[] args) {
	C b = new C(13);
	C c = new C(11);
	b.f();
	c.f();
    }
}
