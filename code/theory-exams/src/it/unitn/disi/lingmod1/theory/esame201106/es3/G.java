
// OUTPUT: C

public class G implements Cloneable {

    int k = 0;
    
    public G clone() {
	G copia = null;
	try {
	    copia = (G) super.clone();
	} catch (CloneNotSupportedException ex) {
	    System.exit(0);
	}
	copia.k++;
	return copia;
    }
    
    public boolean equals(Object x) {
	if (!(x instanceof G)) {return false;}	// lo salta sempre
	return k == ((G)x).k;			// confronta i valori di k
    }

    public static void main(String[] args) {
	G b = new G();	    // k = 0
	G c = b.clone();    // k = 1
	G d = new G();	    // k = 0
	
	if (b.equals(c)) {System.out.println("A");} // FALSO
	if (c.equals(d)) {System.out.println("B");} // FALSO
	if (b.equals(d)) {System.out.println("C");} // VERO
    }
}
