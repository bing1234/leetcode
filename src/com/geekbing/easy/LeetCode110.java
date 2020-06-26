package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(depthOfTree(root.left) - depthOfTree(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int depthOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depthOfTree(root.left), depthOfTree(root.right));
    }

    public static void main(String[] args) {
        LeetCode110 leetCode110 = new LeetCode110();

        TreeNode tree1 = new TreeNode(3);
        tree1.left = new TreeNode(9);
        tree1.right = new TreeNode(20);
        tree1.right.left = new TreeNode(15);
        tree1.right.right = new TreeNode(7);
        System.out.println(leetCode110.isBalanced(tree1));
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
