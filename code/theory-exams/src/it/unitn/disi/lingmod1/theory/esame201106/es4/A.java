
import java.util.*;

// OUTPUT: A0|A1|A2

public class A {

    A(int m) {
	Collection<String> b = new TreeSet<String>();	// Non contiene duplicati
	for (int k = 0; k < 10; k++) {
	    String s = "A" + (k % m);			// STAMPA(A0|A1|A2)
	    b.add(s);
	}
	int count = 0;
	Iterator<String> i = b.iterator();
	while (i.hasNext()) {
	    String s = i.next();
	    System.out.print(s);
	}
    }

    public static void main(String[] a) {
	new A(3);
    }
}
