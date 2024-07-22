package com.slabodchikov.challenges.leetcode.tree;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/path-sum-iii/">Problem 226</a>
 */
public class Problem437 {

    public static void main(String[] args) {
        Integer[] vals = new Integer[]{1000000000, 1000000000, null, 294967296, null, 1000000000, null, 1000000000, null, 1000000000};
        System.out.println(pathSum(TreeNode.fromArray(vals), 0));
    }

    public static int pathSum(TreeNode root, int targetSum) {
        AtomicInteger count = new AtomicInteger(0);

        countPathSum(root, targetSum, new LinkedList<>(), count);

        return count.get();
    }

    public static int countPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return (root.val == targetSum ? 0 : 1) +
                countPathSum(root.left, targetSum - root.val) +
                countPathSum(root.right, targetSum - root.val);
    }

    public static void countPathSum(TreeNode root, int targetSum, LinkedList<Integer> prevValues, AtomicInteger count) {
        if (root == null) {
            return;
        }
        if (root.val == targetSum) {
            count.incrementAndGet();
        }
        long currentSum = root.val;
        Iterator<Integer> iterator = prevValues.descendingIterator();
        while (iterator.hasNext()) {
            currentSum += iterator.next();
            if (currentSum == targetSum) {
                count.incrementAndGet();
            }
        }
        prevValues.addLast(root.val);
        countPathSum(root.left, targetSum, prevValues, count);
        countPathSum(root.right, targetSum, prevValues, count);
        prevValues.removeLast();
    }
}
