package it.franzil.euromix;

import java.util.Objects;

public class Targa {
    private String lettere_1;
    private int numeri;
    private String lettere_2;
    
    public Targa(String input) {
        try {            
            if (input.length() == 7 && Character.isLetter(input.charAt(0))
                    && Character.isLetter(input.charAt(1)) && Character.isLetter(input.charAt(5))
                    && Character.isLetter(input.charAt(6)) && Character.isDigit(input.charAt(2))
                    && Character.isDigit(input.charAt(3)) && Character.isDigit(input.charAt(4))) {
                lettere_1 = new StringBuilder().append(input.charAt(0)).append(input.charAt(1)).toString().toUpperCase();
                lettere_2 = new StringBuilder().append(input.charAt(5)).append(input.charAt(6)).toString().toUpperCase();
                numeri = Character.getNumericValue(input.charAt(2)) * 100 + 
                         Character.getNumericValue(input.charAt(3)) * 10 +
                         Character.getNumericValue(input.charAt(4));
            } else {
                throw new IllegalArgumentException("Targa non valida!");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
    
    public Targa(String lettere_1, int numeri, String lettere_2) {
        this.lettere_1 = lettere_1;
        this.numeri = numeri;
        this.lettere_2 = lettere_2;
    }

    @Override
    public String toString() {
        String res;
        if (numeri < 10)
            res = lettere_1 + "00" + numeri + lettere_2;
        else if (numeri > 10 && numeri < 100)
            res = lettere_1 + "0" + numeri + lettere_2;
        else
            res = lettere_1 + numeri + lettere_2;
        return res;
    }

    @Override
    public boolean equals(Object o) {
        boolean res;
        if (o == null)
            res = false;
        else if (!(o instanceof Targa))
            res = false;
        else 
            res = (lettere_1.equals(((Targa)o).lettere_1) && lettere_2.equals(((Targa)o).lettere_2) && numeri == ((Targa)o).numeri);
        return res;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.lettere_1);
        hash = 71 * hash + this.numeri;
        hash = 71 * hash + Objects.hashCode(this.lettere_2);
        return hash;
    }
 
    
}
