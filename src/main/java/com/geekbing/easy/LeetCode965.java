package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        int value = root.val;
        if (root.left != null && root.left.val != value) {
            return false;
        }
        if (root.right != null && root.right.val != value) {
            return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    public static void main(String[] args) {
        LeetCode965 leetCode965 = new LeetCode965();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(1);
        root1.right.right = new TreeNode(1);
        System.out.println(leetCode965.isUnivalTree(root1));

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(5);
        root2.left.right = new TreeNode(2);
        System.out.println(leetCode965.isUnivalTree(root2));
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
