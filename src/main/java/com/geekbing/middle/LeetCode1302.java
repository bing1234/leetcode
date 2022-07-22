package com.geekbing.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode1302 {
    private int maxLevel;
    private int ans;

    public int deepestLeavesSum(TreeNode root) {
        maxLevel = 0;
        ans = 0;
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (level > maxLevel) {
                maxLevel = level;
                ans = root.val;
            } else if (level == maxLevel) {
                ans += root.val;
            }
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public int deepestLeavesSumv2(TreeNode root) {
        List<List<TreeNode>> levels = levelTravel(root);
        int ans = 0;
        for (TreeNode node : levels.get(levels.size() - 1)) {
            ans += node.val;
        }
        return ans;
    }

    private List<List<TreeNode>> levelTravel(TreeNode root) {
        List<List<TreeNode>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<TreeNode> level = new ArrayList<>();
            int i = 0;
            while (i < levelSize) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                level.add(node);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                i++;
            }
            ans.add(level);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1302 leetCode1302 = new LeetCode1302();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);
        System.out.println(leetCode1302.deepestLeavesSum(root));
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
