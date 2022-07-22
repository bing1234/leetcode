package com.geekbing.middle;

/**
 * 538. 把二叉搜索树转换为累加树
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 *
 * @author bing
 */
public class LeetCode538 {
    private int sum;

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        travel(root);
        return root;
    }

    private void travel(TreeNode root) {
        if (root != null) {
            travel(root.right);
            root.val += sum;
            sum = root.val;
            travel(root.left);
        }
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
