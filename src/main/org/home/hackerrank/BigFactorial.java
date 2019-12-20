package org.home.hackerrank;

import java.math.BigInteger;

public class BigFactorial {
    public static void extraLongFactorials(int n) {
        BigInteger fact = BigInteger.valueOf(1);
        while (n > 0) {
            fact = fact.multiply(BigInteger.valueOf(n));
            n--;
        }

        System.out.println(fact.toString());
    }

    public static void main(String[] args) {
        BigFactorial.extraLongFactorials(5);
        BigFactorial.extraLongFactorials(25);
    }
}
