package com.slabodchikov.challenges.leetcode.heap;

import java.util.PriorityQueue;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/maximum-subsequence-score/">Problem 2542</a>
 */
public class Problem2462 {

    public static void main(String[] args) {

        int[] costs = {69,10,63,24,1,71,55,46,4,61,78,21,85,52,83,77,42,21,73,2,80,99,98,89,55,94,63,50,43,62,14};
        int k = 21;
        int candidates = 31;
        Problem2462 solver = new Problem2462();
        System.out.println(solver.totalCost(costs, k, candidates));
    }

    public long totalCost(int[] costs, int k, int candidates) {

        int m = 0;
        int n = costs.length - 1;
        PriorityQueue<int[]> firstQueue = new PriorityQueue<>(candidates, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> secondQueue = new PriorityQueue<>(candidates, (a, b) -> a[1] - b[1]);
        for (; m < candidates; m++) {

            firstQueue.add(new int[]{m, costs[m]});
        }
        m = firstQueue.size() - 1;
        for (; n >= (costs.length - candidates) && (n > m); n--) {

            secondQueue.add(new int[]{n, costs[n]});
        }
        n = costs.length - secondQueue.size();
        long totalCost = 0;
        for (int i = 0; i < k; i++) {

            if (!firstQueue.isEmpty() && (secondQueue.isEmpty() || (firstQueue.peek()[1] <= secondQueue.peek()[1]))) {
                //System.out.println(firstQueue.peek()[1]);
                totalCost += firstQueue.poll()[1];
                if (m + 1 < n) {
                    m++;
                    //System.out.println(costs[m]);
                    firstQueue.add(new int[]{m, costs[m]});
                }
            } else {
                //System.out.println(secondQueue.peek()[1]);
                totalCost += secondQueue.poll()[1];
                if (n > m + 1) {
                    n--;
                    //System.out.println(costs[n]);
                    secondQueue.add(new int[]{n, costs[n]});
                }
            }
        }

        return totalCost;
    }
}
