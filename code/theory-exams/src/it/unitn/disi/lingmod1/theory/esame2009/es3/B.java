
// NOTA :QUESTA CLASSE E’ NEL FILE B.java

public class B extends Teorico2009_Esercizio3.A {

    public void f() {
	System.out.println(++x);
    }
}

/*
Errore di compilazione alla riga 8,
poichè  la variabile "x" non è visibile nel package "Teorico2009_Esercizio3_1" e quindi non accassibile,
dato che NON è definita "public" nel package "esame".
*/