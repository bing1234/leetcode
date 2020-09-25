package com.geekbing.middle;

import java.util.Arrays;

public class LeetCode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        // 定位根节点的下标
        int rootIndex = findRootIndex(inorder, postorder[postorder.length - 1]);
        if (rootIndex != -1) {
            int[] leftInOrder = Arrays.copyOfRange(inorder, 0, rootIndex);
            int[] rightInOrder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
            int[] leftPost = Arrays.copyOfRange(postorder, 0, leftInOrder.length);
            int[] rightPost = Arrays.copyOfRange(postorder, leftInOrder.length, postorder.length - 1);
            root.left = buildTree(leftInOrder, leftPost);
            root.right = buildTree(rightInOrder, rightPost);
        }
        return root;
    }

    private int findRootIndex(int[] inOrder, int rootVal) {

        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == rootVal) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        LeetCode106 leetCode106 = new LeetCode106();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        TreeNode newRoot = leetCode106.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        leetCode106.print(newRoot);
    }

    private void print(TreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.println(root.val);
            print(root.right);
        }
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
