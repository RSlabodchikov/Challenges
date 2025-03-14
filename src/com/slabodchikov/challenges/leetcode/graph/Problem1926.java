package com.slabodchikov.challenges.leetcode.graph;

import java.util.Objects;
import java.util.Stack;
import java.util.LinkedList;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/">Problem 1926</a>
 */
public class Problem1926 {

    public static void main(String[] args) {

        char[][] maze = {
            {'+', '+', '+', '+'},
            {'+', '.', '.', '+'},
            {'+', '+', '+', '+'}
        };
        int[] entrance = new int[]{1, 1};
        Problem1926 problem = new Problem1926();
        System.out.println(problem.nearestExit(maze, entrance));
    }

    public int nearestExit(char[][] maze, int[] entrance) {

        int m = maze.length;
        int n = maze[0].length;

        LinkedList<int[]> nextMoves = new LinkedList<>();
        nextMoves.add(entrance);
        int currentMoves = 0;
        boolean[][] visited = new boolean[m][n];
        visited[entrance[0]][entrance[1]] = true;
        while (!nextMoves.isEmpty()) {
            currentMoves++;
            int nextMovesCount = nextMoves.size();
            while (nextMovesCount > 0) {
                int[] currentPosition = nextMoves.removeLast();


                // move up
                if (currentPosition[0] > 0
                    && !visited[currentPosition[0] - 1][currentPosition[1]]
                    && maze[currentPosition[0] - 1][currentPosition[1]] == '.') {
                    if ((currentPosition[0] - 1) == 0 || currentPosition[1] == 0 || currentPosition[1] == n - 1) {
                        return currentMoves;
                    }
                    nextMoves.addFirst(new int[]{currentPosition[0] - 1, currentPosition[1]});
                    visited[currentPosition[0]  - 1][currentPosition[1]] = true;
                }

                // move down
                if (currentPosition[0] < m - 1
                    && !visited[currentPosition[0] + 1][currentPosition[1]]
                    && maze[currentPosition[0] + 1][currentPosition[1]] == '.') {
                    if ((currentPosition[0] + 1) == m - 1 || currentPosition[1] == 0 || currentPosition[1] == n - 1) {
                        return currentMoves;
                    }
                    nextMoves.addFirst(new int[]{currentPosition[0] + 1, currentPosition[1]});
                    visited[currentPosition[0] + 1][currentPosition[1]] = true;
                }

                // move left
                if (currentPosition[1] > 0
                    && !visited[currentPosition[0]][currentPosition[1] - 1]
                    && maze[currentPosition[0]][currentPosition[1] - 1] == '.') {
                    if ((currentPosition[1] - 1) == 0 || currentPosition[0] == 0 || currentPosition[0] == m - 1) {
                        return currentMoves;
                    }
                    nextMoves.addFirst(new int[]{currentPosition[0], currentPosition[1] - 1});
                    visited[currentPosition[0]][currentPosition[1] - 1] = true;
                }

                // move right
                if (currentPosition[1] < n - 1
                    && !visited[currentPosition[0]][currentPosition[1] + 1]
                    && maze[currentPosition[0]][currentPosition[1] + 1] == '.') {
                    if ((currentPosition[1] + 1) == n - 1 || currentPosition[0] == 0 || currentPosition[0] == m - 1) {
                        return currentMoves;
                    }
                    nextMoves.addFirst(new int[]{currentPosition[0], currentPosition[1] + 1});
                    visited[currentPosition[0]][currentPosition[1] + 1] = true;
                }

                nextMovesCount--;
            }
        }

        return -1;
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
