#include <iostream>
using namespace std;

// OUTPUT: 

int x[] = {-2, -1, 0, 1, 2};

void f(int* x, int y[]) {   // -1, -1, puntano entrambi alla posizione x+1, quindi al valore -1
    x[*y] = -y[*x];	    // x[-1] = -y[-1], l'elemneto in posizione -1 e' uguale a sé stesso cambiato di segno
}

int main(int argc, char** argv) {
    int* p = x + 1;	// -1

    f(p, p);		// -1, -1

    for (int *s = x; s < x + 5; s++) {
	cout << *s;	    // STAMPA(2 -1 0 1 2)
    }

    return 0;
}