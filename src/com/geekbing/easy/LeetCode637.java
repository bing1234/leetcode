package com.geekbing.easy;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode637 {
    public List<Double> averageOfLevels(TreeNode root) {
        
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        LeetCode637 leetCode637 = new LeetCode637();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(leetCode637.averageOfLevels(root));
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
