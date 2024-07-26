package com.slabodchikov.challenges.leetcode.tree;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/delete-node-in-a-bst/">Problem 450</a>
 */
public class Problem450 {

    public static void main(String[] args) {
        Integer[] vals = new Integer[]{5,3,6,2,4,null,7};
        TreeNode root = TreeNode.fromArray(vals);
        System.out.println(deleteNode(root, 3).toArray());
    }

    public static TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        List<Integer> nodeVals = toArray(root);
        nodeVals.removeIf(node -> node == val);
        return bstFromArray(nodeVals);
    }

    static List<Integer> toArray(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
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

    static TreeNode bstFromArray(List<Integer> tree) {
        if (tree.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(tree.get(0));
        for (int i = 1; i < tree.size(); i++) {
            addToTree(root, tree.get(i));
        }
        return root;
    }

    static void addToTree(TreeNode root, int val) {
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                addToTree(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                addToTree(root.right, val);
            }
        }
    }
}
