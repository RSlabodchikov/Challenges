package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.Arrays;
import java.util.List;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/first-occurrence-in-event-code-log/problem">Problem</a>
 */
public class FirstOccurrence {

    /*
     * Complete the 'findFirstOccurrence' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY nums
     *  2. INTEGER target
     */
    public static int findFirstOccurrence(List<Integer> nums, int target) {
        if (nums.isEmpty()) {
            return -1;
        }
        int i = 0;
        int j = nums.size() - 1;
        int occurrenceIndex = -1;
        while (i <= j) {
            int mid = (i + j + 1) / 2;
            if (nums.get(mid) == target) {
                occurrenceIndex = mid;
                break;
            } else if (nums.get(mid) > target) {
                j = (mid == j) ? mid - 1 : mid;
            } else {
                i = (mid == i) ? mid + 1 : mid;
            }
        }
        while (occurrenceIndex > 0 && nums.get(occurrenceIndex - 1) == target) {
            occurrenceIndex--;
        }
        return occurrenceIndex;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,2,3,4,5,6);
        System.out.println(findFirstOccurrence(nums, 2));
        System.out.println(findFirstOccurrence(nums, 5));
        System.out.println(findFirstOccurrence(nums, 10));
    }
}
