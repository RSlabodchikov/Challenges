package com.slabodchikov.challenges.leetcode.binary.search;

import javax.swing.*;
import java.util.Arrays;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/successful-pairs-of-spells-and-potions">Problem 2300</a>
 */
public class Problem2300 {

    public static void main(String[] args) {

        Problem2300 solver = new Problem2300();
        int[] spells = {5, 1, 3};
        int[] potions = {1, 2, 3, 4, 5};
        int success = 7;
        System.out.println(Arrays.toString(solver.successfulPairs(spells, potions, success)));
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];

        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            int potionIndex = findPotionIndex(potions, success, spells[i], 0, m - 1);
            if (potionIndex == -1) {
                pairs[i] = 0;
            } else {
                pairs[i] = m - potionIndex;
            }
        }

        return pairs;
    }

    public int findPotionIndex(int[] potions, long success, int spellPower, int start, int end) {

        int mid;
        long power;
        int bestResult = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            power = ((long) potions[mid]) * spellPower;
            if (power < success) {
                start = mid + 1;
            } else {
                bestResult = mid;
                end = mid - 1;
            }
        }
        return bestResult;
    }
}
