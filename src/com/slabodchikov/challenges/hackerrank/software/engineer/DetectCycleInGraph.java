package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.*;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/detect-cycle-in-module-dependency-graph/problem">Problem</a>
 */
public class DetectCycleInGraph {

    /*
     * Complete the 'hasCircularDependency' function below.
     *
     * The function is expected to return a BOOLEAN.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY dependencies
     */

    public static boolean hasCircularDependency(int n, List<List<Integer>> dependencies) {
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        boolean[] visited = new boolean[n];
        dependencies.forEach(dependency ->
            adjacencyMap.computeIfAbsent(dependency.get(0), k -> new ArrayList<>())
                .add(dependency.get(1)));

        for (int i = 0; i < n; i++) {
            if (visited[i] || !adjacencyMap.containsKey(i)) {
                continue;
            }
            ArrayDeque<Integer> vertices = new ArrayDeque<>();
            Set<Integer> links = new HashSet<>();
            vertices.add(i);
            while (!vertices.isEmpty()) {
                int vertex = vertices.removeFirst();
                links.add(vertex);

                List<Integer> nodes = adjacencyMap.get(vertex);
                if (nodes == null) {
                    continue;
                }

                for (int node : nodes) {
                    if (links.contains(node)) {
                        return true;
                    }
                    if (!visited[node]) {
                        vertices.addLast(node);
                        visited[node] = true;
                    }
                }
            }
        }

        return false;

    }

    public static void main(String[] args) {
        List<List<Integer>> links = Arrays.asList(
            Arrays.asList(1, 0),
            Arrays.asList(0, 1),
            Arrays.asList(3, 2)
        );
        int n = 4;
        System.out.println(hasCircularDependency(n, links));
    }
}
