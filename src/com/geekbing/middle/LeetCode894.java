package com.geekbing.middle;

import java.util.ArrayList;
import java.util.List;

public class LeetCode894 {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> ans = new ArrayList<>();
        if (N == 1) {
            TreeNode root = new TreeNode(0);
            ans.add(root);
            return ans;
        }
        if (N == 3) {
            TreeNode root = new TreeNode(0);
            root.left = new TreeNode(0);
            root.right = new TreeNode(0);
            ans.add(root);
            return ans;
        }
        int i = 1;
        while (2 * i - 1 <= N - 2) {
            List<TreeNode> lefts = allPossibleFBT(2 * i - 1);
            List<TreeNode> rights = allPossibleFBT(N - 2 * i);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode894 leetCode894 = new LeetCode894();
        List<TreeNode> trees = leetCode894.allPossibleFBT(7);
        for (TreeNode tree : trees) {
            leetCode894.printTree(tree);
            System.out.println();
        }
    }

    private void printTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printTree(root.left);
            printTree(root.right);
        } else {
            System.out.print("null ");
        }
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
