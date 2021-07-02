package it.franzil.ospedale;

public class CodaPriorita {

    final int DIM = 4; // 0 = Rosso, 1 = Giallo, 2 = Verde, 3 = Bianco
    public Coda[] array = new Coda[DIM];

    public CodaPriorita() {
        for (int i = 0; i < 4; i++)
            array[i] = new Coda(5);
    }

    public void inserisci(Paziente in) {
        array[in.priority].inserisci(in);
        System.out.println("Inserimento del paziente " + in.name + " con priorità " + Ospedale.intToPri(in.priority));
    }

    public void estrai() {
        Paziente temp;
        for (int i = 0; i < 4; i++) {
            if (!(array[i].isEmpty())) {
                temp = array[i].estrai();
                System.out.println("Estrazione del paziente " + temp.name + " con priorità " + Ospedale.intToPri(temp.priority));
                break;
            } else {
                System.out.println("Coda a priorità " + Ospedale.intToPri(i) + " vuota");
            }
        }
    }

    public void mostra() {
        for (int i = 0; i < 4; i++)
            if (!(array[i].isEmpty()))
                array[i].stampa();
            else
                System.out.println("Coda a priorità " + Ospedale.intToPri(i) + " vuota\n");
    }
}
