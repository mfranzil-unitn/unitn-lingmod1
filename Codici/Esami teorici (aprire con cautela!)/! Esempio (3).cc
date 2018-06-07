#include <iostream>

using namespace std;

int k = 2;

void f (int m) {
	m = m * 2;			// non viene tornato il valore
}

void g (int *m) {
	//cout << "*m: " << *m << endl;
	m++;				// k rimane invariato in quanto AUMENTA LA REFERENZA
	//cout << "*m: " << *m << endl;
}

void h (int m[4]) {		// utilizza il 1° elemento.
	//cout << "m[0]: " << m[0] << " prima di m[0]--." << endl;	// stampa (5)
	m[0]--;				// k = 6, k -> 5
	//cout << "m[0]: " << m[0] << " dopo di m[0]--." << endl;		// stampa (4)
	//cout << "m[4]: " << m[4] << endl;							// stampa (0)
}

void p () {
	cout << k;
}

int main () {
	int k = 5;
	
	g(&k);
	h(&k);
	f(k);				// viene passata per valore
	
	cout << k;			// stampa (5): scope locale
	p();				// stampa (2): scope globale
	
	return 0;
}
