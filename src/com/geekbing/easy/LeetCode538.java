package com.geekbing.easy;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode538 {
    public TreeNode convertBST(TreeNode root) {
        return null;
    }

    public static void main(String[] args) {
        LeetCode538 leetCode538 = new LeetCode538();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        System.out.println(leetCode538.convertBST(root));
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
