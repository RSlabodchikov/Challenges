package com.slabodchikov.challenges.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Roman Slabodchikov
 * @see
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal">Problem 105</a>
 */
public class Problem105 {

    public static void main(String[] args) {

        Problem105 problem105 = new Problem105();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = problem105.buildTree(preorder, inorder);
        System.out.println(treeNode.toArray());
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Deque<Integer> preorderQueue = new ArrayDeque<>(preorder.length);
        for (int i : preorder) {
            preorderQueue.addLast(i);
        }

        return build(preorderQueue, inorder);
    }

    private TreeNode build(Deque<Integer> values, int[] inorder) {

        if (!values.isEmpty() && inorder.length != 0) {
            int currentValue = values.poll();
            int indexInorder = indexOf(inorder, currentValue);
            TreeNode root = new TreeNode(currentValue);
            root.left = build(values, Arrays.copyOfRange(inorder, 0, indexInorder));
            root.right = build(values, Arrays.copyOfRange(inorder, indexInorder + 1, inorder.length));

            return root;
        } else {
            return null;
        }
    }

    private int indexOf(int[] array, int value) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
