package com.geekbing.hard;

public class LeetCode968 {
    private int ans;

    public int minCameraCover(TreeNode root) {
        ans = 0;
        if (dfs(root) == 2) {
            ans++;
        }
        return ans;
    }

    // 0：该节点安装了监视器 1：该节点可观，但没有安装监视器 2：该节点不可观
    private int dfs(TreeNode root) {
        if (root == null) {
            return 1;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 2 || right == 2) {
            ans++;
            return 0;
        }
        if (left == 0 || right == 0) {
            return 1;
        }
        return 2;
    }

    public static void main(String[] args) {
        LeetCode968 leetCode968 = new LeetCode968();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        System.out.println(leetCode968.minCameraCover(root1));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.left.right = new TreeNode(5);
        System.out.println(leetCode968.minCameraCover(root2));
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
