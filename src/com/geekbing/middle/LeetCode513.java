package com.geekbing.middle;

public class LeetCode513 {
    public int findBottomLeftValue(TreeNode root) {
        int depth = depthOfTree(root);
        Integer ans = travel(root, 1, depth);
        if (ans == null) {
            throw new RuntimeException("there is no answer.");
        }
        return ans;
    }

    private Integer travel(TreeNode root, int curDepth, int maxDepth) {
        if (root.left != null) {
            Integer left = travel(root.left, curDepth + 1, maxDepth);
            if (left != null) {
                return left;
            }
        }
        if (root.right != null) {
            Integer right = travel(root.right, curDepth + 1, maxDepth);
            if (right != null) {
                return right;
            }
        }
        if (curDepth == maxDepth) {
            return root.val;
        }
        return null;
    }

    private int depthOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depthOfTree(root.left), depthOfTree(root.right));
    }

    public static void main(String[] args) {
        LeetCode513 leetCode513 = new LeetCode513();

        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println(leetCode513.findBottomLeftValue(root1));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(4);
        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(5);
        root2.right.left.left = new TreeNode(7);
        root2.right.right = new TreeNode(6);
        System.out.println(leetCode513.findBottomLeftValue(root2));
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
