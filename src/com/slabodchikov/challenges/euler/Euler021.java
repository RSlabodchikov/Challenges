package com.slabodchikov.challenges.euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Roman Slabodchikov
 */
public class Euler021 {

    private static final Map<Integer, Long> amicableNumberSums = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        List<Integer> inputs = new ArrayList<>(t);

        for (int i = 0; i < t; i++) {
            inputs.add(scanner.nextInt());
        }

        inputs.stream().sorted(Integer::compareTo)
            .forEach(Euler021::calculateSumOfAmicableNumbers);

        for (int i : inputs) {
            System.out.println(amicableNumberSums.get(i));
        }
    }

    public static long getAmicableNumbersEulerMethod(int maxNumber) {
        long sum = 0;
        long p, q, r;
        long candidate;
        long nFactor;
        long mFactor;

        for (int n = 2; ; n++) {
            for (int m = 1; m < n; m++) {
                nFactor = (long) Math.pow(2, n);
                mFactor = (long) Math.pow(2, m);
                p = (nFactor / mFactor + 1) * mFactor - 1;
                q = (nFactor / mFactor + 1) * nFactor - 1;
                r = (nFactor / mFactor + 1) * (nFactor / mFactor + 1) * nFactor * mFactor - 1;
                if (isPrimeNumber(p) && isPrimeNumber(q) && isPrimeNumber(r)) {
                    candidate = (long) Math.pow(2, n) * p * q;
                    if (candidate < maxNumber) {
                        sum += candidate;
                    } else {
                        return sum;
                    }
                    candidate = (long) Math.pow(2, n) * r;
                    if (candidate < maxNumber) {
                        sum += candidate;
                    } else {
                        return sum;
                    }
                }
            }
        }
    }

    public static void calculateSumOfAmicableNumbers(int n) {
        Set<Integer> amicableNumbers = new HashSet<>();
        int previousMaxN = amicableNumberSums.keySet().stream()
            .max(Integer::compareTo).orElse(220);
        long sum = amicableNumberSums.isEmpty() ? 0 : amicableNumberSums.get(previousMaxN);

        for (int i = previousMaxN; i < n; i += 1) {
            if (!amicableNumbers.contains(i)) {
                int divisorsSum = getSumOfDivisors(i);
                if (divisorsSum != i && getSumOfDivisors(divisorsSum) == i) {
                    amicableNumbers.add(i);
                    amicableNumbers.add(divisorsSum);
                    if (divisorsSum < n && divisorsSum >= previousMaxN) {
                        sum += divisorsSum;
                    }
                    sum += i;
                }
            }
        }

        amicableNumberSums.put(n, sum);
    }

    public static Integer getSumOfDivisors(int num) {
        int sum = 1;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i == (num / i))
                    sum += i;
                else
                    sum += (i + num / i);
            }
        }

        return sum;
    }

    private static boolean isPrimeNumber(long num) {
        if (num <= 5) {
            return num == 3 || num == 2 || num == 5;
        }
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
