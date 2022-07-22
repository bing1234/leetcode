package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return sum == 0;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        if (root.left == null) {
            return hasPathSum(root.right, sum - root.val);
        }
        if (root.right == null) {
            return hasPathSum(root.left, sum - root.val);
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        LeetCode112 leetCode112 = new LeetCode112();

        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(8);
        tree.left.left = new TreeNode(11);
        tree.left.left.left = new TreeNode(7);
        tree.left.left.right = new TreeNode(2);
        tree.right.left = new TreeNode(13);
        tree.right.right = new TreeNode(4);
        tree.right.right.right = new TreeNode(1);
        System.out.println(leetCode112.hasPathSum(tree, 22));
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
