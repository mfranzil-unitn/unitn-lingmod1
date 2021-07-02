package Giugno2011_Esercizio1;

// OUTPUT: IA

class E {

    static int s = 0;		// N.B. è una variabile statica  

    E (int i) {
	s = i;
    }

    public static void main(String[] args) {
	E b1 = new E(3);	// setta s = 3.
	E b2 = new E(3);	// setta s = 3.
	E b3 = new E(1);	// setta s = 1.
	
	if (b1.equals(b2)) {		// FALSA
	    System.out.print("K");
	} else {System.out.print("I");}	// STAMPA(I)
	
	if (b1.s == b3.s) {		// VERA
	    System.out.print("A");	// STAMPA(A)
	} else {System.out.print("D");}
    }
}
