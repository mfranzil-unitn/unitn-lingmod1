
import java.util.*;

// OUTPUT: W0W1W2

public class A {

    A(int m) {
	Collection<String> b = new TreeSet<String>();	// non contiene duplicati
	for (int k = 0; k < 10; k++) {
	    String s = "W" + (k % m);	    // STAMPA(W0|W1|W2)
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
