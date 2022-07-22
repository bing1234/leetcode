package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author bing
 */
public class LeetCode270 {
    public int closestValue(TreeNode root, double target) {
        int ans = Integer.MAX_VALUE;
        double minDiff = Double.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur == null) {
                int val = stack.pop().val;
                double curDiff = Math.abs(val - target);
                if (curDiff > minDiff) {
                    return ans;
                }
                ans = val;
                minDiff = curDiff;
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                stack.push(cur);
                stack.push(null);
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        return ans;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void testCase1() {
        LeetCode270 leetCode270 = new LeetCode270();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        int ans = leetCode270.closestValue(root, 3.714286D);
        assert ans == 4;
    }
}
