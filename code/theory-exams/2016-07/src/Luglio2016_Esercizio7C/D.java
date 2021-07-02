package Luglio2016_Esercizio7C;

// CLASSES: D ⊂ Pippo ← Pippo2
// OUTPUT: X53 | X53 | 3X5 | 35X | 5X3 | 53X

public class D {
    static int x = 2;
    
    public static void main(String[] args) {
	D a5 = new D();	    a5.f();
	a5 = new D();	    a5.f();	
	System.gc();	System.runFinalization();
    }
    
    void f() {
	Pippo a = new Pippo2();
    }
    
    public void finalize() {
	System.out.print("X");
    }
    
    class Pippo {
	int k;
	Pippo() {
	    k = ++x;
	}
	public void finalize() {
	    System.out.print(k);
	}
    }
    class Pippo2 extends Pippo {// Eredita k da Pippo
	Pippo2() {
	    k = x++;		
	}
    }
}

/*
I costruttori chiamano ricorsivamente i costruttori dei loro padri,
si risolvono al contrario.

Legenda: → = chiama/diventa

1) a5.f() → b) Pippo2 → a) Pippo
2) a5.f() → d) Pippo2 → c) Pippo

a) Pippo:   x: 2→3,	k→3
     ↓
b) Pippo2:  k = x = 3,	x: 3→4

Prima chiamata valori: k = 3, x = 4.

c) Pippo:   x: 4→5,	k→5
     ↓
d) Pippo2:  k = x = 5,	x: 5→6

Seconda chiamata valori: k = 5, x = 6.

Chiamata forzata del Garbage Collector:
System.gc();	System.runFinalization();

"a5" di Tipo D:			STAMPA(X)
"a" 1ª chiamata di tipo Pippo:	STAMPA(3)
"a" 2ª chiamata di tipo Pippo:	STAMPA(5)

Non si sa in che ordine vengano chiamate le funzioni finalize,
quindi le stampe avvengono in ordine casuale.

*/