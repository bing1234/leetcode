package com.geekbing.easy;

public class LeetCode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return convertBST(nums, 0, nums.length - 1);
    }

    private TreeNode convertBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = convertBST(nums, left, mid - 1);
        root.right = convertBST(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        LeetCode108 leetCode108 = new LeetCode108();
        TreeNode root = leetCode108.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        leetCode108.printTree(root);
    }

    private void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }
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
