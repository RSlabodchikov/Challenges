package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.math.BigInteger;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/ways-to-fill-slots-single-double-coverage/problem">Problem</a>
 */
public class WaysToFillSlots {

    /*
     * Complete the 'countInstallationSequences' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER n as parameter.
     */
    public static String countInstallationSequences(int n) {
        if (n <= 0) {
            return "1";
        }
        BigInteger[] prevSequences = new BigInteger[2];
        prevSequences[0] = BigInteger.ONE;
        prevSequences[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            BigInteger newValue = prevSequences[0].add(prevSequences[1]);
            prevSequences[0] = prevSequences[1];
            prevSequences[1] = newValue;
        }

        return prevSequences[1].toString();

    }

    public static void main(String[] args) {
        System.out.println(countInstallationSequences(0));
        System.out.println(countInstallationSequences(1));
        System.out.println(countInstallationSequences(2));
        System.out.println(countInstallationSequences(3));
    }
}
