
import java.util.*;

// ERRORE IN FASE DI COMPILAZIONE

public class A {
    A(int m) {
	List<String> b = new TreeSet<String>();	// Tipi incompatibili
	
	for (int k = 0; k < 10; k++) {
	    String s = "A" + (k%m);
	    b.add(s);
	}
	
	int count = 0;
	
	Iterator<String> i = b.iterator();
	
	while(i.hasNext()) {
	    String s = i.next();
	    System.out.print(s);
	}
    }
    
    public static void main(String[] args) {
	new A(3);
    }
}
