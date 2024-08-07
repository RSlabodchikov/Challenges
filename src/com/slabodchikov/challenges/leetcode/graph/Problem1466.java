package com.slabodchikov.challenges.leetcode.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/?envType=study-plan-v2&envId=leetcode-75">Problem 1466</a>
 */
public class Problem1466 {

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>(n);
        for (int i = 0; i < n - 1; i++) {
            graph.compute(connections[i][0], (k, v) -> v == null ? new ArrayList<>() : v).add(connections[i][1]);
            graph.compute(connections[i][1], (k, v) -> v == null ? new ArrayList<>() : v).add(-1*connections[i][0]);
        }
        return 0;
    }
}
