package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = leafOfTree(root1);
        List<Integer> leaf2 = leafOfTree(root2);
        if (leaf1.size() != leaf2.size()) {
            return false;
        }
        for (int i = 0; i < leaf1.size(); i++) {
            if (!leaf1.get(i).equals(leaf2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> leafOfTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return result;
        } else if (root.left != null && root.right == null) {
            result.addAll(leafOfTree(root.left));
            return result;
        } else if (root.left == null) {
            result.addAll(leafOfTree(root.right));
            return result;
        } else {
            result.addAll(leafOfTree(root.left));
            result.addAll(leafOfTree(root.right));
            return result;
        }
    }

    public static void main(String[] args) {
        LeetCode872 leetCode872 = new LeetCode872();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(8);
        System.out.println(leetCode872.leafOfTree(root));
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
