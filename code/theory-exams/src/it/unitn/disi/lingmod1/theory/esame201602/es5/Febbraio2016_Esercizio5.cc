#include <iostream>
#include <cstring>
using namespace std;

// OUTPUT: ABC000$G

void f (char x[2], int index, char value) {
	x[index] = value;
}

int main (int argc, char** argv) {	// equivalente a (int argc, char* argv[])
    char a[] = "ABCDEFGHIL";
    strcpy(&a[3],"000");	// "ABCDEFGHIL" -> "ABC000GHIL"

    f(&a[2],4,'$');		// "ABC000GHIL" -> "ABC000$HIL"
    f(&a[2],6,0);		// "ABC000GHIL" -> "AB000$GØIL"
				// lo 0 (in numero) e' un terminatore di riga
    cout << a;			// stampa l'array fino al terminatore di riga

//  stampa dell'array completo
//	for (int i = 0; i < 10; i++) {
//		cout << "a[" << i << "]:" << a[i] << endl;
//	}

    return 0;
}
