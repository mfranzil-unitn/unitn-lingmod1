
class Test5b {

    Test5b() {
	System.out.print(4);
    }

    void f() {
	System.out.print(45);
    }
}

public class Test5 extends Test5b {

    Test5() {
	System.out.print(7);
    }

    @Override
    void f() {
	System.out.print(47);
    }

    public static void main(String i[]) {
	Test5b uno = new Test5b();
	Test5 due = (Test5) uno;
	due.f();
    }
}
