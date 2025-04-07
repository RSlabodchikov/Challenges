package com.slabodchikov.challenges.leetcode.bits;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c">Problem 1318</a>
 */
public class Problem1318 {

    public static void main(String[] args) {

        Problem1318 problem1318 = new Problem1318();
        System.out.println(problem1318.minFlips(2, 6, 5));
        System.out.println(problem1318.minFlips(4, 2, 7));
        System.out.println(problem1318.minFlips(1, 2, 3));
    }

    public int minFlips(int a, int b, int c) {

        int flips = 0;

        int aBit, bBit, cBit;
        while (a != 0 || b != 0 || c != 0) {
            aBit = a & 1;
            a = a >> 1;
            bBit = b & 1;
            b = b >> 1;
            cBit = c & 1;
            c = c >> 1;
            if (cBit == 1) {
                if (aBit == 0 && bBit == 0) {
                    flips++;
                }
            } else {
                if (aBit == 1) {
                    flips++;
                }
                if (bBit == 1) {
                    flips++;
                }
            }
        }

        return flips;
    }
}
