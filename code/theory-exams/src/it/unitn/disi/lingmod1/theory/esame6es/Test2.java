
public class Test2 extends Test2B {

    @Override
    void f() {
	System.out.println("A");
    }

    public static void main(String a[]) {
	Test2B o = new Test2();
	o.f();
    }
}

class Test2B {

    final void f() {
	System.out.println("B");
    }
}
