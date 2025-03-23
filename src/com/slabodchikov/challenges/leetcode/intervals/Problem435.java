package com.slabodchikov.challenges.leetcode.intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/non-overlapping-intervals">Problem 435</a>
 */
public class Problem435 {

    public static void main(String[] args) {

        Problem435 problem435 = new Problem435();
        int[][] intervals = {
            {-52, 31},
            {-73, -26},
            {82, 97},
            {-65, -11},
            {-62, -49},
            {95, 99},
            {58, 95},
            {-31, 49},
            {66, 98},
            {-63, 2},
            {30, 47},
            {-40, -26}
        };
        System.out.println(problem435.eraseOverlapIntervals(intervals));
    }

    public int eraseOverlapIntervals(int[][] intervals) {

        Comparator<int[]> comparator = (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        };
        Arrays.sort(intervals, comparator);

        int erasedIntervals = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] < prevEnd) {
                prevEnd = intervals[i][1];
                erasedIntervals++;
            } else if (intervals[i][0] < prevEnd) {
                erasedIntervals++;
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return erasedIntervals;
    }
}
