#include <iostream>

using namespace std;

void g(char x[], int y) {	
	y--;					// y = 1->0
	x[y]--;					// x[0]-- => D -> C
}

void f(char *x, int *y) {	// l'array � passato per riferimento
	(*y)++;					// y = 0->1
	x[*y]++;				// x[1]++: D->E
}

int main() {
	char x[2];    
	int y;
	
	x[0] = 'D';
	x[1] = 'D';	// x = "DD"
	y = 0;
	
	f(x, &y);	// y passata per riferimento
	g(x, y); 	// NB! y non e' passato per riferimento, ma solo per copia
	
	cout << x[0] << " " << x[1] << " " << y;    // stampa (C E 1)
	
	return 0;
}
