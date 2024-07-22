package com.slabodchikov.challenges.leetcode.tree;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/count-good-nodes-in-binary-tree/">Problem 1448</a>
 */
public class Problem1448 {

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{};
        TreeNode tree = TreeNode.fromArray(nums);
        System.out.println(goodNodes(tree));
    }

    public static int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        AtomicInteger count = new AtomicInteger(0);
        goodNodesRecursive(root, count, root.val);
        return count.get();
    }

    public static void goodNodesRecursive(TreeNode root, AtomicInteger count, int localMaxima) {
        if (root == null) {
            return;
        }
        if (localMaxima <= root.val) {
            count.incrementAndGet();
        }
        goodNodesRecursive(root.left, count, Math.max(localMaxima, root.val));
        goodNodesRecursive(root.right, count, Math.max(localMaxima, root.val));
    }
}
