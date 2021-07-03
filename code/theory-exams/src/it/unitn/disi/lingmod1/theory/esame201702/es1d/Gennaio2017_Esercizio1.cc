#include <iostream>
using namespace std;

int x[] = {-2, -2, 0, 1, 2};

void f(int* x, int y[]) {
	x[*y] = -y[*x];
}

int main(int argc, char** argv) {
	int* p = x + 1;

	f(p, p);

	for (size_t s = 0; s < x; s++) {
	    cout << *s;
	}

	return 0;
}
