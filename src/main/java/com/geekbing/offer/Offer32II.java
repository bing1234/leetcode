package com.geekbing.offer;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class Offer32II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                level.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            levels.add(level);
        }
        return levels;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void testCase1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Offer32II offer32II = new Offer32II();
        List<List<Integer>> ans = offer32II.levelOrder(root);
        List<List<Integer>> expert = new ArrayList<>();
        expert.add(new ArrayList<>(Collections.singletonList(3)));
        expert.add(new ArrayList<>(Arrays.asList(9, 20)));
        expert.add(new ArrayList<>(Arrays.asList(15, 7)));

        assert expert.equals(ans);
    }
}
