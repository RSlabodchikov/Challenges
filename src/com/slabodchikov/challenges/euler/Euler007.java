package com.slabodchikov.challenges.euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov
 */
public class Euler007 {

    private static final List<Long> primeNumbers = new ArrayList<>();

    static {
        primeNumbers.add(2L);
        primeNumbers.add(3L);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        List<Integer> inputs = new ArrayList<>();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            inputs.add(n);
        }
        int maxN = inputs.stream()
            .max(Integer::compareTo).orElse(1);
        calculateFirstNPrimeNumbers(maxN);
        inputs.forEach(n -> System.out.println(primeNumbers.get(n - 1)));
    }

    private static void calculateFirstNPrimeNumbers(int n) {
        long prevPrimeNumber;
        for (int i = 2; i < n; i++) {
            prevPrimeNumber = primeNumbers.get(i - 1);
            for (long j = prevPrimeNumber + 2; ; j += 2) {
                if (isPrimeNumber(j)) {
                    primeNumbers.add(j);
                    break;
                }
            }
        }
    }

    private static boolean isPrimeNumber(long num) {
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (long i = 5; i * i <= num; i += 6) {
            if ((num % i) == 0 || (num % (i + 2)) == 0) {
                return false;
            }
        }
        return true;
    }
}
