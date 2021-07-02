package Settembre2011_Esercizio7;

// OUTPUT: 9

public class B {

    public static void main(String args[]) {
	int i, j, k, l = 8;
	k = l++;		// k -> 8, l -> 9
	j = ++k;		// k -> 9, j -> 9
	i = j++;	        // i = 9, j -> 10
	System.out.println(i);	// stampa (9)
    }
}
