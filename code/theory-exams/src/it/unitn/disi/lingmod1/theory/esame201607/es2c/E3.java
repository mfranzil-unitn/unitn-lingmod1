
import java.util.Iterator;
import java.util.LinkedList;

// OUTPUT: nomePackage.G|5 nomePackage.E3|7 F|6

public class E3 {
    static int counter = 4;		// mantiene il suo valore per ogni istanza
    private int value = 2;
    E3() {
	value = ++counter;
    }
    public String toString() {
	return this.getClass().getName() + value + " ";	// STAMPA(G|5) + STAMPA(E3|7)
    }
    public void finalize() {
	System.out.print("F" + value);			// STAMPA(F|6)
    }
    
}

class G extends E3 {	// è una sottoclasse, il suo costruttore chiama il costruttore di E3
    public static void main(String d[]) {
	LinkedList<E3> x = new LinkedList<E3>();    // Può contenere duplicati
	E3 a1 = new G();			    // counter: 4 -> 5; value: 2 -> 5;
	G a2 = new G();				    // counter: 5 -> 6; value: 5 -> 6;
	E3 a3 = new E3();			    // counter: 6 -> 7; value: 6 -> 7;
	
	x.add(a1); x.add(a3);			    // aggiunge "a1","a3" alla Linkedist
	a1 = null; a2 = null; a3 = null;	    // dealloca "a2", agirà GC su di lui
	
	Iterator<E3> it = x.iterator();
	while (it.hasNext()) {
	    System.out.print(it.next());	    // richiama toString() per "a1" e "a3"
	}
	
	System.gc(); System.runFinalization();	    // richiama finalize() per "a2"
    }
}