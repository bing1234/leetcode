package com.geekbing.easy;

import java.util.*;

public class LeetCode501 {
    private long pre;
    private int maxCount, currentCount;
    private List<Integer> ans;

    public int[] findMode(TreeNode root) {
        pre = Long.MIN_VALUE;
        maxCount = 0;
        currentCount = 0;
        ans = new ArrayList<>();

        traverse(root);
        pre = Long.MIN_VALUE;
        currentCount = 0;
        traverseCount(root);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private void traverseCount(TreeNode root) {
        if (root != null) {
            traverseCount(root.left);

            if (root.val == pre) {
                currentCount++;
            } else {
                currentCount = 1;
            }
            if (currentCount == maxCount) {
                ans.add(root.val);
            }

            pre = root.val;
            traverseCount(root.right);
        }
    }

    private void traverse(TreeNode root) {
        if (root != null) {
            traverse(root.left);

            if (root.val == pre) {
                currentCount++;
            } else {
                currentCount = 1;
            }
            maxCount = Math.max(maxCount, currentCount);

            pre = root.val;
            traverse(root.right);
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

    public static void main(String[] args) {
        LeetCode501 leetCode501 = new LeetCode501();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        System.out.println(Arrays.toString(leetCode501.findMode(root)));
    }
}
