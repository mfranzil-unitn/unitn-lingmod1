package Settembre2011_Esercizio4;

// ERRORE IN FASE DI COMPILAZIONE - Array scritto erroneamente

public class B {

    String a[10];   //String a[] = new String[10];

    void initialize() {
	for (int k = 9; k >= 0; --k) {
	    a[k] = "" + k;
	}

    }

    void stampa(int k) {
	System.out.println(a[k]);
    }

    B() {
	initialize();
	stampa(0);
    }

    public static void main(String a[]) {
	new B();
    }

    public static void main(String a) {
	new B();
    }

}
