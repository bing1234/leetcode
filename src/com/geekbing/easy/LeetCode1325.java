package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1325 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return null;
    }

    public static void main(String[] args) {

    }

    private static final class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
