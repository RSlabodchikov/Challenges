package com.slabodchikov.challenges.leetcode.dp;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/n-th-tribonacci-number">Problem 1137</a>
 */
public class Problem1137 {

    public static void main(String[] args) {

        Problem1137 problem1137 = new Problem1137();
        System.out.println(problem1137.tribonacci(4));
        System.out.println(problem1137.tribonacci(25));
    }

    public int tribonacci(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        int[] tribonacciSequence = new int[n + 1];
        tribonacciSequence[0] = 0;
        tribonacciSequence[1] = 1;
        tribonacciSequence[2] = 1;
        for (int i = 3; i <= n; i++) {
            tribonacciSequence[i] = tribonacciSequence[i - 1] + tribonacciSequence[i - 2] + tribonacciSequence[i - 3];
        }
        return tribonacciSequence[n];
    }
}
