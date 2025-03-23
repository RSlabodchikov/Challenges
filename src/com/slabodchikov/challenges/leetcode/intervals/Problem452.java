package com.slabodchikov.challenges.leetcode.intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/">Problem 452</a>
 */
public class Problem452 {

    public static void main(String[] args) {

        Problem452 problem452 = new Problem452();
        int[][] points = {
            {9, 12},
            {1, 10},
            {4, 11},
            {8, 12},
            {3, 9},
            {6, 9},
            {6, 7}
        };
        System.out.println(problem452.findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {

        Comparator<int[]> comparator = (Comparator.comparingInt(a -> a[1]));
        Arrays.sort(points, comparator);
        int arrows = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                end = points[i][1];
                arrows++;
            }
        }

        return arrows;
    }
}
