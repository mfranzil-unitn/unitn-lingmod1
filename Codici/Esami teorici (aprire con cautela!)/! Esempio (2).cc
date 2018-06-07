#include <iostream>

using namespace std;

void g(char x[], int y) {
	y--;					// y = 1, y -> 0
	x[y]--;					// x[0]--: R -> Q
}

void f(char *x, int *y) {	// l'array è passato per riferimento
	(*y)++;					// y = 0, y -> 1
	x[*y]++;				// x[1]++: R -> S
}

int main() {
	char x[2];
	int y;
	
	x[0] = 'R';
	x[1] = 'R';				// x = "RR0"
	y = 0;
	
	f(x, &y);				// y passata per riferimento
	g(x, y);				// NB! y non è passato per riferimento, ma solo per valore
	
	cout << x[0] << " " << x[1] << " " << y;	// stampa (Q S 1)
	
	return 0;
}
