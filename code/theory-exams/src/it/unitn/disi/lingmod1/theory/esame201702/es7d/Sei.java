
public class Sei {
    char f() {
	return '6';
    }
    
    public static void main(String e[]) {
	Sei a = new Sei();	    // → 6
	Sei b = new Sette();	    // → 7
	Sette c = new Sette();	    // → 7
	
	System.out.print(a.f() + " " + b.f() + " " + c.f() + " ");
	
	char ch[] = {'C','B','C','B','C','B'};
	int i1 = 0, i2 = 2, i3 = 4;
	
	if (a.equals(b)) {i1++;}    // 0 → C
	if (b.equals(a)) {i2++;}    // 3 → B
	if (c.equals(b)) {i3++;}    // 5 → B
	
	System.out.println(ch[i1] + " " + ch[i2] + " " + ch[i3]);
    }
}

class Sette extends Sei {
    char f() {
	return '7';
    }
    public boolean equals(Object a) {
	return (a instanceof Sei);
    }
    public int hashCode() {
	return 3;
    }
}
