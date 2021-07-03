
import java.util.Iterator;
import java.util.LinkedList;

// OUTPUT: nomePackage.G|5 nomePackage.E3|7 F|6

public class E3 {

    static int counter = 4;
    private int value = 2;

    E3() {
	value = ++counter;
    }

    @Override
    public String toString() {
	return this.getClass().getName() + value + " ";	// nomePackage.classe + value + " "
    }

    @Override
    public void finalize() {
	System.out.print("F" + value);			// F + value
    }
}

class G extends E3 {
    public static void main(String d[]) {
	LinkedList<E3> x = new LinkedList<E3>();
	E3 a1 = new G();    // value = 5, counte = 4->5
	G a2 = new G();	    // value = 6, counte = 5->6
	E3 a3 = new E3();   // value = 7, counte = 6->7
	
	x.add(a1); x.add(a3);
	a1 = null; a2 = null; a3 = null;
	
	Iterator<E3> it = x.iterator();
	while (it.hasNext()) {
	    System.out.print(it.next());	    // utilizza il toString
	}
	
	System.gc();				    // raccoglie solo a2 che è inutilizzato
	System.runFinalization();
    }
}
