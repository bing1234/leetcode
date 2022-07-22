package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author bing
 */
public class LeetCode662 {
    public int widthOfBinaryTree(TreeNode root) {
        // 层次遍历
        List<List<Node>> levels = levelTravel(root);
        int max = 0;
        for (List<Node> level : levels) {
            max = Math.max(max, level.get(level.size() - 1).idx - level.get(0).idx + 1);
        }
        return max;
    }

    private List<List<Node>> levelTravel(TreeNode root) {
        List<List<Node>> levels = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0));
        while (!queue.isEmpty()) {
            List<Node> level = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                level.add(cur);
                if (cur.left != null) {
                    Node left = new Node(cur.left, cur.idx * 2 + 1);
                    queue.offer(left);
                }
                if (cur.right != null) {
                    Node right = new Node(cur.right, cur.idx * 2 + 2);
                    queue.offer(right);
                }
            }
            levels.add(level);
        }
        return levels;
    }


    private static class Node extends TreeNode {
        int idx;

        public Node(TreeNode node, int idx) {
            this.left = node.left;
            this.right = node.right;
            this.val = node.val;
            this.idx = idx;
        }
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
    }

    @Test
    public void testCase1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        LeetCode662 leetCode662 = new LeetCode662();
        int ans = leetCode662.widthOfBinaryTree(root);
        assert ans == 4;
    }

    @Test
    public void testCase2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        LeetCode662 leetCode662 = new LeetCode662();
        int ans = leetCode662.widthOfBinaryTree(root);
        assert ans == 2;
    }

    @Test
    public void testCase3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);

        LeetCode662 leetCode662 = new LeetCode662();
        int ans = leetCode662.widthOfBinaryTree(root);
        assert ans == 2;
    }

    @Test
    public void testCase4() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(7);

        LeetCode662 leetCode662 = new LeetCode662();
        int ans = leetCode662.widthOfBinaryTree(root);
        assert ans == 8;
    }

}
