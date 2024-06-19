package com.slabodchikov.challenges.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/most-profit-assigning-work/description">Problem 826</a>
 */
public class Problem826 {

    public static void main(String[] args) {

        int[] difficulty = {68, 35, 52, 47, 86};
        int[] profit = {67, 17, 1, 81, 3};
        int[] worker = {92, 10, 85, 84, 82};
        System.out.println(maxProfitAssignment(difficulty, profit, worker));
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        Arrays.sort(worker);
        List<Pair<Integer, Integer>> jobs = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            jobs.add(new Pair<>(difficulty[i], profit[i]));
        }
        jobs.sort(Comparator.comparingInt(o -> o.left));
        int maxProfit = 0;
        int currentJob = 0;
        boolean hasMoreJobs = true;

        int currentDifficulty = jobs.get(0).left;
        int currentProfit = 0;

        for (int workerCapacity : worker) {
            while (hasMoreJobs && workerCapacity >= currentDifficulty) {
                currentProfit = Math.max(jobs.get(currentJob).right, currentProfit);
                currentJob++;
                if (currentJob == jobs.size()) {
                    hasMoreJobs = false;
                } else {
                    currentDifficulty = jobs.get(currentJob).left;
                }
            }
            maxProfit += currentProfit;
        }

        return maxProfit;
    }

    public static class Pair<L, R> {

        private final L left;
        private final R right;

        public Pair(L left, R right) {

            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<L, R> pair = (Pair<L, R>) o;
            return left == pair.left && right == pair.right;
        }

        @Override
        public int hashCode() {

            return Objects.hash(left, right);
        }
    }
}
