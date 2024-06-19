package com.slabodchikov.challenges.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/description/">Problem 94</a>
 */
public class Problem94 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        System.out.println(inorderTraversalIteratively(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        inorderTraversalRecursive(root, result);
        return result;
    }

    public static List<Integer> inorderTraversalIteratively(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        List<Integer> result = new ArrayList<>();

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            result.add(currentNode.val);
            currentNode = currentNode.right;
        }
        return result;
    }

    public static void inorderTraversalRecursive(TreeNode node, List<Integer> result) {

        if (node != null) {
            inorderTraversalRecursive(node.left, result);
            result.add(node.val);
            inorderTraversalRecursive(node.right, result);
        }
    }
}
