package com.slabodchikov.challenges.leetcode.tree;


/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">Problem 104</a>
 */
public class Problem104 {

    public int maxDepth(TreeNode root) {
        return maxDepthRecursive(root, 1);
    }

    public int maxDepthRecursive(TreeNode root, int currentDepth) {

        if (root == null) {
            return currentDepth - 1;
        }
        return Math.max(
                maxDepthRecursive(root.left, currentDepth + 1),
                maxDepthRecursive(root.right, currentDepth + 1)
        );
    }
}
