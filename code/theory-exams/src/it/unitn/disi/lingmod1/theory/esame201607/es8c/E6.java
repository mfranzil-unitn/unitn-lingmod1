
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class E6 {
    static Collection ll = new LinkedList();
    
    int x = 6;
    
    E6() {}
    E6(int x){
	ll.add(this);
	ll.add(new E5A());
    }
    public static void main(String z[]) {
	new E6(3);
	Iterator iter = ll.iterator();
	while (iter.hasNext()) {
	    ((E6)(iter.next())).f();
	}
    }
    public void f() {
	System.out.print(x);
    }
    class E5A extends E6 {
	public void f() {
	    x++;
	    super.f();
	    System.out.print(2);
	}
    }
}
