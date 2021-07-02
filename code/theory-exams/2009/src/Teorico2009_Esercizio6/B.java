package Teorico2009_Esercizio6;

// OUTPUT: BD

class B {
    static int s = 0;			// N.B. è una variabile statica
    
    B(int i) {
	s = i;
    }

    public static void main(String[] args) {
	B b1 = new B(3);	   
	B b2 = new B(3);	   
	B b3 = new B(1);
	
	if (b1.equals(b2)) {		// FALSO, equivalente a (b1 == b2)
	    System.out.print("A");
	} else {System.out.print("B");}	// STAMPA(B)
	
	if (b1.s == b3.s) {		// VERO
	    System.out.print("D");	// STAMPA(D)
	} else {System.out.print("C");}
    }
}

/*
"b1.equals(b2)" risulta FALSO poichè,
nonostante i valori contenuti siano uguali,
si tratta di due elementi diversi in memoria (b1 e b2),
creati in due diverse allocazioni.

"b1.s == b3.s" risulta VERO poichè l'elemento "s" è uno solo per tutte le istanze (vedi Esercizio5)
e dunque il valore viene modificato per tutte.

Dopo "B b3 = new B(1)" si ha

b1.s == 1.
b2.s == 1.
b3.s == 1.

*/
