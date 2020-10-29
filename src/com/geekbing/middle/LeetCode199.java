package com.geekbing.middle;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/submissions/
 * 199. 二叉树的右视图
 *
 * @author bing
 */
public class LeetCode199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            ans.add(stack.peek().val);
            int levelSize = stack.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = stack.poll();
                if (cur.right != null) {
                    stack.offer(cur.right);
                }
                if (cur.left != null) {
                    stack.offer(cur.left);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        LeetCode199 leetCode199 = new LeetCode199();
        System.out.println(leetCode199.rightSideView(root));
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
