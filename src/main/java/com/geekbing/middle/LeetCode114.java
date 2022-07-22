package com.geekbing.middle;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/submissions/
 * 114. 二叉树展开为链表
 *
 * @author bing
 */
public class LeetCode114 {
    public void flatten(TreeNode root) {
        travel(root);
    }

    /**
     * 返回最后一个元素
     */
    private TreeNode travel(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null && root.right != null) {
            TreeNode left = root.left, right = root.right;
            root.left = null;
            root.right = left;
            TreeNode leftLast = travel(left);
            leftLast.left = null;
            leftLast.right = right;
            return travel(right);
        } else if (root.left != null) {
            TreeNode left = root.left;
            root.left = null;
            root.right = left;
            return travel(left);
        } else if (root.right != null) {
            return travel(root.right);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        LeetCode114 leetCode114 = new LeetCode114();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        leetCode114.flatten(root);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
