/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.franzil.rsa;

import it.franzil.Common;

import java.math.BigInteger;
import java.util.LinkedList;

/**
 * @author matte
 */
public class RSATests {
    public static void main(String[] args) {

        BigInteger a = new BigInteger("57317782457963091166846927271254786544355665408619010472279550975689167002325903127543350912148103033159856937938350592831549546288878859369594532141767629847152524325414337562236555229694941392067929053571717231956206430893734256748369048659286835276302160051776130919666984258847567032959931761686072492923");
        //BigInteger b = (a.divide(new BigInteger("6430819")));
        BigInteger res = factorize(a);
        System.out.println("PRIMO=======>" + res);
        //*/
        //new BigInteger("419").pow(0)
    }

    public static BigInteger factorize(BigInteger number) {
        if (isModZero(number, new BigInteger("2")))
            return new BigInteger("2");
        else if (isModZero(number, new BigInteger("3")))
            return new BigInteger("3");
        else if (isModZero(number, new BigInteger("5")))
            return new BigInteger("5");
        else {
            BigInteger i = new BigInteger("7");
            BigInteger m = Common.bigIntegerSqrt(number);
            while ((i).compareTo(m) < 0) {
                if (isModZero(number, i)) {
                    return i;
                } else {
                    i.add(BigInteger.ONE);
                    i.add(BigInteger.ONE);
                    System.out.println(i);
                }
            }
        }
        return null;
    }

    public static boolean isModZero(BigInteger number, BigInteger module) {
        return number.mod(module) == BigInteger.ZERO;
    }

    public static BigInteger largestPrimeFactor(BigInteger number) {
        BigInteger i;
        for (i = new BigInteger("1000000000000000000000000000"); i.compareTo(number) < 0; i = i.add(BigInteger.ONE)) {
            if (number.mod(i).equals(new BigInteger("0"))) {
                number = number.divide(i);
                i.subtract(BigInteger.ONE);
            }
        }
        return i;
    }

    public static LinkedList tdFactors(BigInteger n) {
        BigInteger two = BigInteger.valueOf(2);
        LinkedList fs = new LinkedList();

        if (n.compareTo(two) < 0) {
            throw new IllegalArgumentException("Must be greater than one");
        }

        while (n.mod(two).equals(BigInteger.ZERO)) {
            fs.add(two);
            n = n.divide(two);
        }

        if (n.compareTo(BigInteger.ONE) > 0) {
            BigInteger f = BigInteger.valueOf(3);
            while (f.multiply(f).compareTo(n) <= 0) {
                if (n.mod(f).equals(BigInteger.ZERO)) {
                    fs.add(f);
                    n = n.divide(f);
                } else {
                    f = f.add(two);
                }
            }
            fs.add(n);
        }

        return fs;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }


}
