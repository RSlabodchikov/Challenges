package com.slabodchikov.challenges.leetcode.heap;

import java.util.TreeSet;

public class Problem2336 {

    public static void main(String[] args) {

        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
        smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
        smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
        smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
        smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
        smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and
        // is the smallest number, and remove it from the set.
        smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
        smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.
    }

    static class SmallestInfiniteSet {

        private int popIndex = 0;
        private final TreeSet<Integer> addedNumbers = new TreeSet<>();

        public SmallestInfiniteSet() {

        }

        public int popSmallest() {

            if (!addedNumbers.isEmpty()) {
                return addedNumbers.pollFirst();
            }
            return ++popIndex;
        }

        public void addBack(int num) {

            if (num <= popIndex) {
                addedNumbers.add(num);
            }
        }
    }
}
