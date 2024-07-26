package com.slabodchikov.challenges.leetcode.tree;


import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree">Problem 236</a>
 */
public class Problem236 {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = TreeNode.fromArray(arr);
        TreeNode p = findNode(root, 5);
        TreeNode q = findNode(root, 4);
        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> ancestorsP = new LinkedList<>();
        LinkedList<TreeNode> ancestorsQ = new LinkedList<>();
        collectAncestors(root, p.val, ancestorsP);
        collectAncestors(root, q.val, ancestorsQ);

        Iterator<TreeNode> itP = ancestorsP.iterator();
        Iterator<TreeNode> itQ = ancestorsQ.iterator();
        TreeNode commonAncestor = root;
        while (itP.hasNext() && itQ.hasNext()) {
            TreeNode next = itP.next();
            if (next == itQ.next()) {
                commonAncestor = next;
            } else {
                break;
            }
        }
        return commonAncestor;
    }

    private static TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode left = findNode(root.left, val);
        if (left != null) return left;
        return findNode(root.right, val);
    }

    private static boolean collectAncestors(TreeNode root, Integer val, LinkedList<TreeNode> path) {
        if (root == null) {
            return false;
        }
        if (root.val == val) {
            path.addFirst(root);
            return true;
        }
        boolean result = collectAncestors(root.left, val, path);
        if (result) {
            path.addFirst(root);
            return true;
        } else {
            result = collectAncestors(root.right, val, path);
            if (result) {
                path.addFirst(root);
            }
            return result;
        }
    }
}
