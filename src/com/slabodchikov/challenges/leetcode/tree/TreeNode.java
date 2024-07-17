package com.slabodchikov.challenges.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {

        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {

        this.val = val;
        this.left = left;
        this.right = right;
    }

    static TreeNode fromArray(Integer[] tree) {
        if (tree.length == 0) return null;
        TreeNode root = new TreeNode(tree[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for (int i = 1; i < tree.length - 1; i += 2) {
            TreeNode node = q.peek();

            if (tree[i] != null) {
                node.left = new TreeNode(tree[i]);
                q.add(node.left);
            }
            if (tree[i + 1] != null) {
                node.right = new TreeNode(tree[i + 1]);
                q.add(node.right);
            }
            q.remove();
        }
        return root;
    }
}
