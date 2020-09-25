package com.geekbing.middle;

import java.util.ArrayList;
import java.util.List;

public class LeetCode113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();

        List<List<Integer>> paths = pathsOfTree(root);
        for (List<Integer> path : paths) {
            if (path.stream().mapToInt(Integer::intValue).sum() == sum) {
                ans.add(path);
            }
        }
        return ans;
    }

    private List<List<Integer>> pathsOfTree(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (root.left == null && root.right == null) {
            List<Integer> path = new ArrayList<>();
            path.add(root.val);
            ans.add(path);
            return ans;
        }
        List<List<Integer>> left = pathsOfTree(root.left);
        if (!left.isEmpty()) {
            for (List<Integer> path : left) {
                path.add(0, root.val);
                ans.add(path);
            }
        }

        List<List<Integer>> right = pathsOfTree(root.right);
        if (!right.isEmpty()) {
            for (List<Integer> path : right) {
                path.add(0, root.val);
                ans.add(path);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode113 leetCode113 = new LeetCode113();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(leetCode113.pathSum(root, 22));
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
