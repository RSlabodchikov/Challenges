package com.slabodchikov.challenges.leetcode.tree;


import java.util.*;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/binary-tree-right-side-view/">Problem 199</a>
 */
public class Problem199 {

    public static void main(String[] args) {
        Integer[] vals = new Integer[]{1, 2};
        System.out.println(rightSideView(TreeNode.fromArray(vals)));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        Map<Integer, Integer> map = new HashMap<>();
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            map.put(pair.right, pair.left.val);
            if (pair.left.left != null) {
                queue.add(new Pair<>(pair.left.left, pair.right + 1));
            }
            if (pair.left.right != null) {
                queue.add(new Pair<>(pair.left.right, pair.right + 1));
            }
        }

        return new ArrayList<>(map.values());
    }

    static class Pair<L, R> {
        L left;
        R right;

        public Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }
    }
}
