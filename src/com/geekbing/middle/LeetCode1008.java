package com.geekbing.middle;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return root;
        }

        // 找到第一个小于
        int i = 1;
        while (i < preorder.length) {
            if (preorder[i] > preorder[0]) {
                break;
            }
            i++;
        }

        int[] leftArr = Arrays.copyOfRange(preorder, 1, i);
        int[] rightArr = Arrays.copyOfRange(preorder, i, preorder.length);
        root.left = bstFromPreorder(leftArr);
        root.right = bstFromPreorder(rightArr);
        return root;
    }

    public static void main(String[] args) {
        LeetCode1008 leetCode1008 = new LeetCode1008();
        System.out.println(leetCode1008.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12}));
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
