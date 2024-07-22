package com.slabodchikov.challenges.leetcode.tree;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree">Problem 1372</a>
 */
public class Problem1372 {

    public static void main(String[] args) {
        Integer[] vals = new Integer[]{1};
        System.out.println(longestZigZag(TreeNode.fromArray(vals)));
    }

    public static int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(
                longestZigZag(root.right, 1, 0),
                longestZigZag(root.left, -1, 0));
    }

    public static int longestZigZag(TreeNode root, int direction, int pathLength) {
        if (root == null) {
            return pathLength;
        }
        if (direction == 1) {
            return Math.max(
                    longestZigZag(root.left, -1, pathLength + 1),
                    longestZigZag(root.right, 1, 0)
            );
        } else {
            return Math.max(
                    longestZigZag(root.left, -1, 0),
                    longestZigZag(root.right, 1, pathLength + 1)
            );
        }
    }
}
