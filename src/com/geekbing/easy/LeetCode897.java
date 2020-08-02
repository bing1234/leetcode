package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode897 {
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> nodes = inOrder(root);
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).left = null;
            nodes.get(i).right = nodes.get(i + 1);
        }
        return nodes.get(0);
    }

    private List<TreeNode> inOrder(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        if (root == null) {
            return nodes;
        }
        if (root.left != null) {
            nodes.addAll(inOrder(root.left));
        }
        nodes.add(root);
        if (root.right != null) {
            nodes.addAll(inOrder(root.right));
        }
        return nodes;
    }

    public static void main(String[] args) {
        LeetCode897 leetCode897 = new LeetCode897();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        TreeNode result = leetCode897.increasingBST(root);
        System.out.println(result);
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
