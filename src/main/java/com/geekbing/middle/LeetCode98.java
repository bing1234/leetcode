package com.geekbing.middle;

import java.util.ArrayList;
import java.util.List;

public class LeetCode98 {
    private long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }

    public boolean isValidBSTV2(TreeNode root) {
        List<Integer> nodes = traverse(root);
        for (int i = 0; i < nodes.size() - 1; i++) {
            if (nodes.get(i) >= nodes.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> traverse(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root != null) {
            ans.addAll(traverse(root.left));
            ans.add(root.val);
            ans.addAll(traverse(root.right));
        }
        return ans;
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
        LeetCode98 leetCode98 = new LeetCode98();

        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println(leetCode98.isValidBST(root1));

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println(leetCode98.isValidBST(root2));

        TreeNode root3 = new TreeNode(10);
        root3.left = new TreeNode(5);
        root3.right = new TreeNode(15);
        root3.right.left = new TreeNode(6);
        root3.right.right = new TreeNode(20);
        System.out.println(leetCode98.isValidBST(root3));
    }
}
