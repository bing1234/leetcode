package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            result.add(String.valueOf(root.val));
            return result;
        }
        if (root.left != null) {
            List<String> leftPaths = binaryTreePaths(root.left);
            for (String path : leftPaths) {
                result.add(root.val + "->" + path);
            }
        }
        if (root.right != null) {
            List<String> rightPaths = binaryTreePaths(root.right);
            for (String path: rightPaths){
                result.add(root.val + "->" + path);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode257 leetCode257 = new LeetCode257();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(leetCode257.binaryTreePaths(root));
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
