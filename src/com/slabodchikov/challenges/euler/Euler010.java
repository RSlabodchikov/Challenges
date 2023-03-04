package com.slabodchikov.challenges.euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov on 04.11.2022
 */
public class Euler010 {

    private static final Map<Integer, Long> primeNumbersSum = new HashMap<>();

    static {
        primeNumbersSum.put(2, 2L);
        primeNumbersSum.put(3, 5L);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        List<Integer> inputs = new ArrayList<>();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            inputs.add(n);
        }

        inputs.stream()
            .sorted(Integer::compareTo)
            .forEach(Euler010::calculateSumPrimeNotGreaterN);
        inputs.forEach(n -> System.out.println(primeNumbersSum.get(n)));
    }

    private static void calculateSumPrimeNotGreaterN(int n) {
        int prevMaxNumber = primeNumbersSum.keySet().stream().max(Integer::compareTo).orElse(2);
        long prevSum = primeNumbersSum.get(prevMaxNumber);
        for (int i = ((prevMaxNumber + 1) >> 1 << 1) + 1; i <= n; i+=2) {
            if (isPrimeNumber(i)) {
                prevSum += i;
            }
        }
        primeNumbersSum.put(n, prevSum);
    }

    private static boolean isPrimeNumber(int num) {
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
