
// NOTA :QUESTA CLASSE E’ NEL FILE A.java
// ERRORE IN FASE DI COMPILAZIONE - Acesso negato alla variabile

public class A {

    int x = 3;	// public int x = 3; variabile di classe

    public static void main(String string[]) {
	(new Teorico2009_Esercizio3_1.B()).f();
    }
}

/*
La variabile x è accessibile solo nel proprio package,
in quanto non ha specificatori di visibilità.
*/
