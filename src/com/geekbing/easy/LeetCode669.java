package com.geekbing.easy;

public class LeetCode669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val <= high) {
            if (root.left != null) {
                root.left = trimBST(root.left, low, high);
            }
            if (root.right != null) {
                root.right = trimBST(root.right, low, high);
            }
            return root;
        } else {
            return trimBST(root.left, low, high);
        }
    }

    public static void main(String[] args) {
        LeetCode669 leetCode669 = new LeetCode669();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(0);
        root1.right = new TreeNode(2);
        TreeNode newRoot1 = leetCode669.trimBST(root1, 1, 2);
        System.out.println(newRoot1);
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
