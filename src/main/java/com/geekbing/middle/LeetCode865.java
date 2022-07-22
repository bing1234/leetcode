package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode865 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return root;
        }
        int leftDepth = depthOfTree(root.left);
        int rightDepth = depthOfTree(root.right);
        if (leftDepth == rightDepth) {
            return root;
        } else if (leftDepth > rightDepth) {
            return subtreeWithAllDeepest(root.left);
        } else {
            return subtreeWithAllDeepest(root.right);
        }
    }

    private int depthOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depthOfTree(root.left), depthOfTree(root.right)) + 1;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void testCase1() {
        LeetCode865 leetCode865 = new LeetCode865();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode ans = leetCode865.subtreeWithAllDeepest(root);
        assert ans.val == 2;
    }

    @Test
    public void testCase2() {
        LeetCode865 leetCode865 = new LeetCode865();

        TreeNode root = new TreeNode(1);

        TreeNode ans = leetCode865.subtreeWithAllDeepest(root);
        assert ans.val == 1;
    }

    @Test
    public void testCase3() {
        LeetCode865 leetCode865 = new LeetCode865();

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode ans = leetCode865.subtreeWithAllDeepest(root);
        assert ans.val == 2;
    }
}
