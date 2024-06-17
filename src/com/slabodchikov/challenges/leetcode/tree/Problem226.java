package com.slabodchikov.challenges.leetcode.tree;

/**
 * @author Roman Slabodchikov on 5/22/2024
 * @see <a href="https://leetcode.com/problems/invert-binary-tree/description/">Problem 226</a>
 */
public class Problem226 {

    public static void main(String[] args) {

        int[] nums = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root = null;
        for (var i : nums) {
            if (root == null) {
                root = new TreeNode(i);
            } else {
                addRecursive(root, i);
            }
        }
        iterateTree(root);
        invertTree(root);
        System.out.println();
        iterateTree(root);
    }

    public static TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;

        return root;
    }

    private static void iterateTree(TreeNode root) {

        System.out.print(root.val);
        iterateRecursive(root);
    }

    private static void iterateRecursive(TreeNode root) {

        if (root == null) {
            return;
        }
        if (root.left != null) {
            System.out.print(root.left.val);
        }
        if (root.right != null) {
            System.out.print(root.right.val);
        }
        iterateRecursive(root.left);
        iterateRecursive(root.right);
    }

    private static void addRecursive(TreeNode root, int newValue) {

        if (root.val < newValue) {
            if (root.right == null) {
                root.right = new TreeNode(newValue);
            } else {
                addRecursive(root.right, newValue);
            }
        } else if (root.val > newValue) {
            if (root.left == null) {
                root.left = new TreeNode(newValue);
            } else {
                addRecursive(root.left, newValue);
            }
        }
    }
}
