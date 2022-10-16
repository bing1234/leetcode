package com.geekbing.todo;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bing
 */
public class LeetCode1161 {
    public int maxLevelSum(TreeNode root) {
        int ans = 1, maxLevelSum = Integer.MIN_VALUE, level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size(), levelSum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                }

                levelSum += cur.val;

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            if (levelSum > maxLevelSum) {
                maxLevelSum = levelSum;
                ans = level;
            }
            level++;
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

    @Test
    public void testCase1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        root.right = new TreeNode(0);

        LeetCode1161 leetCode1161 = new LeetCode1161();
        int ans = leetCode1161.maxLevelSum(root);
        assert ans == 2;
    }

    @Test
    public void testCase2() {
        TreeNode root = new TreeNode(989);
        root.right = new TreeNode(10250);
        root.right.left = new TreeNode(98693);
        root.right.right = new TreeNode(-89388);
        root.right.right.right = new TreeNode(-32127);

        LeetCode1161 leetCode1161 = new LeetCode1161();
        int ans = leetCode1161.maxLevelSum(root);
        assert ans == 2;
    }
}
