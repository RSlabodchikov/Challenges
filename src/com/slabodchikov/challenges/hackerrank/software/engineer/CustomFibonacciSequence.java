package com.slabodchikov.challenges.hackerrank.software.engineer;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/custom-fibonacci-sequence/problem">Problem</a>
 */
public class CustomFibonacciSequence {

    /*
     * Complete the 'getAutoSaveInterval' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER n as parameter.
     */
    public static long getAutoSaveInterval(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 2;
        }
        long[] elements = new long[2];
        elements[0] = 1;
        elements[1] = 2;
        for (int i = 2; i <= n; i++) {
            long newElement = elements[0] + elements[1];
            elements[0] = elements[1];
            elements[1] = newElement;
        }
        return elements[1];

    }

    public static void main(String[] args) {
        System.out.println(getAutoSaveInterval(0));
        System.out.println(getAutoSaveInterval(1));
        System.out.println(getAutoSaveInterval(2));
        System.out.println(getAutoSaveInterval(3));
        System.out.println(getAutoSaveInterval(4));
        System.out.println(getAutoSaveInterval(5));
    }
}
