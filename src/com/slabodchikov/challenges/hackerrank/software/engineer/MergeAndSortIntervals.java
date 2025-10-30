package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/merge-and-sort-intervals/problem">Problem</a>
 */
public class MergeAndSortIntervals {

    /*
     * Complete the 'mergeHighDefinitionIntervals' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY intervals as parameter.
     */
    public static List<List<Integer>> mergeHighDefinitionIntervals(List<List<Integer>> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        intervals.sort((i1, i2) -> {
            int c1 = Integer.compare(i1.get(0), i2.get(0));
            if (c1 == 0) {
                return Integer.compare(i1.get(1), i2.get(1));
            } else {
                return c1;
            }
        });
        return mergeIntervals(intervals);
    }

    public static List<List<Integer>> mergeIntervals(List<List<Integer>> sortedIntervals) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentInterval = sortedIntervals.get(0);
        for (int i = 1; i < sortedIntervals.size(); i++) {
            List<Integer> newInterval = sortedIntervals.get(i);
            if (newInterval.get(0) <= currentInterval.get(1)) {
                currentInterval.set(1, Integer.max(currentInterval.get(1), newInterval.get(1)));
                if (i == (sortedIntervals.size() - 1)) {
                    result.add(currentInterval);
                }
            } else {
                result.add(currentInterval);
                currentInterval = newInterval;
                if (i == (sortedIntervals.size() - 1)) {
                    result.add(currentInterval);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> intervals = Arrays.asList(
            Arrays.asList(5, 10),
            Arrays.asList(0, 200)
        );

        System.out.println(mergeHighDefinitionIntervals(intervals));
    }
}
