package com.slabodchikov.challenges.leetcode.tree;

import java.util.LinkedList;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/same-tree">Problem 100</a>
 */
public class Problem100 {

    public static void main(String[] args) {

        Problem100 problem100 = new Problem100();
        Integer[] pValues = new Integer[]{1, 2, 3};
        Integer[] qValues = new Integer[]{1, 2, 3};
        TreeNode p = TreeNode.fromArray(pValues);
        TreeNode q = TreeNode.fromArray(qValues);
        System.out.println(problem100.isSameTree(p, q));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        LinkedList<TreeNode> pQueue = new LinkedList<>();
        LinkedList<TreeNode> qQueue = new LinkedList<>();
        pQueue.add(p);
        qQueue.add(q);

        while (!pQueue.isEmpty()) {
            if (qQueue.isEmpty()) {
                return false;
            }
            TreeNode currentPNode = pQueue.poll();
            TreeNode currentQNode = qQueue.poll();
            if (!compareNodes(currentPNode, currentQNode)) {
                return false;
            }
            if (currentPNode != null) {
                pQueue.add(currentPNode.left);
                pQueue.add(currentPNode.right);
                qQueue.add(currentQNode.left);
                qQueue.add(currentQNode.right);
            }
        }

        return qQueue.isEmpty();
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
