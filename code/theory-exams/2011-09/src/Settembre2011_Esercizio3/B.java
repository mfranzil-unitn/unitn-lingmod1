package Settembre2011_Esercizio3;

// OUTPUT: 13

public class B {

    static int s = 0;

    B(int i) {
	s = i;
    }

    public static void main(String[] args) {
	B b1 = new B(3);	   
	B b2 = new B(3);	   
	B b3 = new B(1);
	
	if (b1.equals(b2)) {		// FALSA
	    System.out.print("3");
	} else {System.out.print("1");}	// STAMPA(1)
	
	if (b1.s == b3.s) {		// VERA
	    System.out.print("3");	// STAMPA(3)
	} else {System.out.print("1");}
    }
}
