package com.slabodchikov.challenges.euler;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Roman Slabodchikov on 22.11.2022
 */
public class Euler125 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long[] palindromeSum = new long[t];
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            palindromeSum[i] = getPalindromesSum(n, d);
        }

        for (long sum : palindromeSum) {
            System.out.println(sum);
        }
    }

    public static long getPalindromesSum(int n, int d) {
        Set<Long> palindromes = new HashSet<>();
        long sum = 0;
        long currentSum;

        for (long i = 1; i * i < n / 2; i++) {
            long j = i;
            currentSum = j * j;
            while (currentSum < n) {
                j += d;
                currentSum += j * j;
                if (currentSum < n && !palindromes.contains(currentSum) && isPalindrome(currentSum, 10)) {
                    palindromes.add(currentSum);
                    sum += currentSum;
                }
            }
        }

        return sum;
    }

    public static boolean isPalindrome(long number, int base) {
        String stringNumber = Long.toString(number, base);

        int length = stringNumber.length();

        for (int i = 0; i < length / 2; i++) {
            if (stringNumber.charAt(i) != stringNumber.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
