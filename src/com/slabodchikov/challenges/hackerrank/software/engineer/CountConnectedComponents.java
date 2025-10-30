package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.*;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/count-connected-components-in-network/problem">Problem</a>
 */
public class CountConnectedComponents {

    /*
     * Complete the 'countIsolatedCommunicationGroups' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY links
     *  2. INTEGER n
     */

    public static int countIsolatedCommunicationGroups(List<List<Integer>> links, int n) {

        if (n == 1) {
            return 1;
        }
        Map<Integer, Deque<Integer>> adjacencyList = convertToAdjacencyList(links);
        boolean[] visited = new boolean[n];
        int currentGroupNumber = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            Deque<Integer> linkedNodes = adjacencyList.get(i);
            while (linkedNodes != null && !linkedNodes.isEmpty()) {
                int node = linkedNodes.pop();
                if (!visited[node]) {
                    visited[node] = true;
                    if (adjacencyList.containsKey(node)) {
                        for (int subNode : adjacencyList.get(node)) {
                            if (!visited[subNode]) {
                                linkedNodes.add(subNode);
                            }
                        }
                    }
                }
            }
            currentGroupNumber++;
        }

        return currentGroupNumber;
    }

    public static Map<Integer, Deque<Integer>> convertToAdjacencyList(List<List<Integer>> links) {
        Map<Integer, Deque<Integer>> adjacencyList = new HashMap<>();
        for (List<Integer> link : links) {
            adjacencyList.compute(link.get(0), (key, value) -> {
                if (value == null) {
                    value = new ArrayDeque<>();
                }
                value.add(link.get(1));
                return value;
            });
            adjacencyList.compute(link.get(1), (key, value) -> {
                if (value == null) {
                    value = new ArrayDeque<>();
                }
                value.add(link.get(0));
                return value;
            });
        }
        return adjacencyList;
    }
}
