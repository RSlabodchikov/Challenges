package com.slabodchikov.challenges.leetcode.dp;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/unique-paths/">Problem 62</a>
 */
public class Problem62 {

    public static void main(String[] args) {
        Problem62 problem = new Problem62();
        System.out.println(problem.uniquePaths(3,2));
        System.out.println(problem.uniquePaths(3,7));
    }

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
