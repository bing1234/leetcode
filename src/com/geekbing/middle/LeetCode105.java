package com.geekbing.middle;

import java.util.Arrays;

public class LeetCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 参数检查
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = findIndex(inorder, preorder[0]);
        if (rootIndex != -1) {
            int[] leftInOrder = Arrays.copyOfRange(inorder, 0, rootIndex);
            int[] rightInOrder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
            int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, leftInOrder.length + 1);
            int[] rightPreOrder = Arrays.copyOfRange(preorder, preorder.length - rightInOrder.length, preorder.length);
            root.left = buildTree(leftPreOrder, leftInOrder);
            root.right = buildTree(rightPreOrder, rightInOrder);
        }
        return root;
    }

    private int findIndex(int[] inOrder, int num) {
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode105 leetCode105 = new LeetCode105();
        TreeNode root = leetCode105.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        leetCode105.printTree(root);
    }

    private void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.println(root.val);
            printTree(root.right);
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
