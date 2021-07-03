#include <iostream>

using namespace std;

// OUTPUT: QS1

void g (char x[], int y) {	// x per riferimento, y per copia.
    y--;			// 1 -> 0, è passato per copia, non influenza l'esterno
    x[y]--;			// R -> Q
}

void f (char *x, int *y) {	// *x <=> x[], entrambi per riferimento.
    (*y)++;			// 0 -> 1
    x[*y]++;			// R -> S
}

int main() {
    char x[2];			// 00
    int y;

    x[0] = 'R';			// R0
    x[1] = 'R';			// RR
    y = 0;

    f(x, &y);			// RS, y = 1
    cout << y;
    g(x, y);			// QS, y = 1

    cout << x[0] << " " << x[1] << " " << y;	// stampa (Q S 1)

    return 0;
}
