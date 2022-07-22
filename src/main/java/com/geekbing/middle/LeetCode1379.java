package com.geekbing.middle;

public class LeetCode1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original != null) {
            if (original == target) {
                return cloned;
            }
            TreeNode left = getTargetCopy(original.left, cloned.left, target);
            if (left != null) {
                return left;
            }
            TreeNode right = getTargetCopy(original.right, cloned.right, target);
            if (right != null) {
                return right;
            }
            return null;
        }
        return null;
    }

    public static void main(String[] args) {
        LeetCode1379 leetCode1379 = new LeetCode1379();

        TreeNode target1 = new TreeNode(3);
        TreeNode target1_1 = new TreeNode(3);

        TreeNode original1 = new TreeNode(7);
        original1.left = new TreeNode(4);
        original1.right = target1;
        original1.right.left = new TreeNode(6);
        original1.right.right = new TreeNode(19);

        TreeNode clone1 = new TreeNode(7);
        clone1.left = new TreeNode(4);
        clone1.right = target1_1;
        clone1.right.left = new TreeNode(6);
        clone1.right.right = new TreeNode(19);

        System.out.println(leetCode1379.getTargetCopy(original1, clone1, target1).val);

        TreeNode original2 = new TreeNode(7);
        TreeNode cloned2 = new TreeNode(7);
        System.out.println(leetCode1379.getTargetCopy(original2, cloned2, original2).val);
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
