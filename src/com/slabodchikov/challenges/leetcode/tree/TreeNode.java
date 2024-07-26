package com.slabodchikov.challenges.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
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

    public List<Integer> toArray() {
        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return list;
    }

    static TreeNode fromArray(Integer[] tree) {
        if (tree.length == 0) return null;
        TreeNode root = new TreeNode(tree[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        if (tree.length == 2) {
            root.left = new TreeNode(tree[1]);
            return root;
        }
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
