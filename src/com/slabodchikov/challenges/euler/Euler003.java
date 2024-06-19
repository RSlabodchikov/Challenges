package com.slabodchikov.challenges.euler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov
 */
public class Euler003 {

    private static final Map<Long, Long> resultsCache = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long[] factors = new long[t];
        for (int i = 0; i < t; i++) {
            long n = in.nextLong();
            if (resultsCache.containsKey(n)) {
                factors[i] = resultsCache.get(n);
            } else {
                long factor = getLargestPrimeFactor(n);
                resultsCache.put(n, factor);
                factors[i] = factor;
            }
        }
        for (long factor : factors) {
            System.out.println(factor);
        }
    }

    public static long getLargestPrimeFactor(long n) {
        long largestFactor = -1;

        while (n % 2 == 0) {
            n >>= 1;
            largestFactor = 2;
        }
        while (n % 3 == 0) {
            largestFactor = 3;
            n /= 3;
        }
        for (int i = 5; i <= Math.sqrt(n); i += 6) {
            while (n % i == 0) {
                largestFactor = i;
                n = n / i;
            }
            while (n % (i + 2) == 0) {
                largestFactor = i + 2;
                n = n / (i + 2);
            }
        }
        if (n > 4)
            largestFactor = n;
        return largestFactor;
    }
}
