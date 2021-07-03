
// ERRORE IN FASE DI COMPILAZIONE: Variabili non statiche non possono essere referenziate in un ambiente non statico

public class Sei {
    char f() {return '6';}
    public static void main(String e[]) {
	Sei a = new Sei();
	Sei b = new Sette();		    // ERRORE!
	Sette c = new Sette();		    // ERRORE!
	
	System.out.print(a.f() + " " + b.f() + " " + c.f() + " ");
	
	char ch[] = {'C', 'B', 'C', 'B', 'C', 'B'};
	int i1 = 0,  i2 = 2,  i3 = 4;
	
	if(a.equals(b)) {i1++;}		    // invariato
	if(a.equals(b)) {i1++;}		    // invariato
	if(a.equals(b)) {i1++;}		    // invariato
	System.out.println(ch[i1] + " " + ch[i2] + " " + ch[i3]);
    }
    class Sette extends Sei {
	char f() {return '7';}
	public boolean equals(Object a) {
	    return (a instanceof Sei);	    // Sei (o sottoclasse)
	}
	public int hashCode() {return 3;}
    }
}
