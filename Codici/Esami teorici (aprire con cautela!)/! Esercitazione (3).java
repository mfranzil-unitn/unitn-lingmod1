package Teorico_4Esercitazione;

import java.util.*;

public class Test3 {

    Collection z;

    public Test3(int k) {
	if (k == 0) {
	    z = new HashSet();
	} else {
	    z = new LinkedList();
	}
    }

    public static void main(String arg[]) {
	Test3 a = new Test3(1);
	Test3 b = new Test3(0);
	for (int k = 0; k < 15; k++) {
	    Integer z = new Integer(k % 5);
	    a.z.add(z);
	    b.z.add(z);
	}
	System.out.println(a.z.size() + b.z.size());
    }
}
