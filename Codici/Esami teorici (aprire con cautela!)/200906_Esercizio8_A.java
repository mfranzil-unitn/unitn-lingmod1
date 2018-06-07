package Teorico2009_Esercizio8;

// OUTPUT: 66

public class A {

    void f(int k) {
	System.out.print(k * 3);
    }

    public static void main(String args[]) {
	Object z = new B();	    // non succede nulla.
	
	if (z instanceof Teorico2009_Esercizio8.A) {((A) z).f(3);}  // UPCAST di z alla superclasse A.
	if (z instanceof Teorico2009_Esercizio8.B) {((B) z).f(3);}  // DOWNCAST di z alla superclasse B.
    }
}

class B extends A {

    @Override
    void f(int k) {
	System.out.print(k * 2);    // STAMPA(6), STAMPA(6).
    }
}

/*
Infatti l'oggetto "z" è un'istanza sia di A che di B (poichè B is-a A),
ma quando viene chiamato il metodo z.f(3) in entrambi i casi (nonostante il cast)
viene eseguito quello di B dato che z è di tipo B.

(Il cast è comunque possibile grazie alla relazione di parentela tra le classi, ma non influenza l'output).
*/