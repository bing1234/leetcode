package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left != null || root.right != null) {
            return root;
        }
        return root.val == 0 ? null : root;
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void testCase1() {
        LeetCode814 leetCode814 = new LeetCode814();
        TreeNode root = new TreeNode(1);
        TreeNode newRoot = leetCode814.pruneTree(root);
    }

    @Test
    public void testCase2() {
        LeetCode814 leetCode814 = new LeetCode814();
        TreeNode root = new TreeNode(1);
        TreeNode newRoot = leetCode814.pruneTree(root);
    }

    @Test
    public void testCase3() {
        LeetCode814 leetCode814 = new LeetCode814();
        TreeNode root = new TreeNode(1);
        TreeNode newRoot = leetCode814.pruneTree(root);
    }
}
