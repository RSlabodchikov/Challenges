package com.slabodchikov.challenges.leetcode;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/sum-of-square-numbers/description/">Problem 633</a>
 */
public class Problem633 {

    public static void main(String[] args) {

        System.out.println(judgeSquareSum(1000));
    }

    public static boolean judgeSquareSum(int c) {

        if (c == 0 || c == 1 || c == 2) {
            return true;
        }
        if (c % 4 == 3) {
            return false;
        }

        int aMax = (int) Math.sqrt(c);
        int a = aMax;
        for (int powA = aMax * aMax; powA >= c / 2; powA = a * a) {
            if (isSquare(c - powA)) {
                return true;
            }
            a--;
        }
        return false;
    }

    private static boolean isSquare(int a) {

        int x = (int) Math.sqrt(a);
        return (Math.pow(x, 2) == a);
    }
}
