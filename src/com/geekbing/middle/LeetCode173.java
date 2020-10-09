package com.geekbing.middle;

import java.util.Stack;

public class LeetCode173 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(root);

        System.out.println(iterator.next());    // 返回 3
        System.out.println(iterator.next());    // 返回 7
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next());    // 返回 9
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next());    // 返回 15
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next());    // 返回 20
        System.out.println(iterator.hasNext()); // 返回 false
    }

    private static class BSTIterator {
        private final Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            travelLeft(root);
        }

        private void travelLeft(TreeNode root) {
            if (root != null) {
                stack.push(root);
                travelLeft(root.left);
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                travelLeft(cur.right);
            }
            return cur.val;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
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
