package Gennaio2016_Esercizio7;

// OUTPUT: "XA"

public class E {

    static int s = 0;		// è static!

    E(int i) {
	s = i;
    }

    public static void main(String[] args) {
	E b1 = new E(3);	// setta s = 3.
	E b2 = new E(3);	// setta s = 3.
	E b3 = new E(1);	// setta s = 1.
	
	if (b1.equals(b2)) {		// FALSA
	    System.out.print("K");
	} else {
	    System.out.print("X");	// stampa I 
	}
	
	if (b1.s == b3.s) {		// VERA
	    System.out.print("A");	// stampa A
	} else {
	    System.out.print("D");
	}
    }
}

