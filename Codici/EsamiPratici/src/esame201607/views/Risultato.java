package esame201607.views;

public class Risultato<K extends Integer, T extends Integer> {
    private Integer r1, r2;
    Risultato(K r1, T r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    public boolean isPareggio() {
        boolean res;
        if (r1.equals(r2)) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

    public boolean isVittoria() {
        boolean res;
        if (r1.compareTo(r2) > 0) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

    public boolean isSconfitta() {
        boolean res;
        if (r1.compareTo(r2) < 0) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

    @Override
    public String toString() {
        return r1 + ":" + r2;
    }
}