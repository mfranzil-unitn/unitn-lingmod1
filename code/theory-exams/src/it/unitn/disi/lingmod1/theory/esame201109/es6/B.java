
// OUTPUT: P

class C {
    void f() {System.out.println("R");}
}

public class B extends C {
    
    public void f() {System.out.println("P");}

    public static void main(String[] args) {	// ESEGUE
	C quattro1 = new B();
	quattro1.f();
    }

    public static void main(String args) {	// NON ESEGUE
	C alpha = new C();
	alpha.f();
    }
}