package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.List;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/find-smallest-missing-positive-integer/problem">Problem</a>
 */
public class FindSmallerMissingNumber {

    /*
     * Complete the 'findSmallestMissingPositive' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY orderNumbers as parameter.
     */
    public static int findSmallestMissingPositive(List<Integer> orderNumbers) {
        int n = orderNumbers.size();
        if (n == 0) {
            return 1;
        }
        int[] values = new int[n];
        for (int num : orderNumbers) {
            if (num > 0 && num <= n) {
                values[num - 1] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (values[i] == 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        List<Integer> orderNumbers = List.of(5);
        System.out.println(findSmallestMissingPositive(orderNumbers));
    }
}
