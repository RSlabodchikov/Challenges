package com.slabodchikov.challenges.euler;

import java.util.Scanner;

/**
 * @author Roman Slabodchikov on 22.11.2022
 */
public class Euler042 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] terms = new long[n];

        for (int i = 0; i < n; i++) {
            terms[i] = getTriangleTerm(scanner.nextLong());
        }

        for (long term : terms) {
            System.out.println(term);
        }
    }

    public static long getTriangleTerm(long t) {

        long sqrt = (long) Math.sqrt(1 + 8 * t);
        if (sqrt * sqrt == (1 + 8 * t)) {
            return (-1 + sqrt) / 2;
        }

        return -1;
    }
}
