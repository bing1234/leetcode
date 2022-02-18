package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode230 {
    public int kthSmallest(TreeNode root, int k) {
        int leftCount = countTree(root.left);
        if (leftCount < k - 1) {
            return kthSmallest(root.right, k - leftCount - 1);
        } else if (leftCount == k - 1) {
            return root.val;
        } else {
            return kthSmallest(root.left, k);
        }
    }

    private int countTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + countTree(root.left) + countTree(root.right);
    }

    private static final class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void testCase1() {
        LeetCode230 leetCode230 = new LeetCode230();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        assert leetCode230.kthSmallest(root, 1) == 1;
    }

    @Test
    public void testCase2() {
        LeetCode230 leetCode230 = new LeetCode230();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        assert leetCode230.kthSmallest(root, 3) == 3;
    }
}
