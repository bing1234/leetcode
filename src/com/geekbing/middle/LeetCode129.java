package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode129 {
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }

    private int sumNumbersHelper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return sumNumbersHelper(root.left, sum) + sumNumbersHelper(root.right, sum);
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
        LeetCode129 leetCode129 = new LeetCode129();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        assert leetCode129.sumNumbers(tree) == 25;
    }

    @Test
    public void testCase2() {
        LeetCode129 leetCode129 = new LeetCode129();
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(9);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(1);
        tree.right = new TreeNode(0);
        assert leetCode129.sumNumbers(tree) == 1026;
    }
}
