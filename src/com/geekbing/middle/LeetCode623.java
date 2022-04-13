package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        List<TreeNode> levels = getLevelNodes(root, 1, depth - 1);
        for (TreeNode node : levels) {
            TreeNode oldLeft = node.left;
            node.left = new TreeNode(val);
            node.left.left = oldLeft;

            TreeNode oldRight = node.right;
            node.right = new TreeNode(val);
            node.right.right = oldRight;
        }
        return root;
    }

    private List<TreeNode> getLevelNodes(TreeNode root, int cur, int level) {
        List<TreeNode> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (cur == level) {
            ans.add(root);
            return ans;
        }
        if (root.left != null) {
            ans.addAll(getLevelNodes(root.left, cur + 1, level));
        }
        if (root.right != null) {
            ans.addAll(getLevelNodes(root.right, cur + 1, level));
        }
        return ans;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private boolean sameTree(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null) {
            if (root1.val != root2.val) {
                return false;
            }
            return sameTree(root1.left, root2.left) && sameTree(root1.right, root2.right);
        }
        return root1 == null && root2 == null;
    }

    @Test
    public void testCase1() {
        LeetCode623 leetCode623 = new LeetCode623();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);

        TreeNode newRoot = leetCode623.addOneRow(root, 1, 2);

        TreeNode expert = new TreeNode(4);
        expert.left = new TreeNode(1);
        expert.left.left = new TreeNode(2);
        expert.left.left.left = new TreeNode(3);
        expert.left.left.right = new TreeNode(1);
        expert.right = new TreeNode(1);
        expert.right.right = new TreeNode(6);
        expert.right.right.left = new TreeNode(5);
        assert sameTree(expert, newRoot);
    }

    @Test
    public void testCase2() {
        LeetCode623 leetCode623 = new LeetCode623();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);

        TreeNode newRoot = leetCode623.addOneRow(root, 1, 3);

        TreeNode expert = new TreeNode(4);
        expert.left = new TreeNode(2);
        expert.left.left = new TreeNode(1);
        expert.left.left.left = new TreeNode(3);
        expert.left.right = new TreeNode(1);
        expert.left.right.right = new TreeNode(1);
        assert sameTree(expert, newRoot);
    }
}
