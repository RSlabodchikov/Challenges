package com.slabodchikov.challenges.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/equal-row-and-column-pairs/description/">Problem 2352</a>
 */
public class Problem2352 {

    public static void main(String[] args) {
        int[][] grid = {{2, 1}, {3, 32}};
        System.out.println(equalPairs(grid));
    }

    public static int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> rowHashes = new HashMap<>();
        ArrayList<Integer> columnHashes = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int rowHash = 1;
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    columnHashes.add(100189 + grid[i][j]);
                } else {
                    columnHashes.set(j, 100189 * columnHashes.get(j) + grid[i][j]);
                }
                rowHash = 100189 * rowHash + grid[i][j];
            }
            rowHashes.compute(rowHash, (k, v) -> (v == null) ? 1 : (v + 1));
        }
        int pairs = 0;
        for (int columnHash : columnHashes) {
            pairs += rowHashes.getOrDefault(columnHash, 0);
        }
        return pairs;
    }
}
