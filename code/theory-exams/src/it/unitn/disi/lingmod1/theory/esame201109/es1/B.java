
// OUTPUT: "X"

public class B implements Cloneable {

    int k = 0;

    @Override
    public Object clone() {
	Object copia = null;
	try {
	    copia = super.clone();
	} catch (CloneNotSupportedException ex) {
	    System.exit(0);
	}
	((B)copia).k++;
	return copia;
    }

    @Override
    public boolean equals(Object x) {
	if (!(x instanceof  B)) {
	    return false;
	}
	return k == ((B) x).k;
    }

    public static void main(String[] args) {
	B b = new B();	    // k = 0
	B c = (B)b.clone(); // k = 1
	B d = new B();	    // k = 0
	
	if (b.equals(c)) {System.out.println("Z");} // FALSO
	if (c.equals(d)) {System.out.println("Y");} // FALSO
	if (b.equals(d)) {System.out.println("X");} // VERO

    }
}