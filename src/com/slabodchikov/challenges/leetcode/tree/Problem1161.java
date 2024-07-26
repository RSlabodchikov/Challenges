package com.slabodchikov.challenges.leetcode.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree">Problem 1161</a>
 */
public class Problem1161 {

    public static void main(String[] args) {
        Integer[] vals = new Integer[]{989, null, 10250, 98693, -89388, null, null, null, -32127};
        System.out.println(maxLevelSumOptimized(TreeNode.fromArray(vals)));
    }

    public static int maxLevelSumOptimized(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int maxSum = Integer.MIN_VALUE;
        int level = 1;
        int minLevel = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            int currentSum = 0;
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                currentSum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                minLevel = level;
            }
            level++;
        }

        return minLevel;
    }
}
