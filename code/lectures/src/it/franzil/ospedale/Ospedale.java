package it.franzil.ospedale;

import java.util.Scanner;

public class Ospedale {

    public Ospedale() {
        char choice;
        Paziente temp;
        try (Scanner input = new Scanner(System.in)) {
            CodaPriorita queue = new CodaPriorita();
            do {
                System.out.println("Operazioni: Inserisci (i) / Rimuovi (r) / Mostra coda (m) / Esci (e)");
                choice = input.next().charAt(0);
                switch (choice) {
                    case 'i':
                        temp = new Paziente();
                        queue.inserisci(temp);
                        break;
                    case 'r':
                        queue.estrai();
                        break;
                    case 'm':
                        queue.mostra();
                        break;
                    case 'e':
                        input.close();
                        System.exit(0);
                    default:
                        System.out.println("Scelta non valida!");
                        break;
                }
            } while (choice != 'i' || choice != 'r' || choice != 'm' || choice != 'e');
        } catch (Exception e) {
            System.out.println("Critical failure. <" + e + "> See log for details. Terminating...");
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        Ospedale p = new Ospedale();
    }

    public static String intToPri(int i) {
        String retval;
        switch (i) {
            case 0:
                retval = "Rosso";
                break;
            case 1:
                retval = "Giallo";
                break;
            case 2:
                retval = "Verde";
                break;
            case 3:
                retval = "Bianco";
                break;
            default:
                retval = "-";
                break;
        }
        return retval;
    }

}