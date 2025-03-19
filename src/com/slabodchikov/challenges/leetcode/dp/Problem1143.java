package com.slabodchikov.challenges.leetcode.dp;

public class Problem1143 {

    public static void main(String[] args) {
        Problem1143 problem = new Problem1143();
        System.out.println(problem.longestCommonSubsequence("abc", "abc"));
        System.out.println(problem.longestCommonSubsequence("abcde", "ace"));
        System.out.println(problem.longestCommonSubsequence("afe", "qwhj"));
    }

    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    matrix[i][j] = (chars1[i] == chars2[j] ? 1 : 0);
                } else if (i == 0) {
                    matrix[i][j] = (chars1[i] == chars2[j] ? 1 : matrix[i][j - 1]);
                } else if (j == 0) {
                    matrix[i][j] = (chars1[i] == chars2[j] ? 1 : matrix[i - 1][j]);
                } else {
                    if (chars1[i] == chars2[j]) {
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    } else {
                        matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
                    }
                }
            }
        }

        return matrix[n - 1][m - 1];
    }
}
