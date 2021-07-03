#include <iostream>
using namespace std;

void g(char x[], int y) {
    y--;
    x[y]--;
}
void f(char *x, int *y) {
    (*y)++;
    x[*y]++;
}

int main() {
    char x[2];
    int y;
    x[0] = 'E'; x[1] = 'E'; y = 0;

    f(x, &y);
    g(x, y);

    cout << x[0] << " " << x[1] << " " << y;
    
    return 0;
}
