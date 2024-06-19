package com.slabodchikov.challenges.euler;

import java.util.Scanner;

/**
 * @author Roman Slabodchikov
 */
public class Euler001 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long[] sums = new long[t];
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            sums[i] = calculateSum(n);
        }

        for (long sum : sums) {
            System.out.println(sum);
        }
    }

    public static long calculateSum(int n) {
        long sum = 0;

        if (n > 3) {
            sum += ((long) (3 + ((n - 1) / 3) * 3) * ((n - 1) / 3) / 2);
        }
        if (n > 5) {
            sum += ((long) (5 + ((n - 1) / 5) * 5) * ((n - 1) / 5) / 2);
        }
        if (n > 15) {
            sum -= ((long) (15 + ((n - 1) / 15) * 15) * ((n - 1) / 15) / 2);
        }

        return sum;
    }

}
