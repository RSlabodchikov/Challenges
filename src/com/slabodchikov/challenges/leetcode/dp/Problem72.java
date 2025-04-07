package com.slabodchikov.challenges.leetcode.dp;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/edit-distance">Problem 72</a>
 */
public class Problem72 {

    public static void main(String[] args) {

        Problem72 problem72 = new Problem72();
        System.out.println(problem72.minDistance("anc", "atc"));
    }

    public int minDistance(String word1, String word2) {

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] matrix = new int[chars1.length + 1][chars2.length + 1];
        for (int i = 0; i <= chars1.length; i++) {
            for (int j = 0; j <= chars2.length; j++) {
                if (i == 0) {
                    matrix[i][j] = j;
                } else if (j == 0) {
                    matrix[i][j] = i;
                } else {
                    if (chars1[i-1] == chars2[j-1]) {
                        matrix[i][j] = matrix[i - 1][j - 1];
                    } else {
                        matrix[i][j] = Math.min(matrix[i][j - 1] + 1, matrix[i - 1][j] + 1);
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i - 1][j - 1] + 1);
                    }
                }
            }
        }
        return matrix[chars1.length][chars2.length];
    }
}
