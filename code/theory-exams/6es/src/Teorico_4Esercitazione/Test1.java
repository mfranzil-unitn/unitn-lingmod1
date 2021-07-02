package Teorico_4Esercitazione;

class Test1B {

    void f() {
	System.out.println("B");
    }
}

public class Test1 extends Test1B {

    @Override
    void f() {
	System.out.println("A");
    }

    public static void main(String a[]) {
	Test1B o = new Test1();
	o.f();
    }
}