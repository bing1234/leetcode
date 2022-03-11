package com.geekbing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1123 {
    public TreeNode lcaDeepestLeavesV2(TreeNode root) {
        if (root == null) {
            return root;
        }
        // 求左右子数的最大深度
        int leftDepth = maxDepthOfTree(root.left);
        int rightDepth = maxDepthOfTree(root.right);
        if (leftDepth == rightDepth) {
            return root;
        } else if (leftDepth > rightDepth) {
            return lcaDeepestLeavesV2(root.left);
        } else {
            return lcaDeepestLeavesV2(root.right);
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return root;
        }

        // 求树的最大深度
        int maxDepth = maxDepthOfTree(root);

        // 求出处于最大深度的所有节点
        List<TreeNode> levelNodes = levelNodesOfTree(root, maxDepth);
        if (levelNodes.size() == 1) {
            return levelNodes.get(0);
        }

        // 两两节点求最近公共祖先
        TreeNode ans = levelNodes.get(0);
        for (int i = 1; i < levelNodes.size(); i++) {
            ans = lowestCommonAncestor(root, ans, levelNodes.get(i));
        }
        return ans;
    }

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    private List<TreeNode> levelNodesOfTree(TreeNode root, int level) {
        return levelNodesOfTreeHelper(root, 1, level);
    }

    private List<TreeNode> levelNodesOfTreeHelper(TreeNode root, int curLevel, int level) {
        List<TreeNode> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (curLevel == level) {
            ans.add(root);
        } else if (curLevel < level) {
            ans.addAll(levelNodesOfTreeHelper(root.left, curLevel + 1, level));
            ans.addAll(levelNodesOfTreeHelper(root.right, curLevel + 1, level));
        }
        return ans;
    }

    private int maxDepthOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepthOfTree(root.left), maxDepthOfTree(root.right)) + 1;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void testCase1() {
        LeetCode1123 leetCode1123 = new LeetCode1123();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode ans = leetCode1123.lcaDeepestLeaves(root);
        assert ans.val == 2;
    }

    @Test
    public void testCase2() {
        LeetCode1123 leetCode1123 = new LeetCode1123();

        TreeNode root = new TreeNode(1);

        TreeNode ans = leetCode1123.lcaDeepestLeaves(root);
        assert ans.val == 1;
    }

    @Test
    public void testCase3() {
        LeetCode1123 leetCode1123 = new LeetCode1123();

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode ans = leetCode1123.lcaDeepestLeaves(root);
        assert ans.val == 2;
    }

    @Test
    public void testCase4() {
        LeetCode1123 leetCode1123 = new LeetCode1123();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode ans = leetCode1123.lcaDeepestLeavesV2(root);
        assert ans.val == 2;
    }

    @Test
    public void testCase5() {
        LeetCode1123 leetCode1123 = new LeetCode1123();

        TreeNode root = new TreeNode(1);

        TreeNode ans = leetCode1123.lcaDeepestLeavesV2(root);
        assert ans.val == 1;
    }

    @Test
    public void testCase6() {
        LeetCode1123 leetCode1123 = new LeetCode1123();

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode ans = leetCode1123.lcaDeepestLeavesV2(root);
        assert ans.val == 2;
    }
}
