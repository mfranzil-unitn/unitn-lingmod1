#include <iostream>
using namespace std;

// OUTPUT: FH1

void g (char x[], int y) {  // x[] per riferimento, y per copia
    y--;		    // y = 1->0
    x[y]--;		    // x[0]-- => G->F
}

void f (char *x, int *y) {  // entrambi per riferimento.
    (*y)++;		    // y = 0->1
    x[*y]++;		    // x[1]++ => G->H
}

int main() {
    char x[2];
    int y;
	
    x[0] = 'G';	    // G0
    x[1] = 'G';	    // GG
    y = 0;
	
    f(x, &y);	    // GH, y = 1
    g(x, y);	    // FH, y = 1

    cout << x[0] << " " << x[1] << " " << y;	// F H 1
    
    return 0;
}
