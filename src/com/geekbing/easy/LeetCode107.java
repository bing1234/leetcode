package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        LeetCode107 leetCode107 = new LeetCode107();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(leetCode107.levelOrderBottom(root));
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
