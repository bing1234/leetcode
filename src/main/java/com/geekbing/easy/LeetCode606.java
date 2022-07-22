package com.geekbing.easy;

public class LeetCode606 {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null) {
            return String.valueOf(t.val);
        }
        if (t.left == null) {
            return t.val + "()" + "(" + tree2str(t.right) + ")";
        }
        if (t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }
        return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }

    public static void main(String[] args) {
        LeetCode606 leetCode606 = new LeetCode606();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(4);
        root1.right = new TreeNode(3);
        System.out.println(leetCode606.tree2str(root1));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(3);
        System.out.println(leetCode606.tree2str(root2));
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
