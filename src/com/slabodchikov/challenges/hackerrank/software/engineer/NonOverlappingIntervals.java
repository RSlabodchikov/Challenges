package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.Arrays;
import java.util.List;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/maximum-non-overlapping-intervals/problem">Problem</a>
 */
public class NonOverlappingIntervals {

    /*
     * Complete the 'maximizeNonOverlappingMeetings' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY meetings as parameter.
     */
    public static int maximizeNonOverlappingMeetings(List<List<Integer>> meetings) {
        if (meetings.size() <= 1) {
            return meetings.size();
        }

        meetings.sort((i1, i2) -> {
            int r1 = Integer.compare(i1.get(1), i2.get(1));
            if (r1 == 0) {
                return Integer.compare(i1.get(0), i2.get(0));
            } else return r1;
        });

        int maxMeetings = 0;
        int currentEndTime = 0;
        for (List<Integer> meeting : meetings) {
            if (meeting.get(0) >= currentEndTime) {
                maxMeetings++;
                currentEndTime = meeting.get(1);
            }
        }

        return maxMeetings;
    }

    public static void main(String[] args) {
        List<List<Integer>> intervals = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(2, 3),
            Arrays.asList(3, 4),
            Arrays.asList(1, 3)
        );
        System.out.println(maximizeNonOverlappingMeetings(intervals));
    }
}
