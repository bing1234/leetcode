package com.geekbing.middle;

import java.util.Arrays;

public class LeetCode654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int maxIndex = findMaxIndex(nums);
        if (maxIndex == -1) {
            return null;
        }
        int[] left = Arrays.copyOfRange(nums, 0, maxIndex);
        int[] right = Arrays.copyOfRange(nums, maxIndex + 1, nums.length);
        TreeNode root = new TreeNode(nums[maxIndex]);
        TreeNode leftTree = constructMaximumBinaryTree(left);
        TreeNode rightTree = constructMaximumBinaryTree(right);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }

    private int findMaxIndex(int[] nums) {
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        LeetCode654 leetCode654 = new LeetCode654();
        System.out.println(leetCode654.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}).val);
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
