package Febbraio2017_Esercizio6D;

public class B extends SuperB {
    B() {
	System.out.print("E");
    }

    void f() {
	System.out.print("O");
    }

    public static void main(String pippo) {
	System.exit(1);
    }
    public static void main(String[] args) {
	B b = new B();
	SuperB a = (SuperB)b;
	a.f();
    }
}
