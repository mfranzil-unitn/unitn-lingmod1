package Giugno2017_Esercizio3A;

import java.util.HashSet;

// OUTPUT: 101000

public class E2 {

    static HashSet hs = new HashSet();

    public int hashCode() {
	return 0;
    }

    public boolean equals(Object x) {
	return (x.getClass().equals(this.getClass()));
    }

    public static void main(String s[]) {
	f(new E2()); f(new E2());
	f(new A2()); f(new A2());
	f(new A3()); f(new A3());
    }

    static void f(E2 x) {
	int v = 0;
	if (hs.add(x)) {
	    v = 1;
	}
	System.out.print(v);
    }
}

class A2 extends E2 {

    @Override
    public boolean equals(Object x) {
	return x instanceof A2;
    }
}

class A3 extends A2 {}