package Teorico2009_Esercizio7;

// OUTPUT: ZAB

class A {
    A (int x) {System.out.println("X");}
    A () {System.out.println("Z");}
    public void finalize() {System.out.println("Y");}
}

class B extends A {
    B(int x) {System.out.println("A");}
    B() {System.out.println("C");}
    public void finalize() {System.out.println("B");}
}

public class Prova {
    public static void main(String args[]) {
	A a = new B(3);		    // B -> A, STAMPA(Z|A)
	a = null;		    // dealloca il contenuto della variabile a.
	System.gc();		    // chiama il garbageCollector che si porta via a.
	System.runFinalization();   // chiama il metodo finalize() di "B", STAMPA(B).
    }
}

/*
I costruttori vengono chiamati in ordine:
- Prima il cotruttore vuoto di A

(poichè deve essere chiamato il costruttore della superclasse,
ma a meno di indicazioni con "super" viene chiamato quello vuoto,
di default se non è esplicitamente definito)

- Poi il costruttore di B effettivamente chiamato con il passaggio di parametro.

Il Garbage Collector marca l'oggetto "a" come "finalizzabile"
dato che può essere eliminato poichè non viene utilizzato e il suo valore è "null".

La runFinalization() esegue tutti i metodi "finalize" degli oggetti marcati come "finalizzabili" dalla gc(),
dunque dato che l'elemento "a" è allocato con le caratteristiche di un oggetto di tipo B,
la "finalize" che viene eseguita è quella di B.
*/
