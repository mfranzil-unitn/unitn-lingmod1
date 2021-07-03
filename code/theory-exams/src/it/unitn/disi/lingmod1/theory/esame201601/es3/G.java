
// OUTOUT: "C"

public class G implements Cloneable {

    int k = 0;

    @Override
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
	if (!(x instanceof G)) {
	    return false;
	}
	return k == ((G) x).k;
    }

    public static void main(String[] args) {
	G b = new G();	    // k = 0
	G c = b.clone();    // k = 1
	G d = new G();	    // k = 0
	
	if (b.equals(c)) {System.out.println("A");}
	if (c.equals(d)) {System.out.println("B");}
	if (b.equals(d)) {System.out.println("C");}
    }
}