package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.Arrays;
import java.util.List;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/search-timestamp-in-rotated-log-timestamps/problem">Problem</a>
 */
public class PivotedSearch {

    /*
     * Complete the 'searchRotatedTimestamps' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY nums
     *  2. INTEGER target
     */

    public static int searchRotatedTimestamps(List<Integer> nums, int target) {
        int start = 0;
        int end = nums.size() - 1;
        int mid;
        while (start <= end) {
            mid = (start + end + 1) / 2;
            if (nums.get(mid) == target) {
                return mid;
            }
            if (nums.get(start) < nums.get(mid)) {
                if (target >= nums.get(start) && target <= nums.get(mid)) {
                    end = (end == mid) ? mid - 1 : mid;
                } else {
                    start = (start == mid) ? mid + 1 : mid;
                }
            } else {
                if (target >= nums.get(mid) && target <= nums.get(end)) {
                    start = (start == mid) ? mid + 1 : mid;
                } else {
                    end = (end == mid) ? mid - 1 : mid;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(
            664, 700, 736, 592, 628
        );
//        System.out.println(searchRotatedTimestamps(nums, 592));
        System.out.println(searchRotatedTimestamps(nums, 664));
    }
}
