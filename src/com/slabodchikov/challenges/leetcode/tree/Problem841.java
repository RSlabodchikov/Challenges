package com.slabodchikov.challenges.leetcode.tree;

import java.util.*;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/keys-and-rooms/">Problem 841</a>
 */
public class Problem841 {

    public static void main(String[] args) {
        System.out.println(canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3), List.of())));
        System.out.println(canVisitAllRooms(List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0))));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> keys = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];
        keys.add(0);
        int earliest = 1;
        while (!keys.isEmpty() && earliest < rooms.size()) {
            int key = keys.poll();
            visited[key] = true;
            for (int newKey : rooms.get(key)) {
                if (!visited[newKey]) {
                    keys.offer(newKey);
                    visited[newKey] = true;
                    earliest++;
                }
            }
        }

        return earliest == rooms.size();
    }
}
