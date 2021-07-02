#include <cstdlib>
#include <cstring>
#include <iostream>

using namespace std;

// OUTPUT: ABC000$H

void f(char x[2], int index, char value) {
	x[index] = value;
}

int main(int argc, char** argv) {
	char a[] = "ABCDEFGHIL";
	strcpy(&a[3], "000");	    // ABC000GHIL

	f(&a[2], 4, '$');	    // ABC000$HIL
	f(&a[2], 6, 0);		    // ABC000$H0L

	cout << a;		    // Blocca la stampa sul numero 0

	return 0;
}
