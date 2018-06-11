
class A {

    A(int x) {
        System.out.print("X");
    }

    A() {
        System.out.print("Y");
    }

    public void finalize() {
        System.out.print("Z");
    }

}

class B extends A {

    B(int x) {
        System.out.print("A");
    }

    B() {
        System.out.print("B");
    }

    public void finalize() {
        System.out.print("C");
    }

}

public class Prova {

    public static void main(String args[]) {
        A a = new B(3);
        a = null;
        System.gc();
        System.runFinalization();

    }
}
