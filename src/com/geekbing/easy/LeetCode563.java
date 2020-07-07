package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode563 {
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.abs(sumOfTree(root.left) - sumOfTree(root.right)) + findTilt(root.left) + findTilt(root.right);
    }

    private int sumOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sumOfTree(root.left) + sumOfTree(root.right);
    }

    public static void main(String[] args) {
        LeetCode563 leetCode563 = new LeetCode563();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        System.out.println(leetCode563.findTilt(root1));


        // [1, 2, 3, 4, null, 5]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.right.left = new TreeNode(5);
        System.out.println(leetCode563.findTilt(root2));
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
