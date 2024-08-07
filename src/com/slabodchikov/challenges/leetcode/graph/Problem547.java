package com.slabodchikov.challenges.leetcode.graph;


/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/number-of-provinces">Problem 547</a>
 */
public class Problem547 {

    public static void main(String[] args) {
        int[][] nums = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        System.out.println(findCircleNum(nums));
    }

    public static int findCircleNum(int[][] isConnected) {
        boolean[] connections = new boolean[isConnected.length];
        int groupNumber = 0;
        int n = isConnected.length;
        for (int i = 0; i < n; i++) {
            if (!connections[i]) {
                groupNumber++;
                dfs(isConnected, i, connections);
            }
        }

        return groupNumber;
    }

    public static void dfs(int[][] isConnected, int i, boolean[] connections) {
        connections[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (!connections[j] && isConnected[i][j] == 1) {
                dfs(isConnected, j, connections);
            }
        }
    }
}
