package com.geekbing.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode5532 {
    public boolean isEvenOddTree(TreeNode root) {
        List<List<Integer>> levels = levelOrder(root);
        for (int i = 0; i < levels.size(); i++) {
            if (i % 2 == 0) {
                if (!isEvenLevel(levels.get(i))) {
                    return false;
                }
            } else {
                if (!isOddLevel(levels.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 是否是偶数层
     */
    private boolean isEvenLevel(List<Integer> level) {
        for (int i = 0; i < level.size(); i++) {
            if (level.get(i) % 2 == 0) {
                return false;
            }
            if (i > 0 && (level.get(i - 1) >= level.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否是奇数层
     */
    private boolean isOddLevel(List<Integer> level) {
        for (int i = 0; i < level.size(); i++) {
            if (level.get(i) % 2 == 1) {
                return false;
            }
            if (i > 0 && (level.get(i - 1) <= level.get(i))) {
                return false;
            }
        }
        return true;
    }

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
        TreeNode root= new TreeNode(1);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(12);
        root.left.left.right = new TreeNode(8);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.left.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(2);

        LeetCode5532 leetCode5532 = new LeetCode5532();
        System.out.println(leetCode5532.isEvenOddTree(root));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
