package Settembre2011_Esercizio5;

// ERRORE IN FASE DI COMPILAZIONE - Riferimento ad metodo non statico da contesto statico

public class B {

    static String k = "pluto";

    public static void main(String a[]) {
	new B();
	initialize("pippo");	    // ERRORE
	System.out.println(k);
    }

    void main() {
	new B();
    }

    void initialize(String s) {
	k = s;
    }
}

/*
Il main, definito statico, non può accedere alla funzione initialize definita non statica.
Devo istanziare un oggetto di tipo B per poter usare il metodo initialize.
*/