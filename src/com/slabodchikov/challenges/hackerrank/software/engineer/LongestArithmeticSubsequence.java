package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.Arrays;
import java.util.List;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/longest-arithmetic-subsequence-given-diff/problem">Problem</a>
 */
public class LongestArithmeticSubsequence {

    /*
     * Complete the 'findLongestArithmeticProgression' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER k
     */

    public static int findLongestArithmeticProgression(List<Integer> arr, int k) {
        arr = arr.stream()
            .distinct()
            .sorted()
            .toList();
        int longestProgression = 0;
        int n = arr.size();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n - longestProgression && (n - i > longestProgression); i++) {
            if (visited[i]) {
                continue;
            }
            int start = i + 1;
            int end = n - 1;
            int currentLength = 1;
            int current = arr.get(i);
            while (true) {
                int nextIndex = binarySearch(arr, start, end, current + k);
                if (nextIndex == -1) {
                    break;
                } else {
                    start = nextIndex;
                    current += k;
                    currentLength++;
                    visited[nextIndex] = true;
                }

            }
            if (currentLength > longestProgression) {
                longestProgression = currentLength;
            }
            if (currentLength >= n / 2) {
                return currentLength;
            }
        }

        return longestProgression;
    }

    public static int binarySearch(List<Integer> arr, int start, int end, int num) {
        while (start <= end) {
            int mid = (end + start + 1) / 2;
            int result = Integer.compare(num, arr.get(mid));
            if (result == 0) {
                return mid;
            } else if (result < 0) {
                end = mid == end ? mid - 1 : mid;
            } else {
                start = mid == end ? mid + 1 : mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(8, 1, -1, 0, 3, 6, 2, 4, 5, 7, 9);
        int k = 2;
        System.out.println(findLongestArithmeticProgression(arr, k));
    }
}
