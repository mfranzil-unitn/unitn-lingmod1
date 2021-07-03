#include <cstdlib>
#include <iostream>

using namespace std;

// OUTPUT: 12343

void cambia(int m, int n[7]) {	// m = 5, non guardare il valore di n
    (*(n + m))--;   // diminuisce di una unità m: 5 -> 4, 4 -> 3
    m++;	    // non influenza il valore, è passato per copia
    n--;	    // non influenza il valore, è passato per copia
}

int main() {
    int vet[] = { 1, 2, 3, 4, 5 };

    cambia(vet[4], vet - 1);    // 12344
    cambia(0, &vet[4]);		// 12343

    int i = 0;
    for (i = 0; i < 5; i++) {
	cout << vet[i];		// STAMPA (12343)
    }
    return 0;
}

/*
Prima chiamata:
n punta ad una posizione in memoria prima del primo elem. dell'array,
si sposta di 5 posizioni e diminuisce di un'unità quell'elemento.

Seconda chiamata:
continua a puntare alla stessa area di memoria perché m è pari a 0.
diminuisce di un'unità vet[4] = 4->3
*/