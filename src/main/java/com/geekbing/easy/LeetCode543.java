package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode543 {
    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        maxLenWithOneSide(root);
        return max;
    }

    private int maxLenWithOneSide(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxLenWithOneSide(root.left);
        int leftRoot = root.left == null ? 0 : left + 1;

        int right = maxLenWithOneSide(root.right);
        int rightRoot = root.right == null ? 0 : right + 1;

        max = Math.max(max, leftRoot + rightRoot);
        return Math.max(leftRoot, rightRoot);
    }

    public static void main(String[] args) {
        LeetCode543 leetCode543 = new LeetCode543();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        System.out.println(leetCode543.diameterOfBinaryTree(root));
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
