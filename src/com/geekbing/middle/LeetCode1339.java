package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1339 {
    private long total;
    private long ans;

    public int maxProduct(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 所有和
        total = sumOfTree(root);
        // 遍历二叉树
        travelTree(root);
        return (int) (ans % 1000000007L);
    }

    private long travelTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算当前节点以及左右子数的和
        long curSum = root.val + travelTree(root.left) + travelTree(root.right);
        ans = Math.max(ans, curSum * (total - curSum));
        return curSum;
    }

    private long sumOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sumOfTree(root.left) + sumOfTree(root.right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void testCase1() {
        LeetCode1339 leetCode1339 = new LeetCode1339();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        int ans = leetCode1339.maxProduct(root);
        assert ans == 110;
    }

    @Test
    public void testCase2() {
        LeetCode1339 leetCode1339 = new LeetCode1339();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(6);

        int ans = leetCode1339.maxProduct(root);
        assert ans == 90;
    }

    @Test
    public void testCase3(){
        LeetCode1339 leetCode1339 = new LeetCode1339();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(10);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(11);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(6);

        int ans = leetCode1339.maxProduct(root);
        assert ans == 1025;
    }

    @Test
    public void testCase4(){
        LeetCode1339 leetCode1339 = new LeetCode1339();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);

        int ans = leetCode1339.maxProduct(root);
        assert ans == 1;
    }
}
