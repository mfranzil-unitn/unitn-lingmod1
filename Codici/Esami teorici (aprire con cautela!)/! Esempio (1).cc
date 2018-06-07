#include <iostream>
#include <cstring>

using namespace std;

void f (char x[2], int index, char value) {
	x[index] = value;
}

int main (int argc, char** argv) {	// equivalente a (int argc, char* argv[])
	char a[] = "ABCDEFGHIL";
	strcpy(&a[2],"000");	// "ABCDEFGHIL" -> "AB000FGHIL"
	
	f(&a[2],3,'$');			// "AB000FGHIL" -> "AB000$GHIL"
	f(&a[2],5,0);			// "AB000$GHIL" -> "AB000$G0IL"
							// lo 0 è un terminatore di riga
	cout << a;				// stampa l'array fino al terminatore di riga
	
	// stampa dell'array completo
//	for (int i = 0; i < 10; i++) {
//		cout << "a[" << i << "]:" << a[i] << endl;
//	}
	
	return 0;
}
