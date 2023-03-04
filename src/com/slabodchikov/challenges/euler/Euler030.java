package com.slabodchikov.challenges.euler;

import java.util.Scanner;

/**
 * @author Roman Slabodchikov on 24.11.2022
 */
public class Euler030 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getSumOfNumbersWrittenAsDigitsPower(n));
    }

    private static long getSumOfNumbersWrittenAsDigitsPower(int n) {
        long sum = 0L;
        for (int i = (int) Math.pow(10, n - 2); i < 548835; i++) {
            if (i == getSumOfPoweredDigits(i, n)) {
                sum += i;
            }
        }

        return sum;
    }

    private static long getSumOfPoweredDigits(int n, int pow) {
        long sum = 0;

        while (n > 0) {
            sum += Math.pow(n % 10, pow);
            n = n / 10;
        }

        return sum;
    }
}


