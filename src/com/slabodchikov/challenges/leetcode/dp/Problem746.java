package com.slabodchikov.challenges.leetcode.dp;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/min-cost-climbing-stairs/">Problem 746</a>
 */
public class Problem746 {

    public static void main(String[] args) {

        Problem746 problem746 = new Problem746();
        int[] costs = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(problem746.minCostClimbingStairs(costs));
    }

    public int minCostClimbingStairs(int[] cost) {

        int[] minCosts = new int[cost.length + 1];
        if (cost.length <= 1) {
            return 0;
        }
        minCosts[0] = 0;
        minCosts[1] = 0;

        minCosts[2] = Math.min(cost[0], cost[1]);

        for (int i = 3; i <= cost.length; i++) {
            minCosts[i] = Math.min(minCosts[i - 2] + cost[i - 2], minCosts[i - 1] + cost[i-1]);
        }

        return minCosts[cost.length];
    }
}
