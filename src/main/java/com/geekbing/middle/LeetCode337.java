package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode337 {
    private final Map<TreeNode, Integer> cache = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (cache.containsKey(root)) {
            return cache.get(root);
        }
        int ans = root.val;
        if (root.left != null) {
            ans += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            ans += rob(root.right.left) + rob(root.right.right);
        }
        ans = Math.max(ans, rob(root.left) + rob(root.right));
        cache.put(root, ans);
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

    @Test
    public void testCase1() {
        LeetCode337 leetCode337 = new LeetCode337();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        assert leetCode337.rob(root) == 7;
    }

    @Test
    public void testCase2() {
        LeetCode337 leetCode337 = new LeetCode337();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(1);
        assert leetCode337.rob(root) == 9;
    }
}
