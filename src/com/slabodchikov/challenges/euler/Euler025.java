package com.slabodchikov.challenges.euler;

import java.util.Scanner;

/**
 * @author Roman Slabodchikov on 24.11.2022
 */
public class Euler025 {
    private static final double phi = (1 + Math.sqrt(5)) / 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] inputs = new int[t];

        for (int i = 0; i < t; i++) {
            inputs[i] = scanner.nextInt();
        }

        for (int n : inputs) {
            System.out.println(calculateFibonacciIndexWithNDigits(n));
        }
    }

    public static int calculateFibonacciIndexWithNDigits(int n) {
        return (int) ((Math.log(10) * (n - 1) + Math.log(5) / 2) / Math.log(phi)) + 1;
    }
}
