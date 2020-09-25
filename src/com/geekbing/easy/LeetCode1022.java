package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1022 {
    public int sumRootToLeaf(TreeNode root) {
        int ans = 0;
        List<String> paths = pathOfTree(root);
        for (String path : paths) {
            ans = ans + convertBinaryStrToInt(path) % 1000000007;
        }
        return ans;
    }

    private List<String> pathOfTree(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (root.left == null && root.right == null) {
            ans.add(String.valueOf(root.val));
            return ans;
        }
        List<String> left = pathOfTree(root.left);
        for (String path : left) {
            ans.add(root.val + path);
        }
        List<String> right = pathOfTree(root.right);
        for (String path : right) {
            ans.add(root.val + path);
        }
        return ans;
    }

    private int convertBinaryStrToInt(String str) {
        int ans = 0;
        int base = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            int curNum = Integer.parseInt(String.valueOf(str.charAt(i)));
            ans += curNum * base;
            base = base * 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1022 leetCode1022 = new LeetCode1022();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(leetCode1022.sumRootToLeaf(root));
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
