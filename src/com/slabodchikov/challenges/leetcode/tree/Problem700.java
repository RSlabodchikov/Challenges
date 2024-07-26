package com.slabodchikov.challenges.leetcode.tree;


/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/search-in-a-binary-search-tree">Problem 700</a>
 */
public class Problem700 {

    public static void main(String[] args) {
        Integer[] vals = new Integer[]{4,2,7,1,3};
        System.out.println(searchBST(TreeNode.fromArray(vals), 5));
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        TreeNode left = searchBST(root.left, val);
        if (left != null) {
            return left;
        } else {
            return searchBST(root.right, val);
        }
    }
}
