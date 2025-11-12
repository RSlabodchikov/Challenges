package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.*;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/next-greater-element-with-offset/problem">Problem</a>
 */
public class NextGreaterElementWIthOffset {

    /*
     * Complete the 'findNextGreaterElementsWithDistance' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY readings as parameter.
     */
    public static List<List<Integer>> findNextGreaterElementsWithDistance(List<Integer> readings) {
        int n = readings.size();
        int[][] resultList = new int[n][2];
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        for (int i = 0; i < n; i++) {
            int currentElement = readings.get(i);
            while (!queue.isEmpty() && queue.peek()[1] < currentElement) {
                int[] element = queue.poll();
                resultList[element[0]] = new int[]{currentElement, i - element[0]};
            }
            queue.add(new int[]{i, currentElement});
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int[] ints : resultList) {
            if (ints[1] == 0) {
                result.add(Arrays.asList(-1, -1));
            } else {
                result.add(Arrays.asList(ints[0], ints[1]));
            }

        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> readings = Arrays.asList(2, 1, 2, 4, 3);
        System.out.println(findNextGreaterElementsWithDistance(readings));
    }
}
