package com.geekbing.easy;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode543 {
    public int diameterOfBinaryTree(TreeNode root) {
        return 0;
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
