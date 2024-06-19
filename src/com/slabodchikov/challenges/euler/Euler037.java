package com.slabodchikov.challenges.euler;

import java.util.Scanner;

/**
 * @author Roman Slabodchikov
 */
public class Euler037 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(getSumOfTruncatablePrimes(n));
    }

    public static long getSumOfTruncatablePrimes(int n) {
        long sum = 0L;

        for (int i = 11; i <= n; i += 2) {
            if (isPrimeRightToLeft(i) && isPrimeLeftToRight(i)) {
                sum += i;
            }
        }

        return sum;
    }

    private static boolean isPrimeRightToLeft(long num) {
        while (num > 0) {
            if (!isPrimeNumber(num)) {
                return false;
            }
            num = num / 10;
        }
        return true;
    }

    private static boolean isPrimeLeftToRight(long num) {
        while (num > 0) {
            if (!isPrimeNumber(num)) {
                return false;
            }
            num = num % (int) Math.pow(10, (int) Math.log10(num));
        }
        return true;
    }

    private static boolean isPrimeNumber(long num) {
        if (num == 1) {
            return false;
        }
        if (num <= 5) {
            return num != 4;
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
