#include <iostream>
#include <cassert>				//a quale libreria si riferisce?
#define DEBUG						//a cosa serve?

using namespace std;

struct Pila {
	int size;
	int defaultGrowthSize;
	int marker;
	int * contenuto;
} ;

Pila * crea(int initialSize) ;
void distruggi(Pila * s) ;
Pila * copia(Pila * from) ;
void cresci(Pila *s, int increment);
void inserisci(Pila *s, int k) ;
int estrai(Pila *s) ;
void stampaStato(Pila *s) ;

int main() {
	Pila * s = crea(5);
	cout << "s"; stampaStato(s);	//pila inizializzata ma vuota
	
	for (int k=1; k<10; k++) {		//riempio la pila
		inserisci(s,k);
	}
	cout<<"s"; stampaStato(s);
	
	Pila * w = copia(s);			//copio la pila s in una pila w
	cout<<"w"; stampaStato(w);
	
	for (int k=1; k<8; k++) {		//estraggo i primi 7 elementi della pila s
		cout << estrai(s) << endl;
	}
	cout << "s"; stampaStato(s);
	
	//s->distruggi();						//distruggo la pila s
	//cout << "s"; stampaStato(s);
	
	for (int k=1; k<15; k++) {			//estraggo i primi 14 elementi della pila w, più di quanti ce ne siano, mi aspetto che l'assert mi avverta
		cout << estrai(w) << endl;
	}
	cout << "w"; stampaStato(w);
}


//crea una Pila
Pila * crea(int initialSize) {

	#ifdef DEBUG
	cout << "entro in crea" << endl;
	#endif
	
	Pila * s = new Pila ;				//creo un oggetto con le proprietà della struct Pila
	s->size = initialSize;				//equivalente a scriver *s.size, deferenzia la variabile s e prendi size nella struct, initialSize definito dall'utente
	s->defaultGrowthSize = initialSize;
	s->marker=0;						//non ho dati all'interno della Pila
	s-> contenuto = new int[initialSize];	//contenuto è un indirizzo, gli assegno il valore di ritono della new
	return s;
}

//distruggi la Pila
void distruggi(Pila * s) {

	#ifdef DEBUG
	cout << "entro in destroy" << endl;
	#endif

	delete s;
	delete [](s->contenuto);			//deve prendere l'indirizzo della pila da distruggere,
							//L'ordine nella delete è fondamentale, cancello prima l'array e poi la struttura che la contienepila
}

//aumenta la dimensione dello Pila
void cresci(Pila *s, int increment){
	
	cout << "entro in cresci" << endl;
	
	s->size += increment;				//aggiorno la variabile che definisce la grandezza della Pila
	int * temp = new int[s->size];		//creo una Pila temporanea della dimensione doppia rispetto agli elementi che ci metterò dentro
	for (int k=0; k<s->marker; k++) {	//procedura di copiatura degli elementi presenti nella vecchia locazione di memoria
		temp[k] = s->contenuto[k];		//in quella nuova creata dalla Pila temporanea.
	}
	delete [](s->contenuto);			//elimino la "vecchia" parte di pila con gli elementi duplicati
	s->contenuto = temp;				//aggiorno l'indirizzo di memoria della nuova pila piena per metà
}										//se non copio l'indirizzo di temp perdo la "maniglia" e non riesco a recuperare lo spazio in memoria

//OPERAZIONI SULLA PILA

//inserisci un nuovo valore
void inserisci(Pila *s, int k) {		//l'identificatore della pila che non è altro che l'indirizzo in cui la pial si trova e un parametro da inserire
	
	cout << "entro in inserisci" << endl;
	
	if (s->size == s->marker) {			//gestisce la situazione in cui la pila è piena
		cresci(s,s->defaultGrowthSize);	//chiama la funzione cresci passando come parametri l'indirizzo della pila e di quanto deve incrementarla
	}
	s->contenuto[s->marker] = k;		//inserisco il prametro nella posizione del marker
	s->marker++;						//aumento il marker che segna la prima cella libera di un'unità
}

//estrai l’ultimo valore
int estrai(Pila *s) {
	
	cout << "entro in estrai" << endl;
	
	assert(s->marker > 0);				//assert valuta l'espressione, se questa risulterà vera il programma eseguirà il codice restante
										//in caso contrario stamperà che l'asserzione è risultata falsa e finirà l'esecuzione del programma
										//marker in questo caso deve avere un valore maggiore di 0 affinchè non ritorni un valore che si trova fuori dal range della pila (-1).
										//ritorna il valore dell'ultimo elemento contenuto nella pila
	return s->contenuto[--(s->marker)];	//non c'è bisogno di sovrascrivere il valore all'interno della cella tralasciata, in quanto non verrà più letta.
}

//stampa lo stato dello Pila
void stampaStato(Pila *s) {
	cout << "==================" << endl;		//stampa lo stato dello Pila per funzione di controllo
	cout << "size = " << s->size << endl;		//il valore di size
	cout << "defaultGrowthSize = " << s->defaultGrowthSize << endl;	//il valore di defaultGrowthSize
	cout << "marker = " << s->marker << endl;	//il valore di marker
	for (int k=0; k < s->marker; k++) {				//tramite un ciclo stampiamo il contenuto della pila
		cout << "[" << (s->contenuto[k]) << "]";
	}
	cout << endl;
	cout << "==================" << endl;
}

/*
Vogliamo definire la Pila come se fosse un vero e proprio tipo, 
come per le stringhe dove utilizziamo la funzione strcpy(a,b); 
vogliamo definire una funzione di copia

Pila * k = new Pila[10];
Pila * s;
s = copia(k);
*/

//copia una pila (to) su una nuova pila (from)
Pila * copia(Pila * from) {
	
	cout << "entro in copia" << endl;
	
	Pila * to = crea(from->size);					//creo una nuova pila della stessa dimensione di quella di partenza
	to->defaultGrowthSize = from->defaultGrowthSize;//copio il valore di defaultGrowthSize
	for (int k=0; k < from->marker; k++) {			//tramite un ciclo copio gli elementi uno ad uno
		to->contenuto[k] = from->contenuto[k];
	}
	to->marker = from->marker;						//copio il valore di marker
	return to;
}

/*
Le due pile sono uguali ma non sono lo stessa cosa.
Gli indirizzi che le identificano sono diversi, 
ma gli elementi in esse contenuti sono gli stessi
*/
