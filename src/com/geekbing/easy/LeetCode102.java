package com.geekbing.easy;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 队列的大小就是当前层的大小
            int levelSize = queue.size();
            List<Integer> levelVals = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                levelVals.add(node.val);
            }
            result.add(levelVals);
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode102 leetCode102 = new LeetCode102();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(leetCode102.levelOrder(root));
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
