package com.slabodchikov.challenges.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/evaluate-division/">Problem 399</a>
 */
public class Problem399 {

    public static void main(String[] args) {

        List<List<String>> equations = new ArrayList<>();
        equations.add(List.of("a", "b"));
        equations.add(List.of("b", "c"));
        equations.add(List.of("c", "a"));
        equations.add(List.of("d", "e"));

        double[] values = {2.0, 3.0, 6.0, 1.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(List.of("a", "c"));
        queries.add(List.of("b", "a"));
        queries.add(List.of("a", "e"));
        queries.add(List.of("a", "a"));
        queries.add(List.of("x", "x"));

        double[] result = new Problem399().calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(result));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, List<Pair<String, Double>>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double value = values[i];
            double reverseValue = 1 / value;
            graph.computeIfAbsent(equation.get(0), v -> new ArrayList<>()).add(new Pair<>(equation.get(1), value));
            graph.computeIfAbsent(equation.get(1), v -> new ArrayList<>()).add(new Pair<>(equation.get(0),
                reverseValue));
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), 1.0, graph);
        }
        return result;
    }

    public Double dfs(
        String start,
        String end,
        Set<String> parents,
        Double value,
        Map<String, List<Pair<String, Double>>> graph
    ) {

        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return -1.0;
        }
        if (start.equals(end)) {
            return 1.0;
        }

        for (Pair<String, Double> equation : graph.get(start)) {
            if (parents.contains(equation.left)) {
                continue;
            }
            if (equation.getLeft().equals(end)) {
                return value * equation.getRight();
            } else {
                parents.add(start);
                Double result = dfs(equation.getLeft(), end, parents, value * equation.getRight(), graph);
                if (result != -1.0) {
                    return result;
                }
                parents.remove(start);
            }
        }
        return -1.0;
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
