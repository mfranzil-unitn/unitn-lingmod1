
public class D {
    static int x = 0;
    S5 a = null;
    
    class S5 {
	int k;
	
	S5() {
	    k = x;
	}
	
	public void finalize() {
	    System.out.print(k);
	}
    }
	
    D(){
	x++;
	a = new S5();
    }

    void f() {
	S5 a = new S5();
    }

    public void finalize() {
	System.out.print("3");
    }

    public static void main(String[] args) {
	D a5 = new D();	a5.f();
	a5 = new D();	a5.f();

	System.gc();	System.runFinalization();

	System.out.print("-");
	a5 = null;
	System.gc();	System.runFinalization();
    }
}
