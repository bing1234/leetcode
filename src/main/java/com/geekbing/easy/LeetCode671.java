package com.geekbing.easy;

public class LeetCode671 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return -1;
        }
        if (root.left == null || root.right == null) {
            return -1;
        }
        if (root.left.val != root.right.val) {
            int left = findSecondMinimumValue(root.left);
            int right = findSecondMinimumValue(root.right);
            if (left == -1 && right == -1) {
                return Math.max(root.left.val, root.right.val);
            } else if (left == -1) {
                return findSecondMinimumValue(new int[]{right, root.left.val, root.right.val});
            } else if (right == -1) {
                return findSecondMinimumValue(new int[]{left, root.left.val, root.right.val});
            } else {
                return findSecondMinimumValue(new int[]{left, right, root.left.val, root.right.val});
            }
        } else {
            int left = findSecondMinimumValue(root.left);
            int right = findSecondMinimumValue(root.right);
            if (left == -1) {
                return right;
            }
            if (right == -1) {
                return left;
            }
            return Math.min(left, right);
        }
    }

    private int findSecondMinimumValue(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return min2;
    }

    public static void main(String[] args) {
        LeetCode671 leetCode671 = new LeetCode671();

        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
        System.out.println(leetCode671.findSecondMinimumValue(root1));

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        System.out.println(leetCode671.findSecondMinimumValue(root2));
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
