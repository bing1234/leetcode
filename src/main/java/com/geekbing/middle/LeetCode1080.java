package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode1080 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return null;
    }

    private int allPathSum(TreeNode root) {
        return allPathSumHelper(root, 0);
    }

    private int allPathSumHelper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum += root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return allPathSumHelper(root.left, sum) + allPathSumHelper(root.right, sum);
    }

    private List<List<Integer>> levelTravel(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
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
            ans.add(level);
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
        LeetCode1080 leetCode1080 = new LeetCode1080();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right = new TreeNode(-99);
        root.left.right.left = new TreeNode(-99);
        root.left.right.right = new TreeNode(-99);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(-99);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(-99);
        root.right.right.right = new TreeNode(14);

        TreeNode newRoot = leetCode1080.sufficientSubset(root, 1);

        List<List<Integer>> ans = levelTravel(newRoot);
        List<List<Integer>> expert = new ArrayList<>();
        expert.add(new ArrayList<>(Collections.singletonList(1)));
        expert.add(new ArrayList<>(Arrays.asList(2, 3)));
        expert.add(new ArrayList<>(Arrays.asList(4, 7)));
        expert.add(new ArrayList<>(Arrays.asList(8, 9, 14)));

        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode1080 leetCode1080 = new LeetCode1080();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(1);
        root.right.left = new TreeNode(17);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(3);

        TreeNode newRoot = leetCode1080.sufficientSubset(root, 22);
        List<List<Integer>> ans = levelTravel(newRoot);
        List<List<Integer>> expert = new ArrayList<>();
        expert.add(new ArrayList<>(Collections.singletonList(5)));
        expert.add(new ArrayList<>(Arrays.asList(4, 8)));
        expert.add(new ArrayList<>(Arrays.asList(11, 17, 4)));
        expert.add(new ArrayList<>(Arrays.asList(7, 1, 5, 3)));

        assert expert.equals(ans);
    }

    @Test
    public void testCase3() {
        LeetCode1080 leetCode1080 = new LeetCode1080();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(-6);
        root.right = new TreeNode(-6);

        TreeNode newRoot = leetCode1080.sufficientSubset(root, 0);
        List<List<Integer>> ans = levelTravel(newRoot);
        assert new ArrayList<>().equals(ans);
    }
}
