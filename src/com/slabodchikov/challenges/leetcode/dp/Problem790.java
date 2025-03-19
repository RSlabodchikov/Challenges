package com.slabodchikov.challenges.leetcode.dp;

public class Problem790 {

    public static void main(String[] args) {

        Problem790 problem = new Problem790();
        System.out.println(problem.numTilings(4));
    }

    public int numTilings(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 5;
        }
        long[] tilings = new long[n];
        tilings[0] = 1;
        tilings[1] = 2;
        tilings[2] = 5;
        for (int i = 3; i < n; i++) {
            tilings[i] = 2 * tilings[i - 1] + tilings[i - 3];
            tilings[i] = Math.floorMod(tilings[i], 1000000007);
        }
        return (int) tilings[n - 1];
    }
}
