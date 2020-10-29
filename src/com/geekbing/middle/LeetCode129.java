package com.geekbing.middle;

/**
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * 129. 求根到叶子节点数字之和
 *
 * @author bing
 */
public class LeetCode129 {
    private int ans;

    public int sumNumbers(TreeNode root) {
        ans = 0;
        travel(root, 0);
        return ans;
    }

    private void travel(TreeNode root, int parent) {
        if (root != null) {
            int temp = parent * 10 + root.val;
            if (root.left == null && root.right == null) {
                ans += temp;
            }
            if (root.left != null) {
                travel(root.left, temp);
            }
            if (root.right != null) {
                travel(root.right, temp);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode129 leetCode129 = new LeetCode129();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(leetCode129.sumNumbers(root));
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
