package com.slabodchikov.challenges.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/combination-sum-iii">Problem 216</a>
 */
public class Problem216 {

    public static void main(String[] args) {

        Problem216 problem216 = new Problem216();
        System.out.println(problem216.combinationSum3(9, 45));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {

        if (n > 45 || n < 1 || k > n) {
            return Collections.emptyList();
        }

        List<List<Integer>> combinations = new ArrayList<>();
        combinationSum(k, n, new ArrayList<>(), 0, 1, combinations);

        return combinations;
    }

    public void combinationSum(
        int k,
        int n,
        List<Integer> currentCombination,
        int currentSum,
        int currentNumber,
        List<List<Integer>> combinations
    ) {

        if (currentNumber > 9 || currentSum > n || currentCombination.size() > k) {
            return;
        }
        combinationSum(k, n, currentCombination, currentSum, currentNumber + 1, combinations);
        List<Integer> nextCombination = new ArrayList<>(currentCombination);
        nextCombination.add(currentNumber);
        if (currentSum + currentNumber == n && nextCombination.size() == k) {
            combinations.add(nextCombination);
            return;
        }
        combinationSum(k, n, nextCombination, currentSum + currentNumber, currentNumber + 1, combinations);
    }
}
