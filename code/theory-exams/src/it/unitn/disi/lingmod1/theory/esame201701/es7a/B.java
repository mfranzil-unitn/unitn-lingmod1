
import java.util.*;

public class B {
    B () {
	Collection b = new Collection();
	
	for (int k = 0; k < 10; k++) {
	    String s = "A" + (k%4);
	    b.add(s);
	}
	
	int count = 0;
	
	Iterator i = b.iterator();
	
	while (i.hasNext()) {
	    Object s = i.next();
	    count++;
	}
	
	System.out.println(count);
    }
    
    public static void main(String[] a) {
	new B();
	new B();
    }
}
