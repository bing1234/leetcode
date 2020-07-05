package com.geekbing.easy;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode938 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        return 0;
    }

    public static void main(String[] args) {
        LeetCode938 leetCode938 = new LeetCode938();

        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(15);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(7);
        root1.right.right = new TreeNode(18);
        System.out.println(leetCode938.rangeSumBST(root1, 7, 15));

        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(13);
        root2.right.right = new TreeNode(18);
        root2.left.left.left = new TreeNode(1);
        root2.left.right.left = new TreeNode(6);
        System.out.println(leetCode938.rangeSumBST(root2, 6, 10));
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
