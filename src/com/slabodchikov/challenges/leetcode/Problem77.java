package com.slabodchikov.challenges.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/combinations/description/">Problem 77</a>
 */
public class Problem77 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        List<List<Integer>> allCombinations = new ArrayList<>();
        getCombinations(n, k, allCombinations, new ArrayList<>(k), 1);
        for (List<Integer> c : allCombinations) {
            System.out.println(c.toString());
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> allCombinations = new ArrayList<>();
        getCombinations(n, k, allCombinations, new ArrayList<>(), 1);
        return allCombinations;
    }

    //    private static void getCombinations(int n, int k, List<List<Integer>> allCombinations, List<Integer> currentCombination,
//        int currentNumber) {
//        if (currentNumber > n || ((n - currentNumber + 1) < (k - currentCombination.size()))) {
//            return;
//        }
//        // combinations with currentNumber not included
//        getCombinations(n, k, allCombinations, currentCombination, currentNumber + 1);
//        // combinations with currentNUmber included
//        List<Integer> newCombination = new ArrayList<>(currentCombination);
//        newCombination.add(currentNumber);
//        if (newCombination.size() == k) {
//            allCombinations.add(newCombination);
//        } else {
//            getCombinations(n, k, allCombinations, newCombination, currentNumber + 1);
//        }
//    }

    private static void getCombinations(int n, int k, List<List<Integer>> allCombinations, List<Integer> currentCombination,
        int currentNumber) {
        if ((n - currentNumber + 1) < (k - currentCombination.size())) {
            return;
        }
        for (int i = currentNumber; i <= n; i++) {
            if ((n - i + 2) < (k - currentCombination.size() - 1)) {
                break;
            }
            currentCombination.add(i);
            if (currentCombination.size() == k) {
                allCombinations.add(new ArrayList<>(currentCombination));
            } else {
                getCombinations(n, k, allCombinations, currentCombination, i + 1);
            }
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
