
class E {
    static int s = 0;
    E(int i) {
	s = i;
    }
    public static void main(String[] args) {
	E b1 = new E(3);
	E b2 = new E(3);
	E b3 = new E(1);

	if(b1.equals(b2)) {
	    System.out.print("Gr.l");
	} else {
	    System.out.print("E6");
	}
	
	if(b1.s ==  b3.s) {
	    System.out.println("26");
	} else {
	    System.out.println("36");
	}
    }
}
