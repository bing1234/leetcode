package com.geekbing.easy;

public class LeetCode687 {
    private int longest = 0;

    public int longestUnivaluePath(TreeNode root) {
        longest = 0;
        longestSingleSideWithRoot(root);
        return longest;
    }

    private int longestSingleSideWithRoot(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = longestSingleSideWithRoot(root.left);
        int right = longestSingleSideWithRoot(root.right);

        int leftWithRoot = 0, rightWithRoot = 0;
        if (root.left != null && root.val == root.left.val) {
            leftWithRoot = 1 + left;
        }
        if (root.right != null && root.val == root.right.val) {
            rightWithRoot = 1 + right;
        }
        longest = Math.max(longest, leftWithRoot + rightWithRoot);
        return Math.max(leftWithRoot, rightWithRoot);
    }

    public static void main(String[] args) {
        LeetCode687 leetCode687 = new LeetCode687();

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(1);
        root1.right = new TreeNode(5);
        root1.right.right = new TreeNode(5);
        System.out.println(leetCode687.longestUnivaluePath(root1));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(4);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(5);
        root2.right.right = new TreeNode(5);
        System.out.println(leetCode687.longestUnivaluePath(root2));

        TreeNode root3 = new TreeNode(1);
        System.out.println(leetCode687.longestUnivaluePath(root3));
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
