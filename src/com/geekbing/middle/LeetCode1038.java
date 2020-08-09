package com.geekbing.middle;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode1038 {
    public TreeNode bstToGst(TreeNode root) {
        return null;
    }

    public static void main(String[] args) {
        LeetCode1038 leetCode1038 = new LeetCode1038();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        System.out.println(leetCode1038.bstToGst(root));
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
