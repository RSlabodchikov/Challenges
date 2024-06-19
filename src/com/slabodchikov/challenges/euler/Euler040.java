package com.slabodchikov.challenges.euler;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov
 */
public class Euler040 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        int[] results = new int[t];

        for (int i = 0; i < t; i++) {
            results[i] = 1;
            for (int j = 0; j < 7; j++) {
                results[i] *= getNDigit(in.nextBigInteger());
            }
        }

        for (long result : results) {
            System.out.println(result);
        }
    }

    public static int getNDigit(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return 1;
        }
        BigInteger r = BigInteger.ZERO;
        BigInteger s = BigInteger.ZERO;
        int k = 0;
        while (s.compareTo(n) < 0) {
            r = s;
            s = s.add(BigInteger.valueOf(10).pow(k++).multiply(BigInteger.valueOf(k)).multiply(BigInteger.valueOf(9)));
        }
        BigInteger h = n.subtract(r).subtract(BigInteger.ONE);
        BigInteger term = h.divide(BigInteger.valueOf(k));
        BigInteger t =  BigInteger.valueOf(10).pow(k - 1).add(term);
        int p = h.mod(BigInteger.valueOf(k)).intValue();
        return String.valueOf(t).charAt(p) - '0';
    }
}
