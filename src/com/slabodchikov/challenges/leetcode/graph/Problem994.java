package com.slabodchikov.challenges.leetcode.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/rotting-oranges/">Problem 994</a>
 */
public class Problem994 {

    public int orangesRotting(int[][] grid) {

        int elapsedTime = 0;

        int freshOrangeCount = 0;
        LinkedList<int[]> rottenOranges = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshOrangeCount++;
                } else if (grid[i][j] == 2) {
                    rottenOranges.add(new int[]{i, j});
                    grid[i][j] = 0;
                }
            }
        }
        if (freshOrangeCount == 0) {
            return 0;
        }
        while (!rottenOranges.isEmpty()) {
            int rottenOrangesCount = rottenOranges.size();
            elapsedTime++;
            while (rottenOrangesCount > 0) {
                int[] currentOrange = rottenOranges.removeLast();

                // up
                if (currentOrange[0] > 0 && grid[currentOrange[0] - 1][currentOrange[1]] == 1) {
                    if (--freshOrangeCount == 0) {
                        return elapsedTime;
                    }
                    grid[currentOrange[0] - 1][currentOrange[1]] = 0;
                    rottenOranges.addFirst(new int[]{currentOrange[0] - 1, currentOrange[1]});
                }

                // down
                if (currentOrange[0] < m - 1 && grid[currentOrange[0] + 1][currentOrange[1]] == 1) {
                    if (--freshOrangeCount == 0) {
                        return elapsedTime;
                    }
                    grid[currentOrange[0] + 1][currentOrange[1]] = 0;
                    rottenOranges.addFirst(new int[]{currentOrange[0] + 1, currentOrange[1]});
                }

                // left
                if (currentOrange[1] > 0 && grid[currentOrange[0]][currentOrange[1] - 1] == 1) {
                    if (--freshOrangeCount == 0) {
                        return elapsedTime;
                    }
                    grid[currentOrange[0]][currentOrange[1] - 1] = 0;
                    rottenOranges.addFirst(new int[]{currentOrange[0], currentOrange[1] - 1});
                }

                // right
                if (currentOrange[1] < n - 1 && grid[currentOrange[0]][currentOrange[1] + 1] == 1) {
                    if (--freshOrangeCount == 0) {
                        return elapsedTime;
                    }
                    grid[currentOrange[0]][currentOrange[1] + 1] = 0;
                    rottenOranges.addFirst(new int[]{currentOrange[0], currentOrange[1] + 1});
                }

                rottenOrangesCount--;
            }
        }

        return -1;
    }
}
