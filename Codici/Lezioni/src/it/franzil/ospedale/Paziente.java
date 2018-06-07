package it.franzil.ospedale;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Paziente {
    
    public String name;
    public int priority;
    
    public Paziente() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nome del paziente?");
        name = input.next();
        do {
            try {
            System.out.println("Priorità? [0 = Rosso, 1 = Giallo, 2 = Verde, 3 = Bianco]");
            priority = input.nextInt();
            } catch (InputMismatchException e) {
            System.out.println("Invalid priority! Setting it to BIANCO.");
            priority = 3;
            }
        } while ( priority < 0 || priority > 3);
    }  

    @Override
    public String toString() {
        return ("Paziente: " + name + "\nPriorità: " + Ospedale.intToPri(priority) + "\n");
    }
}
