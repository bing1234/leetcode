package com.geekbing.middle;

public class LeetCode222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 1;
        if (root.left != null) {
            ans += countNodes(root.left);
        }
        if (root.right != null) {
            ans += countNodes(root.right);
        }
        return ans;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
