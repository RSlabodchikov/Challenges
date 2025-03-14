package com.slabodchikov.challenges.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/">Problem 1466</a>
 */
public class Problem1466 {

    public static void main(String[] args) {
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(new Problem1466().minReorder(6, connections));
    }

    public int minReorder(int n, int[][] connections) {

        AtomicInteger reorders = new AtomicInteger(0);

        Map<Integer, List<Pair<Integer, Boolean>>> graph = new HashMap<>(n);
        for (int[] connection : connections) {
            graph.computeIfAbsent(connection[0], v -> new ArrayList<>()).add(new Pair<>(connection[1], true));
            graph.computeIfAbsent(connection[1], v -> new ArrayList<>()).add(new Pair<>(connection[0], false));
        }
        dfs(0, -1, graph, reorders);

        return reorders.get();
    }

    public void dfs(int node, int parent, Map<Integer, List<Pair<Integer, Boolean>>> graph, AtomicInteger reorders) {

        for (Pair<Integer, Boolean> pair : graph.get(node)) {
            if (pair.getLeft() != parent) {
                if (pair.getRight()) {
                    reorders.getAndIncrement();
                }
                dfs(pair.getLeft(), node, graph, reorders);
            }
        }
    }

    public class Pair<L, R> {

        public final L left;
        public final R right;

        public Pair(L left, R right) {

            this.left = left;
            this.right = right;
        }

        public <L, R> Pair<L, R> of(L left, R right) {

            return new Pair<>(left, right);
        }

        public L getLeft() {

            return left;
        }

        public R getRight() {

            return right;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<L, R> pair = (Pair<L, R>) o;
            return left.equals(pair.left) && right.equals(pair.right);
        }

        @Override
        public int hashCode() {

            return Objects.hash(left, right);
        }
    }
}
