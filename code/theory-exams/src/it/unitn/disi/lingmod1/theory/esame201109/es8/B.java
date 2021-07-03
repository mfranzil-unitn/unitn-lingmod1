
// OUTPUT: 8|4

public class B {

    void f (int k) {
	System.out.println(k * 3);
    }

    public static void main(String args[]) {
	Object z = new A();
	
	if (z instanceof B) {((B) z).f(4);} // Utilizza il metodo f di A
	if (z instanceof A) {((A) z).f(2);} // Utilizza il metodo f di A
    }
}

class A extends B {

    void f(int k) {
	System.out.println(k * 2);  // STAMPA(8|4)
    }
}
