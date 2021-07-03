
import java.util.HashSet;

// OUTPUT: 101000

public class E2 {

    static HashSet hs = new HashSet();

    public int hashCode() {
	return 0;
    }

    public boolean equals(Object x) {
	return (x.getClass().equals(this.getClass()));
    }

    public static void main(String s[]) {
	f(new E2()); f(new E2());
	f(new A2()); f(new A2());
	f(new A3()); f(new A3());
    }

    static void f(E2 x) {
	int v = 0;
	if (hs.add(x)) {
	    v = 1;
	}
	System.out.print(v);
    }
}

class A2 extends E2 {

    @Override
    public boolean equals(Object x) {
	return x instanceof A2;
    }
}

class A3 extends A2 {}

/*
SPIEGAZIONE

static HashSet hs = new HashSet();

L'HashSet effettua ciclicamente il metodo equals() della classe di appartenenza,
e se questo risulta vero, l'elemento non viene aggiunto.


f(new E2());	// stampa (1), aggiunto perchè non ci sono istante con la stessa classe
f(new E2());	// stampa (0), non viene aggiunto perchè è della stessa classe di E2 già aggiunto
f(new A2());	// stampa (1), aggiunto perchè il metodo equals di A2 viene testato sull'unico oggetto contenuto nell'hs (E2)
f(new A2());	// stampa (0), non viene aggiunto perchè è un oggetto contenuto nell'hs è istanza di A2 (A2)
f(new A3());	// stampa (0), non viene aggiunto perchè è un oggetto contenuto nell'hs è istanza di A2 (A2)
f(new A3());	// stampa (0), non viene aggiunto perchè è un oggetto contenuto nell'hs è istanza di A2 (A2)


return (x.getClass().equals(this.getClass()));

// se la classe dell'oggetto è uguale a quella degli oggetti già contenuti
// 1°: risulta falso, quindi hs.add(x) risulta vero
// 2°: risulta vero, quindi hs.add(x) risulta falso


return x instanceof A2;

// 3°: risulta falso, quindi hs.add(x) risulta vero
// 4°: risulta vero, quindi hs.add(x) risulta falso
// 5°: risulta vero, quindi hs.add(x) risulta falso
// 6°: risulta vero, quindi hs.add(x) risulta falso
*/