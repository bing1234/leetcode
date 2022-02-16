package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1325 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
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
        LeetCode1325 leetCode1325 = new LeetCode1325();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);

        TreeNode ansTree = leetCode1325.removeLeafNodes(root, 2);

        TreeNode expertTree = new TreeNode(1);
        expertTree.right = new TreeNode(3);
        expertTree.right.right = new TreeNode(4);

        assert sameTree(ansTree, expertTree);
    }

    @Test
    public void testCase2() {
        LeetCode1325 leetCode1325 = new LeetCode1325();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode ansTree = leetCode1325.removeLeafNodes(root, 3);

        TreeNode expertTree = new TreeNode(1);
        expertTree.left = new TreeNode(3);
        expertTree.left.right = new TreeNode(2);

        assert sameTree(ansTree, expertTree);
    }

    @Test
    public void testCase3() {
        LeetCode1325 leetCode1325 = new LeetCode1325();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(2);

        TreeNode ansTree = leetCode1325.removeLeafNodes(root, 2);

        TreeNode expertTree = new TreeNode(1);
        assert sameTree(ansTree, expertTree);
    }

    private boolean sameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return sameTree(root1.left, root2.left) && sameTree(root1.right, root2.right);
    }
}
