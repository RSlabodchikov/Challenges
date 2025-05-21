package com.slabodchikov.challenges.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/symmetric-tree/">Problem 101</a>
 */
public class Problem101 {

    public boolean isSymmetric(TreeNode root) {

        LinkedList<TreeNode> leftTree = new LinkedList<>();
        LinkedList<TreeNode> rightTree = new LinkedList<>();
        leftTree.add(root.left);
        rightTree.add(root.right);
        while (!leftTree.isEmpty()) {

            TreeNode leftNode = leftTree.poll();
            TreeNode rightNode = rightTree.poll();
            if (!compareNodes(leftNode, rightNode)) {
                return false;
            }
            if (leftNode != null) {
                leftTree.add(leftNode.left);
                leftTree.add(leftNode.right);
                rightTree.add(rightNode.right);
                rightTree.add(rightNode.left);
            }
        }
        return rightTree.isEmpty();
    }

    public boolean isSymmetricRecursive(TreeNode root) {

        return compareRecursively(root.left, root.right);
    }

    public boolean compareRecursively(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null || t1.val != t2.val) {
            return false;
        }
        return compareRecursively(t1.left, t2.right) && compareRecursively(t1.right, t2.left);
    }

    public boolean isSymmetricV2(TreeNode root) {

        List<Integer> leftValues = toList(root.left);
        List<Integer> rightValues = toMirrorList(root.right);
        if (leftValues.size() != rightValues.size()) {
            return false;
        }
        for (int i = 0; i < leftValues.size(); i++) {
            if (!Objects.equals(leftValues.get(i), rightValues.get(i))) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> toList(TreeNode tree) {

        List<Integer> values = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(tree);
        while (!nodes.isEmpty()) {
            tree = nodes.poll();
            values.add(tree == null ? null : tree.val);
            if (tree != null) {
                nodes.add(tree.left);
                nodes.add(tree.right);
            }
        }
        return values;
    }

    private List<Integer> toMirrorList(TreeNode tree) {

        List<Integer> values = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(tree);
        while (!nodes.isEmpty()) {
            tree = nodes.poll();
            values.add(tree == null ? null : tree.val);
            if (tree != null) {
                nodes.add(tree.right);
                nodes.add(tree.left);
            }
        }
        return values;
    }

    private boolean compareNodes(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val;
    }
}
