package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bing
 */
public class LeetCode958 {
    public boolean isCompleteTree(TreeNode root) {
        // 树的高度
        int depth = depthOfTree(root);

        // 当前高度
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 当前层的数量
            int levelSize = queue.size();
            // 校验每层的数量
            if (level != depth && levelSize != Math.pow(2, level - 1)) {
                return false;
            }
            boolean preMiss = false;
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    return false;
                }
                if (cur.left == null && cur.right == null) {
                    preMiss = true;
                } else if (cur.left == null) {
                    return false;
                } else if (cur.right == null) {
                    if (preMiss) {
                        return false;
                    }
                    queue.offer(cur.left);
                    preMiss = true;
                } else {
                    if (preMiss) {
                        return false;
                    }
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
            level++;
        }
        return true;
    }

    private int depthOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depthOfTree(root.left), depthOfTree(root.right)) + 1;
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
        LeetCode958 leetCode958 = new LeetCode958();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        assert leetCode958.isCompleteTree(root);
    }

    @Test
    public void testCase2() {
        LeetCode958 leetCode958 = new LeetCode958();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);

        assert !leetCode958.isCompleteTree(root);
    }

    @Test
    public void testCase3() {
        LeetCode958 leetCode958 = new LeetCode958();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);

        assert !leetCode958.isCompleteTree(root);
    }
}
