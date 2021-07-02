#include <iostream>
#include <cassert>

using namespace std;

class Pila {
private:
	int size;
	int defaultGrowthSize;
	int marker;
	int * contenuto;
	void cresci(int increment);
public:
	Pila(int initialSize);
	~Pila ();
	void copia(Pila * to) ;
	void inserisci(int k) ;
	void stampaStato() ;
	int estrai();
};

int main() {
	Pila * s = new Pila(5);
	cout << "s"; s->stampaStato();
	for (int k=1; k<10; k++) {
		s->inserisci(k);
	}
	cout << "s"; s->stampaStato();
	
	Pila * w;
	s->copia(w);
	cout << "w"; w->stampaStato();
	
	for (int k = 1; k < 8; k++) {
		cout << s->estrai() << endl;
	}
	cout << "s"; s->stampaStato();
	
	delete s;
	cout << "s"; s->stampaStato();
	
	for (int k=1; k<15; k++) {	
		cout << s->estrai() << endl;
	}
	cout << "w"; w->stampaStato();
}

Pila::Pila(int initialSize) {
	size = initialSize;
	defaultGrowthSize = initialSize;
	marker = 0;
	contenuto = new int[initialSize];
}

Pila::~Pila() {
	delete []contenuto;
}

void Pila::cresci(int increment) {
	size += increment;
	int * temp = new int[size];
	for (int k=0; k<marker; k++) {	
		temp[k] = contenuto[k];
	}
	delete [](contenuto);
	contenuto = temp;
}

void Pila::inserisci(int k) {
	if (size == marker) {
		cresci(defaultGrowthSize);
	}
	contenuto[marker] = k;
	marker++;
}

int Pila::estrai() {
	assert(marker > 0);
	return contenuto[--(marker)];
}

void Pila::stampaStato() {
	cout << "==================" << endl;
	cout << "size = " << size << endl;
	cout << "defaultGrowthSize = " << defaultGrowthSize << endl;
	cout << "marker = " << marker << endl;
	for (int k=0; k < marker; k++) {
		cout << "[" << (contenuto[k]) << "]";
	}
	cout << endl;
	cout << "==================" << endl;
}

void Pila::copia(Pila * to) {
	to = new Pila(size);
	to->defaultGrowthSize = defaultGrowthSize;
	for (int k=0; k < marker; k++) {	
		to->contenuto[k] = contenuto[k];
	}
	to->marker = marker;
}