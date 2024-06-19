package com.slabodchikov.challenges.euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov
 */
public class Euler005 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Long> lcms = new ArrayList<>();
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            lcms.add(calculateLcm(n));
        }

        lcms.forEach(System.out::println);
    }

    public static long calculateLcm(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = lcm(result, BigInteger.valueOf(i));
        }

        return result.longValue();
    }

    public static BigInteger lcm(BigInteger number1, BigInteger number2) {
        BigInteger gcd = number1.gcd(number2);
        BigInteger absProduct = number1.multiply(number2).abs();
        return absProduct.divide(gcd);
    }
}
