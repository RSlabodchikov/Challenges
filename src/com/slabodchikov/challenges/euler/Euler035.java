package com.slabodchikov.challenges.euler;

import java.util.Scanner;

/**
 * @author Roman Slabodchikov
 */
public class Euler035 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 2;
        for (int i = 3; i < n; i += 2) {
            if (isCircularPrime(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static boolean isCircularPrime(int n) {
        int digitsCount = (int) Math.log10(n) + 1;
        int[] digits = new int[digitsCount];
        int k = 0;
        while (n > 0) {
            digits[k] = n % 10;
            n = n / 10;
            k++;
        }
        int num;
        int pow;
        for (int i = 0; i < digitsCount; i++) {
            num = 0;
            for (int j = 0; j < digitsCount; j++) {
                pow = j - i >= 0 ? j - i : j - i + digitsCount;
                num += Math.pow(10, pow) * digits[j];
            }
            if (!isPrimeNumber(num)) {
                return false;
            }
        }
        return true;
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
