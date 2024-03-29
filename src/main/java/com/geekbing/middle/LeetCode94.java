package com.geekbing.middle;

import java.util.*;

/**
 * 94. 二叉树的中序遍历. 左、中、右
 *
 * @author bing
 */
public class LeetCode94 {
    /**
     * 递归
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        if (root.left != null) {
            result.addAll(inorderTraversal(root.left));
        }
        result.add(root.val);
        if (root.right != null) {
            result.addAll(inorderTraversal(root.right));
        }
        return result;
    }

    /**
     * 迭代
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode index = root;
        while (index != null || !stack.isEmpty()) {
            if (index != null) {
                stack.push(index);
                index = index.left;
            } else {
                TreeNode node = stack.pop();
                ans.add(node.val);
                index = node.right;
            }
        }
        return ans;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) {
                    stack.push(node.right);
                }
                stack.push(node);
                stack.push(null);
                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                TreeNode cur = stack.pop();
                ans.add(cur.val);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode94 leetCode94 = new LeetCode94();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(leetCode94.inorderTraversal3(root));
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
