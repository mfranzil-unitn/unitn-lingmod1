package Teorico_4Esercitazione;

import java.util.*;

public class Test4 {

    Collection z;

    public Test4(int k) {
	if (k == 0) {
	    z = new HashSet();
	} else {
	    z = new LinkedList();
	}
    }

    public static void main(String arg[]) {
	Test4 a = new Test4(1);
	Test4 b = new Test4(0);
	for (int k = 0; k < 15; k++) {
	    Integer z = new Integer(k % 5);
	    a.z.add(z);
	    b.z.add(z);
	}
	System.out.println(a.z.size() + " " + b.z.size());
    }
}
