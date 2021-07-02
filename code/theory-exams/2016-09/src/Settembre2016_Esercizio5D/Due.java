package Settembre2016_Esercizio5D;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// ERRORE IN FASE DI COMPILAZIONE - 

public class Due {
    Collection<Due> s = new HashSet<Set>(); // ERRORE!
    
    static int k,j;
    Due(int k, int j) {this.k = k; this.j = j;}
    public boolean equals(Object d){
	return k-j == ((Due)d).j - ((Due)d).k;
    }
    public int hashCode() {return 1;}
    public static void main(String[] m) {
	s.add(new Due(1,2)); s.add(new Due(0,1));
	s.add(new Due(2,1)); s.add(new Due(1,0));
	System.out.print(s.size());
	for (Due x:s) {System.out.print(x.k + " " + x.j);}
    }
}
