package com.geekbing.easy;

public class LeetCode671 {
    public int findSecondMinimumValue(TreeNode root) {
        return 0;
    }

    public static void main(String[] args) {
        LeetCode671 leetCode671 = new LeetCode671();

        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
        System.out.println(leetCode671.findSecondMinimumValue(root1));

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        System.out.println(leetCode671.findSecondMinimumValue(root2));
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
