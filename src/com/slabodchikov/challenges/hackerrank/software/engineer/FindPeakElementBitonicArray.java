package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.Arrays;
import java.util.List;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/find-peak-element-in-bitonic-array/problem">Problem</a>
 */
public class FindPeakElementBitonicArray {

    /*
     * Complete the 'findPeakIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY counts as parameter.
     */
    public static int findPeakIndex(List<Integer> counts) {
        int start = 0;
        int n = counts.size() - 1;
        int end = n;
        int mid = 0;
        while (start != end) {
            mid = (start + end + 1) / 2;
            if (counts.get(mid) > counts.get(mid + 1)) {
                end = (end == mid) ? mid - 1 : mid;
            } else {
                start = (start == mid) ? mid + 1 : mid;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(findPeakIndex(Arrays.asList(1, 3, 2, 0)));
    }
}
