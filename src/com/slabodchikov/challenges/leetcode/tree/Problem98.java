package com.slabodchikov.challenges.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/validate-binary-search-tree/">Problem 98</a>
 */
public class Problem98 {

    public static boolean isValidBST(TreeNode root) {

        List<Integer> treeValues = new ArrayList<>();
        treeToList(root, treeValues);

        for (int i = 1; i < treeValues.size(); i++) {
            if (treeValues.get(i - 1) >= treeValues.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void treeToList(TreeNode node, List<Integer> result) {

        if (node != null) {
            treeToList(node.left, result);
            result.add(node.val);
            treeToList(node.right, result);
        }
    }
}
