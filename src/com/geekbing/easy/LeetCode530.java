package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode530 {
    public int getMinimumDifference(TreeNode root) {
        int minDiff = Integer.MAX_VALUE;
        if (root == null) {
            return minDiff;
        }
        // 递归处理左子树
        if (root.left != null) {
            minDiff = Math.min(minDiff, getMinimumDifference(root.left));
        }

        // 当前节点是root时
        TreeNode leftMax = findLeftMax(root);
        if (leftMax != null) {
            minDiff = Math.min(minDiff, root.val - leftMax.val);
        }
        TreeNode rightMin = findRightMin(root);
        if (rightMin != null) {
            minDiff = Math.min(minDiff, rightMin.val - root.val);
        }

        // 递归处理右子树
        if (root.right != null) {
            minDiff = Math.min(minDiff, getMinimumDifference(root.right));
        }
        return minDiff;
    }

    private TreeNode findLeftMax(TreeNode root) {
        if (root == null || root.left == null) {
            return null;
        }
        TreeNode result = root.left;
        while (result.right != null) {
            result = result.right;
        }
        return result;
    }

    private TreeNode findRightMin(TreeNode root) {
        if (root == null || root.right == null) {
            return null;
        }
        TreeNode result = root.right;
        while (result.left != null) {
            result = result.left;
        }
        return result;
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
        LeetCode530 leetCode530 = new LeetCode530();

        TreeNode root = new TreeNode(1);
        root.right =  new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(leetCode530.getMinimumDifference(root));
    }
}
