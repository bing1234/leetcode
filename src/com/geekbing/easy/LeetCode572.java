package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        return sameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean sameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        if (t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return sameTree(s.left, t.left) && sameTree(s.right, t.right);
    }

    private static class TreeNode {
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
    }
}
