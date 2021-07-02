package Gennaio2017_Esercizio2A;

public class G implements Cloneable {
    int k = 0;
    
    @Override
    public G clone() {
	G copia = null;
	
	try {
	    copia = (G)super.clone();
	} catch (CloneNotSupportedException e) {
	    System.exit(0);
	}
	
	copia.k++;
	return copia;
    }
    
    @Override
    public int hashCode() {
	return 0;
    }
    
    @Override
    public boolean equals(Object x) {
	if ( !(x instanceof G) ) {
	    return false;
	}
	
	return k == ((G)x).k;
    }
    
    public static void main(String[] args) {
	G b = new G();
	G c = (G) (b.clone());
	G d = new G();
	
	if(b.equals(c)) System.out.println("A");
	if(c.equals(d)) System.out.println("BA");
	if(d.equals(b)) System.out.println("AB");
    }
}