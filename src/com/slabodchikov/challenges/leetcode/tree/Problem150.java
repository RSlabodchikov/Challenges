package com.slabodchikov.challenges.leetcode.tree;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers/">Problem 150</a>
 */
public class Problem150 {

    public int sumNumbers(TreeNode root) {

        int sum = 0;

        LinkedList<Map.Entry<TreeNode, Integer>> nodesToPrefix = new LinkedList<>();
        nodesToPrefix.add(createNewEntry(root, root.val));
        while (!nodesToPrefix.isEmpty()) {
            Map.Entry<TreeNode, Integer> currentNode = nodesToPrefix.poll();
            if (currentNode.getKey().left == null && currentNode.getKey().right == null) {
                sum += currentNode.getValue();
            } else {
                if (currentNode.getKey().left != null) {
                    Integer leftPrefix =
                        currentNode.getValue() * 10 + (currentNode.getKey().left.val);
                    nodesToPrefix.add(createNewEntry(currentNode.getKey().left, leftPrefix));
                }
                if (currentNode.getKey().right != null) {
                    Integer rightPrefix =
                        currentNode.getValue() * 10 + currentNode.getKey().right.val;
                    nodesToPrefix.add(createNewEntry(currentNode.getKey().right, rightPrefix));
                }
            }
        }

        return sum;
    }

    private Map.Entry<TreeNode, Integer> createNewEntry(TreeNode treeNode, Integer sb) {

        return new AbstractMap.SimpleImmutableEntry<>(
            treeNode, sb
        );
    }
}
