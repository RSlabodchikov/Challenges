package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/compute-height-of-bst/problem">Problem</a>
 */
public class BSTHeight {

    /*
     * Complete the 'getBinarySearchTreeHeight' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY values
     *  2. INTEGER_ARRAY leftChild
     *  3. INTEGER_ARRAY rightChild
     */
    public static int getBinarySearchTreeHeight(List<Integer> values, List<Integer> leftChild, List<Integer> rightChild) {

        if (values.isEmpty()) {
            return 0;
        }

        List<TreeNode> tree = new ArrayList<>();

        for (int i = 0; i < values.size(); i++) {
            tree.add(new TreeNode(values.get(i)));
        }

        for (int i = 0; i < values.size(); i++) {
            TreeNode node = tree.get(i);
            node.left = leftChild.get(i) == -1 ? null : tree.get(leftChild.get(i));
            node.right = rightChild.get(i) == -1 ? null : tree.get(rightChild.get(i));
        }

        return getTreeHeight(tree.get(0));
    }

    private static int getTreeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getTreeHeight(node.left);
        int rightHeight = getTreeHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }
}
