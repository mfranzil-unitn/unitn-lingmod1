package it.franzil;

import org.apache.commons.text.RandomStringGenerator;

import java.math.BigInteger;
import java.util.Random;

import static java.lang.Math.abs;

/**
 * @author matte
 */
public class Common {

    /**
     * Genera una stringa casuale con la prima lettera maiuscola.
     *
     * @return una Stringa composta da un numero casuale di lettere con la prima in maiuscolo.
     */
    public static String randomName() {
        RandomStringGenerator gen = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
        return gen.generate(1).toUpperCase() + gen.generate(abs(new Random().nextInt() % 8));
    }

    /**
     * Genera una stringa casuale con la prima lettera maiuscola.
     *
     * @param size Grandezza della Stringa da generare.
     * @return una Stringa composta da SIZE lettere con la prima in maiuscolo.
     */
    public static String randomName(int size) {
        RandomStringGenerator gen = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
        return gen.generate(1).toUpperCase() + gen.generate(abs(new Random().nextInt() % --size));
    }

    /**
     * Semplice funzione che termina un programma con una Stringa come parametro.
     *
     * @param reason Parametro da passare che verrà stampato su console.
     */
    public static void endProgram(String reason) {
        System.out.println("----------------\n" + "Programma terminato: " + reason);
        System.exit(0);
    }

    public static int randomInt(int param) {
        Random random = new Random();
        return abs(random.nextInt() % param) + 1;
    }

    public static BigInteger bigIntegerSqrt(BigInteger x) {
        BigInteger div, div2;
        div = div2 = BigInteger.ZERO.setBit(x.bitLength() / 2);
        while (true) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2))
                return y;
            div2 = div;
            div = y;
        }
    }
}