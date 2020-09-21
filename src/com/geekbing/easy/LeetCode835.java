package com.geekbing.easy;

public class LeetCode835 {
    private int sum;

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        inTraversal(root);
        return root;
    }

    private void inTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inTraversal(root.right);
        root.val += sum;
        sum = root.val;
        inTraversal(root.left);
    }

    public static void main(String[] args) {
        LeetCode835 leetCode835 = new LeetCode835();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);

        TreeNode newNode = leetCode835.convertBST(root);
        System.out.println(newNode.val);
        System.out.println(newNode.left.val);
        System.out.println(newNode.right.val);
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
